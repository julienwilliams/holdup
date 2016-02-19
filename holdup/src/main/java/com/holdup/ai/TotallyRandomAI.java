package com.holdup.ai;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import com.holdup.Game;
import com.holdup.card.Card;
import com.holdup.card.equipment.SilencerCard;
import com.holdup.player.Player;


public class TotallyRandomAI implements AI {
	private final SecureRandom random = new SecureRandom();

	@Override
	public Card chooseCard(Player player) {
		return player.getCards().get(random.nextInt(player.getCards().size()));
	}

	@Override
	public void configure(SilencerCard card) {
		List<Player> eligiblePlayers = new ArrayList<Player>();
		Game game = card.getGame();
		for (Player player : game.getPlayers()) {
			if (player != game.getCurrentTurn().getCurrentPlayer()) {
				eligiblePlayers.add(player);
			}
		}
		
		Player target = eligiblePlayers.get(random.nextInt(eligiblePlayers.size()));
		card.setTarget(target);
	}
}
