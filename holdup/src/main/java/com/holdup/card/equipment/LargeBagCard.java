package com.holdup.card.equipment;

import com.holdup.Game;
import com.holdup.Utils;
import com.holdup.ai.AI;

public class LargeBagCard extends EquipmentCard {


	/* Large Bag : rob 3000 from the bank */
	
	public LargeBagCard(Game game) {
		super(game);
	}
	
	@Override
	public void play(AI ai) {
		Utils.TransferMoney(getGame().getBank(), owner, 3000);
	}

}
