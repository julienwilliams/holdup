package com.holdup.card.equipment;

import com.holdup.Game;
import com.holdup.ai.AI;
import com.holdup.card.Card;
import com.holdup.card.action.Action;
import com.holdup.card.action.ActionList;
import com.holdup.card.action.MoneyTransfer;
import com.holdup.player.Player;

public class DeuxPistoletCard extends Card  {

	private final static int DP_AMOUNT_PER_PLAYER = 1000;
	
	/* Deux Pistolet : rob 1000 to 1 player and 1000 to the bank*/
	
	public DeuxPistoletCard(Game game) {
		super(game);
	}

	private Player target;
	
	@Override
	public Action play(AI ai) {
		ai.configure(this);
		return ActionList.create(
				MoneyTransfer.create(getTarget(), owner, DP_AMOUNT_PER_PLAYER),
				MoneyTransfer.create(getGame().getBank(), owner, DP_AMOUNT_PER_PLAYER)
				);
	}

	public Player getTarget() {
		return target;
	}

	public void setTarget(Player target) {
		this.target = target;
	}

	@Override
	public String toString() {
		return "Deux Pistolets ( t:" + getTarget() + ")";
	}
}
