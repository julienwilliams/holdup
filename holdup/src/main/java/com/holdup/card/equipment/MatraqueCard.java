package com.holdup.card.equipment;

import com.holdup.Game;
import com.holdup.ai.AI;
import com.holdup.card.Card;
import com.holdup.card.action.Action;
import com.holdup.card.action.MoneyTransfer;
import com.holdup.player.Player;

public class MatraqueCard extends Card {

	private final static int CARD_AMOUNT = 3000;
	
	public MatraqueCard(Game game) {
		super(game);
	}

	private Player target;

	@Override
	public Action play(AI ai) {
		ai.configure(this);
		return MoneyTransfer.create(getTarget(), getGame().getBank(), CARD_AMOUNT);
	}


	public Player getTarget() {
		return target;
	}


	public void setTarget(Player target) {
		this.target = target;
	}

	@Override
	public String toString() {
		return "Matraque (t: " + getTarget() + ")";
	}
}
