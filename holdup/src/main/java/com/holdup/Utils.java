package com.holdup;

public class Utils {
	public static void TransferMoney(MoneyHolder from, MoneyHolder to, int amount) {
		int moneyStolen = Math.max(from.getAmount(), amount);
		from.substract(moneyStolen);
		to.add(moneyStolen);
	}
}
