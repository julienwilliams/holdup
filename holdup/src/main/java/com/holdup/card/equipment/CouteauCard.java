package com.holdup.card.equipment;

import com.holdup.Game;
import com.holdup.Utils;
import com.holdup.ai.AI;
import com.holdup.player.Player;

public class CouteauCard extends EquipmentCard {

	/* Couteau : rob 1000 to 2 player */
	
	public CouteauCard(Game game) {
		super(game);
	}

	private Player target1;
	private Player target2;

	
	@Override
	public void play(AI ai) {
		ai.configure(this);
		Utils.TransferMoney(getTarget1(), owner, 1000);
		Utils.TransferMoney(getTarget2(), owner, 1000);
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
}
