package com.holdup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.holdup.player.Player;


public class Statistics {
	private static final boolean ENABLE_DETAILS = false;
	List<GameHistory> gameResults = new ArrayList<GameHistory>();
	Map<String, Integer> roleWon = new HashMap<String, Integer>();
	int totalTurns;
	
	public Statistics() {
	}
	
	public void add(GameHistory history) {
		gameResults.add(history);
	}
	
	public void showStats() {
		for (GameHistory history : gameResults) {
			if (ENABLE_DETAILS) {
				System.out.println("Winner(s) : " + StringUtils.join(history.getWinners(), " | "));
				System.out.println("Number of turns : " + history.getTurnCount());
				printDetails(history);
				System.out.println("----------------------------------------------------------------------");
			}
			addWinnerRoleCount(history);
		}
		printWinPercentage();
		
	}
	
	public void printWinPercentage() {
		
		for (Map.Entry<String, Integer> entry : roleWon.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue() + " wins (" + (entry.getValue() * 100 / (double)gameResults.size()) + "%)");
		}
		System.out.println("Average Number of turns: " + (totalTurns/gameResults.size()));
	}
	
	public void addWinnerRoleCount(GameHistory history) {
		Set<String> winningRoles = new HashSet<String>();
		for (Player winner : history.getWinners()) {
			//Using a Set so the Accomplice only count for 1 win.
			winningRoles.add(winner.getRole().toString());
		}
		
		for (String role : winningRoles) {
			if (roleWon.containsKey(role.toString())) {
				roleWon.put(role.toString(), roleWon.get(role.toString()) + 1);
			} else {
				roleWon.put(role.toString(), 1);
			}
		}
		totalTurns += history.getTurnCount();
	}
	
	private void printDetails(GameHistory history) {
		int i = 0;
		for (Turn t : history.getTurns()) {
			i++;
			System.out.println("Details (turn " + i + "): " + t);
		}
		
		StringBuilder sb = new StringBuilder();
		for (Player p : history.getGame().getPlayers()) {
			sb.append(p);
			sb.append(" (");
			sb.append(p.getAmount());
			sb.append(")");
			sb.append(" | ");
		}
		
		System.out.println("Game End: " + sb.toString());
	}
}
