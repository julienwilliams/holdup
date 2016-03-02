package com.holdup.ai;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import com.holdup.Game;
import com.holdup.card.Card;
import com.holdup.card.equipment.CleDuCoffreCard;
import com.holdup.card.equipment.CouteauCard;
import com.holdup.card.equipment.DeuxPistoletCard;
import com.holdup.card.equipment.GadgetDeDistractionCard;
import com.holdup.card.equipment.MatraqueCard;
import com.holdup.card.equipment.PanierDePartageCard;
import com.holdup.card.equipment.PiegeCard;
import com.holdup.card.equipment.PorteVoixCard;
import com.holdup.card.equipment.RevitaillementCard;
import com.holdup.card.equipment.SilencerCard;
import com.holdup.player.Player;
import com.rits.cloning.Cloner;


public class SoSoAI implements AI {

	
	static Player findPlayer(Game game, String name) {
		for (Player p : game.getPlayers()) {
			if (p.getName().equals(name)) {
				return p;
			}
		}
		
		return null;
	}

	static Card findCard(Player player, Class<?> cardClass) {
		for (Card c : player.getCards()) {
			if (c.getClass().equals(cardClass) ) {
				return c;
			}
		}
		
		return null;
	}
	
	// The cloning BS can be replaced by play / unplay each card while evaluating - MUCH FASTER!
	public Card chooseCard(Player player) {
		float maxEval = 0.0f;
		Card chosenCard = null;
		for (Card c : player.getCards()) {
			Game clonedGame = new Cloner().deepClone(player.getGame());
			
			Player clonedPlayer = findPlayer(clonedGame, player.getName());
			Card clonedCard = findCard(clonedPlayer, c.getClass());
			
			clonedCard.play(this);
			float eval = clonedPlayer.getRole().evaluate(clonedPlayer);
			if (eval >= maxEval) {
				chosenCard = c;
			}
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
	
	public void configure(SilencerCard card) {
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

	public void configure(RevitaillementCard card) {
		// TODO Auto-generated method stub
		
	}

	public void configure(CleDuCoffreCard card) {
		// TODO Auto-generated method stub
		
	}
	
}
