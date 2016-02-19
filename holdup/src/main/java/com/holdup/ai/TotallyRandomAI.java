package com.holdup.ai;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import com.holdup.Turn;
import com.holdup.card.Card;
import com.holdup.card.config.Configurable;
import com.holdup.card.config.OnePlayerConfiguration;
import com.holdup.player.Player;


public class TotallyRandomAI implements AI {
	private final SecureRandom random = new SecureRandom();

	@Override
	public Card chooseCard(Player player) {
		return player.getCards().get(random.nextInt(player.getCards().size()));
	}

	@Override
	public void configure(Configurable<OnePlayerConfiguration> configurable, Turn t) {
		List<Player> eligiblePlayers = new ArrayList<Player>();
		for (Player player : t.getGame().getPlayers()) {
			if (player != t.getCurrentPlayer()) {
				eligiblePlayers.add(player);
			}
		}
		
		Player target = eligiblePlayers.get(random.nextInt(eligiblePlayers.size()));
		configurable.configure(new OnePlayerConfiguration(target));
	}
}
