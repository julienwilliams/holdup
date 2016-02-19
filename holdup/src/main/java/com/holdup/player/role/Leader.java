package com.holdup.player.role;

import com.holdup.player.Player;

public class Leader extends Role {

	private static final int LEADER_WIN_AMOUNT = 5000;

	@Override
	public boolean hasWon(Player player) {
		boolean won = true;
		for (Player p : player.getGame().getPlayers()) {
			if (p.getAmount() < LEADER_WIN_AMOUNT) {
				won = false;
				break;
			}
		}
		return won;
	}

}
