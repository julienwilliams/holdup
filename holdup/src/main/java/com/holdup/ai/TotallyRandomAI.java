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
import com.holdup.card.equipment.LargeBagCard;
import com.holdup.card.equipment.MatraqueCard;
import com.holdup.card.equipment.PanierDePartageCard;
import com.holdup.card.equipment.PiegeCard;
import com.holdup.card.equipment.PorteVoixCard;
import com.holdup.card.equipment.RevitaillementCard;
import com.holdup.card.equipment.SilencerCard;
import com.holdup.player.Player;


public class TotallyRandomAI implements AI {
	private final SecureRandom random = new SecureRandom();

	@Override
	public Card chooseCard(Player player) {
		return player.getCards().get(random.nextInt(player.getCards().size()));
	}

	@Override
	public void configure(SilencerCard card) {
		List<Player> eligiblePlayers = new ArrayList<Player>();
		Game game = card.getGame();
		for (Player player : game.getPlayers()) {
			if (player != game.getCurrentTurn().getCurrentPlayer()) {
				eligiblePlayers.add(player);
			}
		}
		
		Player target = eligiblePlayers.get(random.nextInt(eligiblePlayers.size()));
		card.setTarget(target);
	}

	@Override
	public void configure(PorteVoixCard card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configure(PanierDePartageCard card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configure(MatraqueCard card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configure(LargeBagCard card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configure(GadgetDeDistractionCard card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configure(DeuxPistoletCard card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configure(CouteauCard card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configure(PiegeCard card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configure(RevitaillementCard card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configure(CleDuCoffreCard card) {
		// TODO Auto-generated method stub
		
	}
	
}
