package com.holdup.card.equipment;

import com.holdup.Game;
import com.holdup.ai.AI;
import com.holdup.card.Card;
import com.holdup.card.action.Action;
import com.holdup.card.action.ActionList;
import com.holdup.card.action.MoneyTransfer;
import com.holdup.player.Player;

public class CouteauCard extends Card {

	private final static int COUTEAU_AMOUNT_PER_PLAYER = 1000;
	/* Couteau : rob 1000 to 2 player */
	
	public CouteauCard(Game game) {
		super(game);
	}

	private Player target1;
	private Player target2;
	
	@Override
	public Action play(AI ai) {
		ai.configure(this);
		return ActionList.create(
				MoneyTransfer.create(getTarget1(), owner, COUTEAU_AMOUNT_PER_PLAYER),
				MoneyTransfer.create(getTarget2(), owner, COUTEAU_AMOUNT_PER_PLAYER)
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
		return "Couteau (t1: " + getTarget1() + " , t2: " + getTarget2() + ")";
	}
}
