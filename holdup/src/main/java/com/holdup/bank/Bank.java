package com.holdup.bank;

import com.holdup.MoneyHolder;

public class Bank implements MoneyHolder, Cloneable {
	private int money;

	public Bank(int money) {
		this.money = money;
	}
	
	public int getMoney() {
		return money;
	}
	
	public int getAmount() {
		return money;
	}

	public void add(int money) {
		this.money += money;
	}

	public void substract(int money) {
		this.money -= money;
	}
}
