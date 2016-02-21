package com.holdup.player.role;

import com.holdup.player.Player;

public class Greedy extends Role {

	public boolean hasWon(Player player) {
		return player.getGame().getBank().getAmount() == 0;
	}

	@Override
	public String toString() {
		return "Greedy";
	}
}
