package com.holdup;

import java.util.List;

import com.holdup.bank.Bank;
import com.holdup.card.Deck;
import com.holdup.player.Player;

public class Game {
	
	private final Bank bank;
	private final List<Player> players;
	private final Deck deck;
	
	public Game(Bank bank, Deck deck, List<Player> players) {
		this.bank = bank;
		this.deck = deck;
		this.players = players;
	}

	public Bank getBank() {
		return bank;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public Deck getDeck() {
		return deck;
	}
}
