package com.holdup.card.equipment;

import com.holdup.Game;
import com.holdup.Utils;
import com.holdup.ai.AI;
import com.holdup.player.Player;

public class PanierDePartageCard extends EquipmentCard {

	/* Panier de partage : vole 2000 d'un joueur et le donne à un autre joueur */
	
	public PanierDePartageCard(Game game) {
		super(game);
	}

	private Player collector;
	private Player target;

	@Override
	public void play(AI ai) {
		ai.configure(this);
		Utils.TransferMoney(getTarget(), getCollector(), 2000);
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
		return "Panier de Partage";
	}
}
