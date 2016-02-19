package com.holdup.card.equipment;

import java.util.Set;

import com.holdup.Game;
import com.holdup.Utils;
import com.holdup.ai.AI;
import com.holdup.player.Player;

public class PiegeCard extends EquipmentCard {

	/* PiegeCard : rob 2000 for each next player that played a bank card */
	
	public PiegeCard(Game game) {
		super(game);
	}

	private Set<Player> targets;

	@Override
	public void play(AI ai) {
		ai.configure(this);
		if (targets != null) {
			for(Player target : targets) {
				Utils.TransferMoney(target, owner, 2000);
			}
		}
	}
	
	public Set<Player> getTargets() {
		return targets;
	}
	
	public void setTarget(Set<Player> targets) {
		this.targets = targets;
	}
}
