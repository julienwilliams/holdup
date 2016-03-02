package com.holdup.player.role;

import com.holdup.player.Player;

public class Leader extends Role {

	private static final int LEADER_WIN_AMOUNT = 5000 ;

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

	@Override
	public String toString() {
		return "Leader";
	}

	@Override
	protected float getWinConditionPct(Player player) {
		float accWinPct = 0.0f;
		for (Player p : player.getGame().getPlayers()) {
			accWinPct += Math.max((float)p.getAmount() / LEADER_WIN_AMOUNT, 1.0f);
		}
		
		return (float)accWinPct / player.getGame().getPlayers().size();
	}
}
