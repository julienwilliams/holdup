package com.holdup;

import java.util.ArrayList;
import java.util.List;

import com.holdup.ai.AI;
import com.holdup.bank.Bank;
import com.holdup.card.Deck;
import com.holdup.player.Player;

public class Game {
	
	private final AI ai;

	private Bank bank;
	private List<Player> players;
	private Deck deck;
	private Deck discardDeck;
	private Turn currentTurn;

	public Game(AI ai) {
		this.ai = ai;
	}
	
	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public void setDiscardDeck(Deck discardDeck) {
		this.discardDeck = discardDeck;
	}

	public void setCurrentTurn(Turn currentTurn) {
		this.currentTurn = currentTurn;
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
	
	GameHistory play() {
		List<Player> winners = new ArrayList<Player>();
		int i = 0;
		GameHistory history = new GameHistory();
		while (winners.isEmpty()) {
			Turn t = new Turn(this, players.get(i % players.size()));
			currentTurn = t;
			t.play();
						
			/* Evaluate winner(s) */
			for (Player player : players) {
				if (player.hasWon()) {
					winners.add(player);
				}
			}
			history.addTurn(t);
			i++;
		}

		history.setWinners(winners);
		history.setTurnCount(i);
		return history;
	}

}
