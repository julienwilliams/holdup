package com.holdup.card.equipment;

import com.holdup.Game;
import com.holdup.Utils;
import com.holdup.ai.AI;
import com.holdup.player.Player;

public class MatraqueCard extends EquipmentCard {

	/* Matraque : force another player to give 3000 to the bank */
	
	public MatraqueCard(Game game) {
		super(game);
	}

	private Player target;


	@Override
	public void play(AI ai) {
		ai.configure(this);
		Utils.TransferMoney(getTarget(), getGame().getBank(), 3000);
	}


	public Player getTarget() {
		return target;
	}


	public void setTarget(Player target) {
		this.target = target;
	}

}
