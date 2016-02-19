package com.holdup.card.config;

public interface Configurable<T extends Configuration> {
	void configure(T config);
}
