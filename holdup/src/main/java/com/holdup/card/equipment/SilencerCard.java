package com.holdup.card.equipment;

import com.holdup.Game;
import com.holdup.Utils;
import com.holdup.player.Player;

public class SilencerCard extends EquipmentCard {

	/* Silencer : steal 2000 to any player */
	
	public SilencerCard(Game game) {
		super(game);
	}

	private Player target;
	
	public void configure(Player target) {
		this.target = target;
	}
	
	@Override
	public void play() {
		Utils.TransferMoney(target, owner, 2000);
	}
}
