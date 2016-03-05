package com.holdup;

import java.util.Arrays;
import java.util.Stack;

import com.holdup.ai.SoSoAI;
import com.holdup.bank.Bank;
import com.holdup.card.Card;
import com.holdup.card.Deck;
import com.holdup.card.equipment.BankCard;
import com.holdup.card.equipment.CouteauCard;
import com.holdup.card.equipment.DeuxPistoletCard;
import com.holdup.card.equipment.GadgetDeDistractionCard;
import com.holdup.card.equipment.MatraqueCard;
import com.holdup.card.equipment.PanierDePartageCard;
import com.holdup.card.equipment.PorteVoixCard;
import com.holdup.card.equipment.SilencieuxCard;
import com.holdup.player.role.Coyote;
import com.holdup.player.role.Greedy;
import com.holdup.player.role.Leader;

public class Holdup {
	
	private final static int NB_GAMES = 50;
	
	public static void main(String[] args) {
		Statistics statistics = new Statistics();
		
		for (int i=0;i<NB_GAMES;i++) {
			Game game = new Game(new SoSoAI(), Arrays.asList(
					new Coyote(),
					new Coyote(),
					new Leader(),
					new Greedy()));
			
			Bank bank = new Bank(Rules.TOTAL_BANK_MONEY);
			
			Stack<Card> cards = new Stack<Card>();
			for (int j=0; j<8; j++) {
				cards.add(new SilencieuxCard(game));
			}

			for (int j=0; j<5; j++) {
				cards.add(new BankCard(game));
			}
			
			cards.add(new CouteauCard(game));
			cards.add(new CouteauCard(game));
			cards.add(new DeuxPistoletCard(game));
			cards.add(new DeuxPistoletCard(game));
			cards.add(new GadgetDeDistractionCard(game));
			cards.add(new GadgetDeDistractionCard(game));
			cards.add(new MatraqueCard(game));
			cards.add(new MatraqueCard(game));
//			cards.add(new GrosSacCard(game));
//			cards.add(new GrosSacCard(game));
			cards.add(new PanierDePartageCard(game));
			cards.add(new PanierDePartageCard(game));
			cards.add(new PorteVoixCard(game));
			cards.add(new PorteVoixCard(game));
			
			Deck discard = new Deck(new Stack<Card>());
			Deck pile = new Deck(cards, discard);
			pile.shuffle();
	
			game.setDeck(pile);
			game.setDiscardDeck(discard);
			game.setBank(bank);

			game.addPlayer("Mireille");
			game.addPlayer("Merveille");
			game.addPlayer("Julien");
			game.addPlayer("Duyien");
			
			statistics.add(game.play());
		}
		statistics.showStats();
	}
}
