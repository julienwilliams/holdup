package com.holdup.card.equipment;

import com.holdup.Game;
import com.holdup.Utils;
import com.holdup.ai.AI;
import com.holdup.bank.Bank;
import com.holdup.player.Player;

public class DeuxPistoletCard extends EquipmentCard  {

	/* Deux Pistolet : rob 1000 to 1 player and 1000 to the bank*/
	
	public DeuxPistoletCard(Game game) {
		super(game);
	}

	private Player player;
	private Bank bank;
	
	@Override
	public void play(AI ai) {
		ai.configure(this);
		Utils.TransferMoney(player, owner, 1000);
		Utils.TransferMoney(bank, owner, 1000);
	}
}
