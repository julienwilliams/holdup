package com.holdup;

public abstract class GameItem implements Cloneable {
	protected final Game game;

	public GameItem(Game game) {
		this.game = game;
	}

	public Game getGame() {
		return game;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
