package com.holdup.ai;

import com.holdup.Turn;
import com.holdup.card.Card;
import com.holdup.card.config.Configurable;
import com.holdup.card.config.OnePlayerConfiguration;
import com.holdup.player.Player;

public interface AI {
	Card chooseCard(Player player);
	void configure(Configurable<OnePlayerConfiguration> configurable, Turn t);
}
