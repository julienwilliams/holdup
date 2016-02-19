package com.holdup.player;

import java.util.List;

import com.holdup.MoneyHolder;
import com.holdup.Rules;
import com.holdup.card.Card;
import com.holdup.card.Deck;

public class Player implements MoneyHolder {
	private int money;
	private List<Card> cards;
	public List<Card> getCards() {
		return cards;
	}

	private Card preparedCard;
	
	public void draw(Deck deck) {
		cards.addAll(deck.pick(Rules.NUMBER_OF_CARDS_PICKED));
	}
	
	public void prepare(Card card) {
		
		/* TODO The choice of the card that is played must be made by an AI
		 * We could start by creating a pure random AI that chooses among the cards in a players hand
		 *  */
		
		cards.remove(card);
		preparedCard = card;
	}
	
	public void play() {
		
		/* TODO Prepare card before playing. Action required such as choosing one or more targets 
		 * a good design would be to have a strategy that decides the action.
		 * Each card has different parameters so each strategy must implement specifically for each card.
		 * Start with random configure strategy for each card
		 * 
		 * */
		
		preparedCard.play();
	}
	
	@Override
	public int getAmount() {
		return money;
	}

	@Override
	public void add(int money) {
		this.money += money;
	}

	@Override
	public void substract(int money) {
		this.money -= money;
	}
}
