package com.holdup.card.config;

import com.holdup.Turn;
import com.holdup.ai.AI;

public interface Configurable<T extends Configuration> {
	void configure(T config);
	void aiConfigure(AI ai, Turn t);
}
