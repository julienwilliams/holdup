package com.holdup.ai;

import com.holdup.card.Card;
import com.holdup.card.equipment.SilencerCard;
import com.holdup.player.Player;

public interface AI {
	Card chooseCard(Player player);
	void configure(SilencerCard card);
}
