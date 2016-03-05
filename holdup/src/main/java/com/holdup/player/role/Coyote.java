package com.holdup.player.role;

import com.holdup.player.Player;

public class Coyote extends Role {

	private static final int COYOTE_WIN_AMOUNT = 12000;

	public Coyote() {
	}

	public boolean hasWon(Player player) {
		return player.getAmount() >= COYOTE_WIN_AMOUNT;
	}

	@Override
	public String toString() {
		return "Coyote";
	}

	@Override
	protected float getWinConditionPct(Player player) {
		return (float)player.getAmount() / (float)COYOTE_WIN_AMOUNT;
	}
}
