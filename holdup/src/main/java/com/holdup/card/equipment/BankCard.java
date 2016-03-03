package com.holdup.card.equipment;

import com.holdup.Game;
import com.holdup.ai.AI;
import com.holdup.card.Card;
import com.holdup.card.action.Action;
import com.holdup.card.action.MoneyTransfer;

public class BankCard extends Card {

	private final static int BANK_CARD_AMOUNT = 2000;
	
	public BankCard(Game game) {
		super(game);
	}

	@Override
	public Action play(AI ai) {
		return MoneyTransfer.create(game.getBank(), owner, BANK_CARD_AMOUNT);
	}

	@Override
	public String toString() {
		return "Banque";
	}
}
