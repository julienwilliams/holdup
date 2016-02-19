package com.holdup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.holdup.card.Card;
import com.holdup.card.config.Configurable;
import com.holdup.player.Player;

public class Turn extends GameItem {
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	private final Player firstPlayer;
	private Map<Player, Card> player_card = new HashMap<Player, Card>();

	private Player currentPlayer = null;
	
	public Turn(Game game, Player firstPlayer) {
		super(game);
		this.firstPlayer = firstPlayer;
	}
	
	public void play() {
		/* Decide cards to be played face down */
		for (Player player : game.getPlayers()) {
			Card card = game.getAi().chooseCard(player);
			player_card.put(player, card);
		}

		/* Resolve cards */
		List<Player> players = game.getPlayers();
		int i = players.indexOf(firstPlayer);
		int[] indexes = new int[players.size()];
		for (int j=0;j<players.size();j++) {
			indexes[j] = i % players.size();
			i++;
		}
		
		for (int index : indexes) {
			currentPlayer = players.get(index);
			Card card = player_card.get(currentPlayer);
			if (card instanceof Configurable<?>) {
				((Configurable<?>)card).aiConfigure(game.getAi(), this);
			}
		}
	}
}
