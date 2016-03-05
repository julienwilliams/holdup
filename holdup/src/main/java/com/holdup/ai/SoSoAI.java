package com.holdup.ai;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.google.common.collect.Maps;
import com.holdup.Game;
import com.holdup.card.Card;
import com.holdup.card.action.Action;
import com.holdup.card.equipment.CouteauCard;
import com.holdup.card.equipment.DeuxPistoletCard;
import com.holdup.card.equipment.GadgetDeDistractionCard;
import com.holdup.card.equipment.MatraqueCard;
import com.holdup.card.equipment.PanierDePartageCard;
import com.holdup.card.equipment.PiegeCard;
import com.holdup.card.equipment.PorteVoixCard;
import com.holdup.card.equipment.SilencieuxCard;
import com.holdup.player.Player;
import com.holdup.player.role.Role;


public class SoSoAI implements AI {

	// TODO
	/*
	 * Create a Map<Player, Map<Player, List<Role>>> which is a map of each other player and the list of roles that they can be 
	 * When choosing the card, evaluate the player's win condition but also the other players win conditions after the card is played and ponderate accordingly
	 * Each turn, evaluate every player's possible role with the win conditions for these roles. If determined that
	 * The player is not of that role, remove it from the list for each player's standpoint.
	 * 
	 * 
	 * When configuring the cards, must also iterate in each possible way the card could be played to choose the best.
	 */
	
	private Map<Player, Map<Player, List<Role>>> playerStandpoint_player_roles = null;
	
	@SuppressWarnings("unchecked")
	public void init(Game game) {
		
		List<Player> allPlayers = game.getPlayers();
		
		playerStandpoint_player_roles =  Maps.newHashMap();
		for (Player p : allPlayers) {
			List<Player> otherPlayers = (List<Player>)CollectionUtils.subtract(allPlayers, Collections.singletonList(p));
			playerStandpoint_player_roles.put(p, Maps.<Player, List<Role>>newHashMap());	
		}
	}
	
	public Card chooseCard(Player player) {
		float maxEval = 0.0f;
		Card chosenCard = null;
		for (Card c : player.getCards()) {
			Action action = c.play(this);
			action.doIt();
			float eval = player.getRole().evaluate(player);
			if (eval >= maxEval) {
				chosenCard = c;
				maxEval = eval;
			}
			action.undo();
			
		}
		
		return chosenCard;
	}

	private Player getNextEligiblePlayer(Card card) {
		return getNextEligiblePlayer(card, new ArrayList<Player>());
	}
	
	private Player getNextEligiblePlayer(Card card, Player filterPlayer) {
		List<Player> filter = new ArrayList<Player>();
		filter.add(filterPlayer);
		return getNextEligiblePlayer(card, filter);
	}
	
	private Player getNextEligiblePlayer(Card card, List<Player> filter) {
		List<Player> eligiblePlayers = new ArrayList<Player>();
		Game game = card.getGame();
		for (Player player : game.getPlayers()) {
			if (player != game.getCurrentTurn().getCurrentPlayer() && !filter.contains(player)) {
				eligiblePlayers.add(player);
			}
		}		
		return eligiblePlayers.get(new SecureRandom().nextInt(eligiblePlayers.size()));
	}
	
	public void configure(SilencieuxCard card) {
		card.setTarget(getNextEligiblePlayer(card));
	}

	public void configure(PorteVoixCard card) {
		Player target1 = getNextEligiblePlayer(card);
		card.setTarget1(target1);
		card.setTarget2(getNextEligiblePlayer(card, target1));
	}

	public void configure(PanierDePartageCard card) {
		Player target = getNextEligiblePlayer(card);
		card.setTarget(target);
		card.setCollector(getNextEligiblePlayer(card, target));		
	}

	public void configure(MatraqueCard card) {
		card.setTarget(getNextEligiblePlayer(card));		
	}

	public void configure(GadgetDeDistractionCard card) {
		Player target = getNextEligiblePlayer(card);
		card.setTarget(target);
		card.setCollector(getNextEligiblePlayer(card, target));			
	}

	public void configure(DeuxPistoletCard card) {
		card.setTarget(getNextEligiblePlayer(card));		
	}

	public void configure(CouteauCard card) {
		Player target1 = getNextEligiblePlayer(card);
		card.setTarget1(target1);
		card.setTarget2(getNextEligiblePlayer(card, target1));		
	}

	public void configure(PiegeCard card) {
		// TODO Auto-generated method stub
		
	}
}
