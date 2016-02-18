package com.holdup.player.role;

import com.holdup.Game;
import com.holdup.player.Player;

public class AccompliceRole extends Role {

	private static final int SOLO_WIN_AMOUNT = 8000;
	private static final int ACCOMPLICE_WIN_AMOUNT = 14000;
	
	private final AccompliceRole accomplice;

	public AccompliceRole(Game game, Player owner, AccompliceRole accomplice) {
		super(game, owner);
		
		this.accomplice = accomplice;
	}

	@Override
	public boolean hasWon() {
		return accomplice == null ? getOwner().getAmount() >= SOLO_WIN_AMOUNT : (getOwner().getAmount() + accomplice.getOwner().getAmount()) >= ACCOMPLICE_WIN_AMOUNT;
	}

}
