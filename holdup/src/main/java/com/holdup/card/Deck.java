package com.holdup.card;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.holdup.card.equipment.EquipmentCard;

public class Deck {
	private final Stack<EquipmentCard> cards;
	
	public Deck(Stack<EquipmentCard> cards) {
		this.cards = cards;
	}
	
	public List<EquipmentCard> pick(int nbCards) {
		List<EquipmentCard> pickedCards = new ArrayList<EquipmentCard>(2);
		for (int i=0; i<nbCards;i++) {
			pickedCards.add(cards.pop());
		}
		return pickedCards;
	}
}
