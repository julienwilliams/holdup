package com.holdup.card.equipment;

import com.holdup.Game;
import com.holdup.ai.AI;
import com.holdup.card.Card;
import com.holdup.card.action.Action;
import com.holdup.card.action.MoneyTransfer;
import com.holdup.player.Player;

public class GadgetDeDistractionCard extends Card {

	/* Gadget de distraction: vole 3000 d'un joueur et le donne à un autre joueur */
	private final static int CARD_AMOUNT = 3000;
	
	public GadgetDeDistractionCard(Game game) {
		super(game);
	}

	private Player collector;
	private Player target;

	@Override
	public Action play(AI ai) {
		ai.configure(this);
		return MoneyTransfer.create(target, collector, CARD_AMOUNT);
	}


	public Player getCollector() {
		return collector;
	}


	public void setCollector(Player collector) {
		this.collector = collector;
	}


	public Player getTarget() {
		return target;
	}


	public void setTarget(Player target) {
		this.target = target;
	}

	@Override
	public String toString() {
		return "Gadget De Distraction (t: " + getTarget() + ")";
	}
}
