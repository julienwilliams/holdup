package com.holdup.card.equipment;

import com.holdup.Game;
import com.holdup.Utils;
import com.holdup.ai.AI;
import com.holdup.bank.Bank;

public class LargeBagCard extends EquipmentCard {


	/* Large Bag : rob 3000 from the bank */
	
	public LargeBagCard(Game game) {
		super(game);
	}

	private Bank target;
	
	@Override
	public void play(AI ai) {
		ai.configure(this);
		Utils.TransferMoney(target, owner, 3000);
	}


}
