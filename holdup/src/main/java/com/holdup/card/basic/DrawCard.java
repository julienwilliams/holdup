package com.holdup.card.basic;

import com.holdup.Game;

public class DrawCard extends BasicCard {

	public DrawCard(Game game) {
		super(game);
	}

	@Override
	public void play() {
		owner.draw(game.getDeck());
	}
}
