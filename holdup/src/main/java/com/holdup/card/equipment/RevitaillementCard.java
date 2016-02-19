package com.holdup.card.equipment;

import com.holdup.Game;
import com.holdup.ai.AI;

public class RevitaillementCard extends EquipmentCard {

	/* Revitaillement : Prend des �quipements de sorte � en avoir 4 dans les mains */
	
	public RevitaillementCard(Game game) {
		super(game);
	}

	@Override
	public void play(AI ai) {
		ai.configure(this);
	}
	
}
