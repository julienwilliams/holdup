package com.holdup.card.equipment;

import java.util.Set;

import com.holdup.Game;
import com.holdup.Utils;
import com.holdup.ai.AI;
import com.holdup.player.Player;

public class CleDuCoffreCard extends EquipmentCard {


	/* PiegeCard : Emp�che les prochains joueurs de prendre un �quipement. Vole 1 lingot d'or pour chaque joueur demandant des cartes �quipements */
	
	public CleDuCoffreCard(Game game) {
		super(game);
	}

	private Set<Player> targets;

	@Override
	public void play(AI ai) {
		ai.configure(this);
		if (targets != null) {
			for(Player target : targets) {
				Utils.TransferMoney(target, owner, 1000);
			}
		}
	}
	
	public Set<Player> getTargets() {
		return targets;
	}
	
	public void setTarget(Set<Player> targets) {
		this.targets = targets;
	}
	
	@Override
	public String toString() {
		return "Cl� du Coffre d'�quipement";
	}
}
