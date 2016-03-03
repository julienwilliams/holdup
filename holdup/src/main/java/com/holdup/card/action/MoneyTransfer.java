package com.holdup.card.action;

import com.holdup.MoneyHolder;

public class MoneyTransfer implements Action {

	private final MoneyHolder source;
	private final MoneyHolder destination;
	private final int amount;
	
	public static MoneyTransfer create(MoneyHolder source, MoneyHolder destination, int maxAmount) {
		return new MoneyTransfer(source, destination, Math.min(source.getAmount(), maxAmount));
	}
	
	private MoneyTransfer(MoneyHolder source, MoneyHolder destination, int amount) {
		this.source = source;
		this.destination = destination;
		this.amount = amount;
	}

	public void doo() {
		destination.add(amount);
		source.substract(amount);
	}

	public void undo() {
		destination.substract(amount);
		source.add(amount);
	}

}
