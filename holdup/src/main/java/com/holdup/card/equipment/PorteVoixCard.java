package com.holdup.card.equipment;

import com.holdup.Game;
import com.holdup.Utils;
import com.holdup.ai.AI;
import com.holdup.bank.Bank;
import com.holdup.player.Player;

public class PorteVoixCard extends EquipmentCard {

	/* rob 4000 from bank, give 1000 to 1 player and 1000 to another player*/
	
	public PorteVoixCard(Game game) {
		super(game);
	}

	private Player target1;
	private Player target2;
	private Bank collector;

	
	@Override
	public void play(AI ai) {
		ai.configure(this);
		Utils.TransferMoney(getCollector(), owner, 2000);
		Utils.TransferMoney(getCollector(), getTarget1(), 1000);
		Utils.TransferMoney(getCollector(), getTarget2(), 1000);
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


	public Bank getCollector() {
		return collector;
	}


	public void setCollector(Bank collector) {
		this.collector = collector;
	}
}
