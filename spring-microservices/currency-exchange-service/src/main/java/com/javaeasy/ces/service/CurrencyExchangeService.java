package com.javaeasy.ces.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.javaeasy.ces.model.CurrencyExchange;
import com.javaeasy.ces.repository.CurrencyExchangeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CurrencyExchangeService {

	@Autowired
	private Environment env;
	
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;

	public CurrencyExchange getCurrencyExchanges(String from, String to) {

		CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
		log.info("From CurrencyExchangeService :: {}",currencyExchange);
		currencyExchange.setPort(Integer.parseInt(env.getProperty("server.port")));
		return currencyExchange;
	}

}
