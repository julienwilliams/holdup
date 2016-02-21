package com.holdup.card.equipment;

import com.holdup.Game;
import com.holdup.Utils;
import com.holdup.ai.AI;
import com.holdup.player.Player;

public class SilencerCard extends EquipmentCard {

	/* Silencer : steal 2000 to any player */
	
	public SilencerCard(Game game) {
		super(game);
	}

	private Player target;

	@Override
	public void play(AI ai) {
		ai.configure(this);
		Utils.TransferMoney(target, owner, 2000);
	}
	
	public Player getTarget() {
		return target;
	}
	
	public void setTarget(Player target) {
		this.target = target;
	}
	
	@Override
	public String toString() {
		return "Silencieux";
	}
}
