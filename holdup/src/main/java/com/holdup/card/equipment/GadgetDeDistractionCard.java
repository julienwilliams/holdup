package com.holdup.card.equipment;

import com.holdup.Game;
import com.holdup.Utils;
import com.holdup.ai.AI;
import com.holdup.player.Player;

public class GadgetDeDistractionCard extends EquipmentCard {

	/* Gadget de distraction: vole 3000 d'un joueur et le donne à un autre joueur */
	
	public GadgetDeDistractionCard(Game game) {
		super(game);
	}

	private Player collector;
	private Player target;


	@Override
	public void play(AI ai) {
		ai.configure(this);
		Utils.TransferMoney(getTarget(), getCollector(), 3000);
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

}
