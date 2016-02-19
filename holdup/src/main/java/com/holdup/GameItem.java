package com.holdup;

public abstract class GameItem {
	protected final Game game;

	public GameItem(Game game) {
		this.game = game;
	}

	public Game getGame() {
		return game;
	}
}
