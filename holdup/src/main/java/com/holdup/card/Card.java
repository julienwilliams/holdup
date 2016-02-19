package com.holdup.card;

import com.holdup.Game;
import com.holdup.GameItem;
import com.holdup.ai.AI;
import com.holdup.player.Player;

public abstract class Card extends GameItem {
	
	public Card(Game game) {
		super(game);
	}

	public abstract void play(AI ai);
	
	protected Player owner;

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}
}
