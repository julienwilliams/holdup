package com.holdup.card.equipment;

import com.holdup.Game;
import com.holdup.ai.AI;
import com.holdup.card.Card;
import com.holdup.card.action.Action;
import com.holdup.card.action.MoneyTransfer;

public class GrosSacCard extends Card {

	private final static int CARD_AMOUNT = 3000;
	
	public GrosSacCard(Game game) {
		super(game);
	}
	
	@Override
	public Action play(AI ai) {
		return MoneyTransfer.create(game.getBank(), owner, CARD_AMOUNT);
	}

	@Override
	public String toString() {
		return "Gros Sac";
	}
}
