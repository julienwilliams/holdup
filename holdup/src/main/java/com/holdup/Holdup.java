package com.holdup;

import java.util.Arrays;
import java.util.Stack;

import com.holdup.ai.TotallyRandomAI;
import com.holdup.bank.Bank;
import com.holdup.card.Deck;
import com.holdup.card.basic.BankCard;
import com.holdup.card.basic.DrawCard;
import com.holdup.card.equipment.CouteauCard;
import com.holdup.card.equipment.DeuxPistoletCard;
import com.holdup.card.equipment.EquipmentCard;
import com.holdup.card.equipment.GadgetDeDistractionCard;
import com.holdup.card.equipment.LargeBagCard;
import com.holdup.card.equipment.MatraqueCard;
import com.holdup.card.equipment.PanierDePartageCard;
import com.holdup.card.equipment.PorteVoixCard;
import com.holdup.card.equipment.SilencerCard;
import com.holdup.player.Player;
import com.holdup.player.role.Accomplice;
import com.holdup.player.role.Coyote;
import com.holdup.player.role.Leader;

public class Holdup {
	public static void main(String[] args) {
		Statistics statistics = new Statistics();
		
		for (int i=0;i<1000;i++) {
			Game game = new Game(new TotallyRandomAI());
			Bank bank = new Bank(26000);
			
			Stack<EquipmentCard> equipmentCards = new Stack<EquipmentCard>();
			for (int j=0; j<10; j++) {
				equipmentCards.add(new SilencerCard(game));
			}
			equipmentCards.add(new CouteauCard(game));
			equipmentCards.add(new CouteauCard(game));
			equipmentCards.add(new DeuxPistoletCard(game));
			equipmentCards.add(new DeuxPistoletCard(game));
			equipmentCards.add(new GadgetDeDistractionCard(game));
			equipmentCards.add(new GadgetDeDistractionCard(game));
			equipmentCards.add(new MatraqueCard(game));
			equipmentCards.add(new MatraqueCard(game));
			equipmentCards.add(new LargeBagCard(game));
			equipmentCards.add(new LargeBagCard(game));
			equipmentCards.add(new PanierDePartageCard(game));
			equipmentCards.add(new PanierDePartageCard(game));
			equipmentCards.add(new PorteVoixCard(game));
			equipmentCards.add(new PorteVoixCard(game));
			
			Deck discard = new Deck(new Stack<EquipmentCard>());
			Deck pile = new Deck(equipmentCards, discard);
			pile.shuffle();
	
			Accomplice accomplice1 = new Accomplice();
			Accomplice accomplice2 = new Accomplice();
			Coyote coyote = new Coyote();
			Leader leader = new Leader();
			
			Player playerAccomplice1 = new Player("Jacques", game, accomplice1);
			Player playerAccomplice2 = new Player("Gilles", game, accomplice2);
			Player playerLeader = new Player("Paul", game, leader);
			Player playerCoyote = new Player("Roger", game, coyote);
			
			playerAccomplice1.draw(pile, Rules.NUMBER_OF_EQUIPMENT_CARDS_PICKED_AT_START);
			playerAccomplice2.draw(pile, Rules.NUMBER_OF_EQUIPMENT_CARDS_PICKED_AT_START);
			playerLeader.draw(pile, Rules.NUMBER_OF_EQUIPMENT_CARDS_PICKED_AT_START);
			playerCoyote.draw(pile, Rules.NUMBER_OF_EQUIPMENT_CARDS_PICKED_AT_START);
			
			playerAccomplice1.draw(new BankCard(game));
			playerAccomplice1.draw(new DrawCard(game));
			playerAccomplice2.draw(new BankCard(game));
			playerAccomplice2.draw(new DrawCard(game));
			playerLeader.draw(new BankCard(game));
			playerLeader.draw(new DrawCard(game));
			playerCoyote.draw(new BankCard(game));
			playerCoyote.draw(new DrawCard(game));
			
			accomplice1.setAccomplice(playerAccomplice2);
			accomplice2.setAccomplice(playerAccomplice1);
			
			game.setDeck(pile);
			game.setDiscardDeck(discard);
			game.setBank(bank);
			game.setPlayers(Arrays.asList(new Player[] {playerAccomplice1, playerAccomplice2, playerLeader, playerCoyote}));
			
			statistics.add(game.play());
		}
		statistics.showStats();
	}
}
