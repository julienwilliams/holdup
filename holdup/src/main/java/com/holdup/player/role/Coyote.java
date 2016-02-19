package com.holdup.player.role;

import com.holdup.player.Player;

public class Coyote extends Role {

	private static final int COYOTE_WIN_AMOUNT = 8000;

	public Coyote() {
	}

	public boolean hasWon(Player player) {
		return player.getAmount() >= COYOTE_WIN_AMOUNT;
	}

}
