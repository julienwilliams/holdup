package com.holdup.player.role;

import com.holdup.Game;
import com.holdup.player.Player;

public class LeaderRole extends Role {

	private static final int LEADER_WIN_AMOUNT = 5000;

	public LeaderRole(Game game, Player owner) {
		super(game, owner);
	}

	@Override
	public boolean hasWon() {
		boolean won = true;
		for (Player player : game.getPlayers()) {
			if (player.getAmount() < LEADER_WIN_AMOUNT) {
				won = false;
				break;
			}
		}
		return won;
	}

}
