package com.holdup.player.role;

import com.holdup.player.Player;

public abstract class Role {
	
	protected final static float EVALUATION_ACCEPTABLE_NB_CARDS = 4.0f;
	protected final static float EVALUATION_WIN_CONDITION_PONDERATION = 0.6f;
	protected final static float EVALUATION_NB_CARDS_PONDERATION = 0.4f;
	
	public abstract boolean hasWon(Player player);
	protected abstract float getWinConditionPct(Player player);
	
	public float evaluate(Player player) {
		float pctWinCondition = getWinConditionPct(player);
		
		if (pctWinCondition >= 1.0f) {
			return pctWinCondition;
		} else {
			return (pctWinCondition * EVALUATION_WIN_CONDITION_PONDERATION) + ((float)player.getCards().size() / EVALUATION_ACCEPTABLE_NB_CARDS) * EVALUATION_NB_CARDS_PONDERATION;
		}
	}
}
