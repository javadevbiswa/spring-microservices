package com.javaeasy.ces.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class CurrencyExchange implements Serializable {

	private static final long serialVersionUID = 4841795690441290132L;

	@Id
	private int id;

	@Column(name = "currency_from")
	private String from;

	@Column(name = "currency_to")
	private String to;

	private BigDecimal exchangeValue;

	private int port;

	public CurrencyExchange(int id, String from, String to, BigDecimal exchangeValue) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.exchangeValue = exchangeValue;
	}

}
