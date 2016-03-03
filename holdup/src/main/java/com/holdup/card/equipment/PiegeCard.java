package com.holdup.card.equipment;

import java.util.Set;

import com.holdup.Game;
import com.holdup.ai.AI;
import com.holdup.card.Card;
import com.holdup.card.action.Action;
import com.holdup.player.Player;

public class PiegeCard extends Card {

	/* PiegeCard : rob 2000 for each next player that played a bank card */
	
	public PiegeCard(Game game) {
		super(game);
	}

	private Set<Player> targets;

	@Override
	public Action play(AI ai) {
		// todo define and support these kind of cards
//		ai.configure(this);
//		if (targets != null) {
//			for(Player target : targets) {
//				Utils.TransferMoney(target, owner, 2000);
//			}
//		}
		return null;
	}
	
	public Set<Player> getTargets() {
		return targets;
	}
	
	public void setTarget(Set<Player> targets) {
		this.targets = targets;
	}
	
	@Override
	public String toString() {
		return "Piège";
	}
}
