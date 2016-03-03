package com.holdup.card.equipment;

import com.holdup.Game;
import com.holdup.ai.AI;
import com.holdup.card.Card;
import com.holdup.card.action.Action;
import com.holdup.card.action.MoneyTransfer;
import com.holdup.player.Player;

public class PanierDePartageCard extends Card {

	private final static int CARD_AMOUNT = 2000;
	
	public PanierDePartageCard(Game game) {
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
		return "Panier de Partage (from: " + getTarget() + " to " + getCollector() + ")";
	}
}
