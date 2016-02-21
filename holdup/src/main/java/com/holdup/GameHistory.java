package com.holdup;

import java.util.ArrayList;
import java.util.List;

import com.holdup.player.Player;

public class GameHistory {

	private List<Player> winners;
	private int turnCount;
	private List<Turn> turns = new ArrayList<Turn>();

	public GameHistory() {

	}

	public List<Player> getWinners() {
		return winners;
	}

	public int getTurnCount() {
		return turnCount;
	}

	public void setWinners(List<Player> winners) {
		this.winners = winners;
	}

	public void setTurnCount(int turnCount) {
		this.turnCount = turnCount;
	}
	
	public void addTurn(Turn t) {
		turns.add(t);
	}
	
	public List<Turn> getTurns() {
		return turns;
	}
}
