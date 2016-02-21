package com.holdup.card.basic;

import com.holdup.Game;
import com.holdup.Utils;
import com.holdup.ai.AI;

public class BankCard extends BasicCard {

	public BankCard(Game game) {
		super(game);
	}

	/* Take 2000 from the bank */
	@Override
	public void play(AI ai) {
		Utils.TransferMoney(game.getBank(), owner, 2000);
	}

	@Override
	public String toString() {
		return "Banque";
	}
}
