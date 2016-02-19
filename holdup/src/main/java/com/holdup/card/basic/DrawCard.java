package com.holdup.card.basic;

import com.holdup.Game;
import com.holdup.ai.AI;

public class DrawCard extends BasicCard {

	public DrawCard(Game game) {
		super(game);
	}

	@Override
	public void play(AI ai) {
		owner.draw(game.getDeck());
	}
}
