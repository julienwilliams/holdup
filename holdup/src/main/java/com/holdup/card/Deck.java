package com.holdup.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Deck {
	private final Stack<Card> cards;
	private Deck discard;
	
	public Deck(Stack<Card> cards) {
		this.cards = cards;
	}
	
	public Deck(Stack<Card> cards, Deck discard) {
		this.cards = cards;
		this.discard = discard;
	}
	
	public Stack<Card> getCards() {
		return cards;
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public List<Card> pick(int nbCards) {
		if (discard != null && cards.size() < nbCards ) {
			discard.shuffle();
			cards.addAll(discard.getCards());
			discard.getCards().clear();
		}
		List<Card> pickedCards = new ArrayList<Card>(nbCards);
		for (int i=0; i<nbCards;i++) {
			pickedCards.add(cards.pop());
		}
		return pickedCards;
	}
	
	public void put(Card c) {
		cards.push(c);
	}
}
