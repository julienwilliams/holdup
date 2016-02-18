package com.holdup.player.role;

import com.holdup.Game;
import com.holdup.player.Player;

public class GreedyRole extends Role {

	public GreedyRole(Game game, Player owner) {
		super(game, owner);
	}

	@Override
	public boolean hasWon() {
		return game.getBank().getAmount() == 0;
	}

}
