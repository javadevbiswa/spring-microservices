package com.javaeasy.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaeasy.application.dto.LimitConfigurationDto;
import com.javaeasy.application.service.LimitService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitConfigurationController {

	@Autowired
	private LimitService limitService;

	@GetMapping(value = "/limit", produces = MediaType.APPLICATION_JSON_VALUE)
	public LimitConfigurationDto retriveLimitConfigs() {

		LimitConfigurationDto limitConfigurationDto = limitService.getLimitConfigs();

		return limitConfigurationDto;
	}

	@GetMapping(value = "/fault-tolerence-limit", produces = MediaType.APPLICATION_JSON_VALUE)
	@HystrixCommand(fallbackMethod = "fallBackMethod")
	public LimitConfigurationDto retriveLimitConfigsWithFaultTolerenceExample() {

		throw new RuntimeException("Fault Tolerence Example thrown ");
	}

	public LimitConfigurationDto fallBackMethod() {
		return  new LimitConfigurationDto(1, 10);
	}
}
