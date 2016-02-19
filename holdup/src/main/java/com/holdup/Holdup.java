package com.holdup;

import java.util.Arrays;
import java.util.Stack;

import com.holdup.ai.TotallyRandomAI;
import com.holdup.bank.Bank;
import com.holdup.card.Deck;
import com.holdup.card.basic.BankCard;
import com.holdup.card.basic.DrawCard;
import com.holdup.card.equipment.EquipmentCard;
import com.holdup.card.equipment.SilencerCard;
import com.holdup.player.Player;
import com.holdup.player.role.Accomplice;
import com.holdup.player.role.Coyote;
import com.holdup.player.role.Leader;

public class Holdup {
	public static void main(String[] args) {
		
		Game game = new Game(new TotallyRandomAI());
		Bank bank = new Bank(26000);
		
		Stack<EquipmentCard> equipmentCards = new Stack<EquipmentCard>();
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		equipmentCards.add(new SilencerCard(game));
		
		Deck pile = new Deck(equipmentCards);
		Deck discard = new Deck(new Stack<EquipmentCard>());

		Accomplice accomplice1 = new Accomplice();
		Accomplice accomplice2 = new Accomplice();
		Coyote coyote = new Coyote();
		Leader leader = new Leader();
		
		Player playerAccomplice1 = new Player(game, accomplice2);
		Player playerAccomplice2 = new Player(game, accomplice1);
		Player playerLeader = new Player(game, leader);
		Player playerCoyote = new Player(game, coyote);
		
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
		
		game.play();
	}
}
