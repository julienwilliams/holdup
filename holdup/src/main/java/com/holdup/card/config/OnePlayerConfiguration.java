package com.holdup.card.config;

import com.holdup.player.Player;

public class OnePlayerConfiguration implements Configuration {
	private final Player target;

	public OnePlayerConfiguration(Player target) {
		this.target = target;
	}

	public Player getTarget() {
		return target;
	}
}
