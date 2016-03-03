package com.holdup.card.equipment;

import com.holdup.Game;
import com.holdup.ai.AI;
import com.holdup.card.Card;
import com.holdup.card.action.Action;
import com.holdup.card.action.ActionList;
import com.holdup.card.action.MoneyTransfer;
import com.holdup.player.Player;

public class PorteVoixCard extends Card {

	private final static int BANK_AMOUNT = 2000;
	private final static int REDIST_AMOUNT = 1000;
	
	public PorteVoixCard(Game game) {
		super(game);
	}

	private Player target1;
	private Player target2;

	
	@Override
	public Action play(AI ai) {
		ai.configure(this);
		return ActionList.create(
				MoneyTransfer.create(getGame().getBank(), owner, BANK_AMOUNT),
				MoneyTransfer.create(getGame().getBank(), getTarget1(), REDIST_AMOUNT),
				MoneyTransfer.create(getGame().getBank(), getTarget1(), REDIST_AMOUNT)
				);
	}


	public Player getTarget1() {
		return target1;
	}


	public void setTarget1(Player target1) {
		this.target1 = target1;
	}


	public Player getTarget2() {
		return target2;
	}


	public void setTarget2(Player target2) {
		this.target2 = target2;
	}

	@Override
	public String toString() {
		return "Porte Voix (t1: " + getTarget1() + ", t2: " + getTarget2() + ")";
	}
}
