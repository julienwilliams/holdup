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
		Utils.TransferMoney(target1, owner, 1000);
		Utils.TransferMoney(target2, owner, 1000);
	}
}
