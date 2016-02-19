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
	
	public void draw(Deck deck) {
		cards.addAll(deck.pick(Rules.NUMBER_OF_CARDS_PICKED));
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
