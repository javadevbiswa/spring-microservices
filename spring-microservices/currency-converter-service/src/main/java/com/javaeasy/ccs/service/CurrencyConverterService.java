package com.javaeasy.ccs.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.javaeasy.ccs.ces.proxy.CurrencyExchangeProxy;
import com.javaeasy.ccs.model.CurrencyConverterExchange;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CurrencyConverterService {

	private static RestTemplate restTemplate;

	@Autowired
	private CurrencyExchangeProxy proxy;

	@Value("${currency-exchange-url}")
	private String currencyExchangeUrl;

	static {
		restTemplate = new RestTemplate();
	}

	public CurrencyConverterExchange getCurrencyExchangeValue(String from, String to, int quantity) {

		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("from", from);
		pathVariables.put("to", to);
		ResponseEntity<CurrencyConverterExchange> lCurrencyConverterExchange = null;

		try {
			lCurrencyConverterExchange = restTemplate.getForEntity(currencyExchangeUrl, CurrencyConverterExchange.class,
					pathVariables);

		} catch (Exception e) {
			System.out.println("CurrencyConverterService.getCurrencyExchangeValue()");
		}
		CurrencyConverterExchange response = lCurrencyConverterExchange.getBody();
		
		log.info("From CurrencyConverterService :: {}", response);

		BigDecimal exchangeValue = response.getExchangeValue();
		return new CurrencyConverterExchange(response.getId(), from, to, exchangeValue, quantity,
				exchangeValue.multiply(BigDecimal.valueOf(quantity)), response.getPort());

	}

	public CurrencyConverterExchange getCurrencyExchangeValueFeign(String from, String to, int quantity) {
		CurrencyConverterExchange response = proxy.retriveCurrencyExchange(from, to);

		log.info("From CurrencyConverterService Feign:: {}", response);
		BigDecimal exchangeValue = response.getExchangeValue();
		return new CurrencyConverterExchange(response.getId(), from, to, exchangeValue, quantity,
				exchangeValue.multiply(BigDecimal.valueOf(quantity)), response.getPort());

	}
}
