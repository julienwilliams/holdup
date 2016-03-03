package com.holdup.player.role;

import com.holdup.Rules;
import com.holdup.player.Player;

public class Greedy extends Role {

	public boolean hasWon(Player player) {
		return player.getGame().getBank().getAmount() == 0;
	}

	@Override
	public String toString() {
		return "Greedy";
	}

	@Override
	protected float getWinConditionPct(Player player) {
		return 1.0f - ((float)player.getGame().getBank().getAmount() / (float)Rules.TOTAL_BANK_MONEY);
	}
}
