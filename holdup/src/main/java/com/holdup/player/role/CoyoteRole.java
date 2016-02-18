package com.holdup.player.role;

import com.holdup.Game;
import com.holdup.player.Player;

public class CoyoteRole extends Role {

	private static final int COYOTE_WIN_AMOUNT = 8000;

	public CoyoteRole(Game game, Player owner) {
		super(game, owner);
	}

	@Override
	public boolean hasWon() {
		return getOwner().getAmount() >= COYOTE_WIN_AMOUNT;
	}

}
