package com.holdup.player.role;

import com.holdup.player.Player;

public class Accomplice extends Role {

	private static final int SOLO_WIN_AMOUNT = 8000;
	private static final int ACCOMPLICE_WIN_AMOUNT = 14000;
	
	private Player accomplice;

	public Player getAccomplice() {
		return accomplice;
	}

	public void setAccomplice(Player accomplice) {
		this.accomplice = accomplice;
	}

	@Override
	public boolean hasWon(Player player) {
		return accomplice == null ? player.getAmount() >= SOLO_WIN_AMOUNT : (player.getAmount() + accomplice.getAmount()) >= ACCOMPLICE_WIN_AMOUNT;
	}
	
	@Override
	public String toString() {
		return "Accomplice";
	}
}
