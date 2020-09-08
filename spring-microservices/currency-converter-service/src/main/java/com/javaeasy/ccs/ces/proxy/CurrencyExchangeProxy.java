package com.javaeasy.ccs.ces.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.javaeasy.ccs.model.CurrencyConverterExchange;

//@RibbonClient(name = "${currency-exchange-service-app}")
@FeignClient(name = "netflix-zuul-api-gateway")
public interface CurrencyExchangeProxy {

	@GetMapping(value = "/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConverterExchange retriveCurrencyExchange(@PathVariable String from, @PathVariable String to);

}
