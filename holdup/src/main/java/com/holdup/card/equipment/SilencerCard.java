package com.holdup.card.equipment;

import com.holdup.Game;
import com.holdup.Turn;
import com.holdup.Utils;
import com.holdup.ai.AI;
import com.holdup.card.config.Configurable;
import com.holdup.card.config.OnePlayerConfiguration;
import com.holdup.player.Player;

public class SilencerCard extends EquipmentCard implements Configurable<OnePlayerConfiguration> {

	/* Silencer : steal 2000 to any player */
	
	public SilencerCard(Game game) {
		super(game);
	}

	private Player target;
	
	@Override
	public void configure(OnePlayerConfiguration configuration) {
		this.target = configuration.getTarget();
	}
	
	@Override
	public void play() {
		Utils.TransferMoney(target, owner, 2000);
	}

	@Override
	public void aiConfigure(AI ai, Turn t) {
		ai.configure(this, t);
	}
}
