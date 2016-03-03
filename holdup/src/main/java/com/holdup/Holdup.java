package com.holdup;

import java.util.Arrays;
import java.util.Stack;

import com.holdup.ai.SoSoAI;
import com.holdup.bank.Bank;
import com.holdup.card.Card;
import com.holdup.card.Deck;
import com.holdup.card.action.MoneyTransfer;
import com.holdup.card.equipment.BankCard;
import com.holdup.card.equipment.CouteauCard;
import com.holdup.card.equipment.DeuxPistoletCard;
import com.holdup.card.equipment.GadgetDeDistractionCard;
import com.holdup.card.equipment.GrosSacCard;
import com.holdup.card.equipment.MatraqueCard;
import com.holdup.card.equipment.PanierDePartageCard;
import com.holdup.card.equipment.PorteVoixCard;
import com.holdup.card.equipment.SilencieuxCard;
import com.holdup.player.Player;
import com.holdup.player.role.Coyote;
import com.holdup.player.role.Greedy;
import com.holdup.player.role.Leader;

public class Holdup {
	public static void main(String[] args) {
		Statistics statistics = new Statistics();
		
		for (int i=0;i<1000;i++) {
			Game game = new Game(new SoSoAI());
			Bank bank = new Bank(Rules.TOTAL_BANK_MONEY);
			
			Stack<Card> cards = new Stack<Card>();
			for (int j=0; j<8; j++) {
				cards.add(new SilencieuxCard(game));
			}

			for (int j=0; j<8; j++) {
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
			cards.add(new GrosSacCard(game));
			cards.add(new GrosSacCard(game));
			cards.add(new PanierDePartageCard(game));
			cards.add(new PanierDePartageCard(game));
			cards.add(new PorteVoixCard(game));
			cards.add(new PorteVoixCard(game));
			
			Deck discard = new Deck(new Stack<Card>());
			Deck pile = new Deck(cards, discard);
			pile.shuffle();
	
			Coyote coyote = new Coyote();
			Coyote coyote2 = new Coyote();
			Leader leader = new Leader();
			Greedy greedy = new Greedy();
			
			Player playerGreedy = new Player("Jacques", game, greedy);
			Player playerLeader = new Player("Paul", game, leader);
			Player playerCoyote = new Player("Roger", game, coyote);
			Player playerCoyote2 = new Player("Gilles", game, coyote2);
			
			playerGreedy.draw(pile, Rules.NUMBER_OF_EQUIPMENT_CARDS_PICKED_AT_START);
			playerLeader.draw(pile, Rules.NUMBER_OF_EQUIPMENT_CARDS_PICKED_AT_START);
			playerCoyote.draw(pile, Rules.NUMBER_OF_EQUIPMENT_CARDS_PICKED_AT_START);
			playerCoyote2.draw(pile, Rules.NUMBER_OF_EQUIPMENT_CARDS_PICKED_AT_START);
			
			MoneyTransfer.create(bank, playerGreedy, Rules.PLAYER_STARTING_MONEY).doo();
			MoneyTransfer.create(bank, playerLeader, Rules.PLAYER_STARTING_MONEY).doo();
			MoneyTransfer.create(bank, playerCoyote, Rules.PLAYER_STARTING_MONEY).doo();
			MoneyTransfer.create(bank, playerCoyote2, Rules.PLAYER_STARTING_MONEY).doo();
			
			game.setDeck(pile);
			game.setDiscardDeck(discard);
			game.setBank(bank);
			game.setPlayers(Arrays.asList(new Player[] {playerGreedy, playerCoyote2, playerLeader, playerCoyote}));
			
			statistics.add(game.play());
		}
		statistics.showStats();
	}
}
