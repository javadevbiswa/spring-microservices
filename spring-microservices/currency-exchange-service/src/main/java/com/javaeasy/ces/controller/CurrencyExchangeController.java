package com.javaeasy.ces.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.javaeasy.ces.model.CurrencyExchange;
import com.javaeasy.ces.service.CurrencyExchangeService;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private CurrencyExchangeService currencyExchangeService;

	@GetMapping(value = "currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retriveCurrencyExchange(@PathVariable String from, @PathVariable String to) {


		return currencyExchangeService.getCurrencyExchanges(from, to);
	}
}
