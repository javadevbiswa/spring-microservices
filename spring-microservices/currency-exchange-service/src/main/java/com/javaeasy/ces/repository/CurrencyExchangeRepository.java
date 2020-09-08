package com.javaeasy.ces.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaeasy.ces.model.CurrencyExchange;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Integer> {

	public CurrencyExchange findByFromAndTo(String from, String to);
}
