package com.holdup.card.equipment;

import com.holdup.Game;
import com.holdup.Utils;
import com.holdup.ai.AI;
import com.holdup.player.Player;

public class DeuxPistoletCard extends EquipmentCard  {

	/* Deux Pistolet : rob 1000 to 1 player and 1000 to the bank*/
	
	public DeuxPistoletCard(Game game) {
		super(game);
	}

	private Player target;
	
	@Override
	public void play(AI ai) {
		ai.configure(this);
		Utils.TransferMoney(getTarget(), owner, 1000);
		Utils.TransferMoney(getGame().getBank(), owner, 1000);
	}

	public Player getTarget() {
		return target;
	}

	public void setTarget(Player target) {
		this.target = target;
	}

	@Override
	public String toString() {
		return "Deux Pistolets";
	}
}
