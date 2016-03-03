package com.holdup.card.equipment;

import com.holdup.Game;
import com.holdup.ai.AI;
import com.holdup.card.Card;
import com.holdup.card.action.Action;
import com.holdup.card.action.MoneyTransfer;
import com.holdup.player.Player;

public class SilencieuxCard extends Card {

	private final static int CARD_AMOUNT = 2000;
	
	public SilencieuxCard(Game game) {
		super(game);
	}

	private Player target;

	@Override
	public Action play(AI ai) {
		ai.configure(this);
		return MoneyTransfer.create(target, owner, CARD_AMOUNT);
	}
	
	public Player getTarget() {
		return target;
	}
	
	public void setTarget(Player target) {
		this.target = target;
	}
	
	@Override
	public String toString() {
		return "Silencieux (t: " + getTarget() + ")";
	}
}
