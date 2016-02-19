package com.holdup;

import java.util.List;

import com.holdup.ai.AI;
import com.holdup.bank.Bank;
import com.holdup.card.Deck;
import com.holdup.player.Player;

public class Game {
	
	private final Bank bank;
	private final List<Player> players;
	private final Deck deck;
	private final Deck discardDeck;
	private final AI ai;
	private Turn currentTurn;

	public Game(Bank bank, Deck deck, Deck discardDeck, AI ai, List<Player> players) {
		this.bank = bank;
		this.deck = deck;
		this.discardDeck = discardDeck;
		this.players = players;
		this.ai = ai;
	}

	public Deck getDiscardDeck() {
		return discardDeck;
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
	
	public Turn getCurrentTurn() {
		return currentTurn;
	}

	public AI getAi() {
		return ai;
	}
	
	void play() {
		boolean winnerFound = false;
		int i = 0;
		while (!winnerFound) {
			Turn t = new Turn(this, players.get(i % players.size()));
			currentTurn = t;
			t.play();
			i++;
		}
	}
}
