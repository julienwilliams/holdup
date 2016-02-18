package com.holdup.player.role;


import com.holdup.Game;
import com.holdup.GameItem;
import com.holdup.Ownable;
import com.holdup.player.Player;

public abstract class Role extends GameItem implements Ownable {
	
	private final Player owner;
	public Role(Game game, Player owner) {
		super(game);
		this.owner = owner;
	}

	public Player getOwner() {
		return owner;
	}

	public abstract boolean hasWon();
}
