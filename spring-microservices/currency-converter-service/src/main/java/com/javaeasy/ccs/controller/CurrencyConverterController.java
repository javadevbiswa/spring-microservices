package com.javaeasy.ccs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.javaeasy.ccs.model.CurrencyConverterExchange;
import com.javaeasy.ccs.service.CurrencyConverterService;

@RestController
public class CurrencyConverterController {

	@Autowired
	private CurrencyConverterService currencyConverterService;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConverterExchange getCurrencyExchange(@PathVariable String from, @PathVariable String to,
			@PathVariable int quantity) {

		return currencyConverterService.getCurrencyExchangeValue(from, to, quantity);
	}
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConverterExchange getCurrencyExchangeFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable int quantity) {

		return currencyConverterService.getCurrencyExchangeValueFeign(from, to, quantity);
	}
}
