package com.holdup.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import com.holdup.card.equipment.EquipmentCard;

public class Deck {
	private final Stack<EquipmentCard> cards;
	private Deck discard;
	
	public Deck(Stack<EquipmentCard> cards) {
		this.cards = cards;
	}
	
	public Deck(Stack<EquipmentCard> cards, Deck discard) {
		this.cards = cards;
		this.discard = discard;
	}
	
	public Stack<EquipmentCard> getCards() {
		return cards;
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public List<EquipmentCard> pick(int nbCards) {
		if (discard != null && cards.size() < nbCards ) {
			discard.shuffle();
			cards.addAll(discard.getCards());
			discard.getCards().clear();
		}
		List<EquipmentCard> pickedCards = new ArrayList<EquipmentCard>(2);
		for (int i=0; i<nbCards;i++) {
			pickedCards.add(cards.pop());
		}
		return pickedCards;
	}
	
	public void put(EquipmentCard c) {
		cards.push(c);
	}
}
