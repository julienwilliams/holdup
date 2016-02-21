package com.holdup.player;

import java.util.ArrayList;
import java.util.List;

import com.holdup.Game;
import com.holdup.GameItem;
import com.holdup.MoneyHolder;
import com.holdup.card.Card;
import com.holdup.card.Deck;
import com.holdup.card.equipment.EquipmentCard;
import com.holdup.player.role.Role;

public class Player extends GameItem implements MoneyHolder {
	
	private final Role role;
	private int money;
	private List<Card> cards = new ArrayList<Card>();
	private final String name;
	
	public Player(String name, Game game, Role role) {
		super(game);
		this.name = name;
		this.role = role;
	}
	
	public void draw(Deck deck, int nb) {
		List<EquipmentCard> picked = deck.pick(nb);
		for (EquipmentCard card : picked) {
			card.setOwner(this);
		}
		cards.addAll(picked);
	}
	
	public void draw(Card card) {
		card.setOwner(this);
		cards.add(card);
	}
	
	public int getAmount() {
		return money;
	}

	public void add(int money) {
		this.money += money;
	}

	public void substract(int money) {
		this.money -= money;
	}
	
	public List<Card> getCards() {
		return cards;
	}
	
	public boolean hasWon() {
		return role.hasWon(this);
	}
	
	public Role getRole() {
		return role;
	}
	
	@Override
	public String toString() {
		return name + " the " + role.getClass().getSimpleName();
	}
}
