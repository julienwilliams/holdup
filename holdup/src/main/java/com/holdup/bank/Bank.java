package com.holdup.bank;

import com.holdup.MoneyHolder;

public class Bank implements MoneyHolder {
	private int money;

	public Bank(int money) {
		this.money = money;
	}
	
	public int getMoney() {
		return money;
	}
	
	@Override
	public int getAmount() {
		return money;
	}

	@Override
	public void add(int money) {
		this.money += money;
	}

	@Override
	public void substract(int money) {
		this.money -= money;
	}
}
