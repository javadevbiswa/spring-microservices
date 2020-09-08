package com.javaeasy.application.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "limit.config")
public class LimitServiceAppConfig {

	private int minimium;
	private int maximium;

	public LimitServiceAppConfig(int minimium, int maximium) {
		this.minimium = minimium;
		this.maximium = maximium;
	}

	public LimitServiceAppConfig() {

	}

	public int getMinimium() {
		return minimium;
	}

	public void setMinimium(int minimium) {
		this.minimium = minimium;
	}

	public int getMaximium() {
		return maximium;
	}

	public void setMaximium(int maximium) {
		this.maximium = maximium;
	}
}
