package com.holdup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import com.google.common.collect.Lists;
import com.holdup.ai.AI;
import com.holdup.bank.Bank;
import com.holdup.card.Deck;
import com.holdup.card.action.MoneyTransfer;
import com.holdup.player.Player;
import com.holdup.player.role.Role;

public class Game {
	
	private final AI ai;
	private final List<Role> rolePool;
	private final Stack<Role> roleStack;

	private Bank bank;
	private List<Player> players = Lists.newArrayList();
	private Deck deck;
	private Deck discardDeck;
	private Turn currentTurn;

	public Game(AI ai, List<Role> roles) {
		this.ai = ai;
		this.rolePool = roles;
		roleStack = new Stack<Role>();
		
		Collections.shuffle(rolePool);
		
		for (Role role : rolePool) {
			roleStack.push(role);
		}
	}

	public void addPlayer(String name) {
		Role role = roleStack.pop();
		Player player = new Player(name, this, role);
		player.draw(deck, Rules.NUMBER_OF_EQUIPMENT_CARDS_PICKED_AT_START);
		MoneyTransfer.create(bank, player, Rules.PLAYER_STARTING_MONEY).doIt();
		players.add(player);
	}
	
	public List<Role> getRolePool() {
		return rolePool;
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
		GameHistory history = new GameHistory(this);
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
