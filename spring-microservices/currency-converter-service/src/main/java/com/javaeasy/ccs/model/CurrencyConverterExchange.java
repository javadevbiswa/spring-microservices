package com.javaeasy.ccs.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author Biswa.Sahoo
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConverterExchange implements Serializable {

	private static final long serialVersionUID = -7803339575546176909L;

	private int id;

	private String from;

	private String to;

	private BigDecimal exchangeValue;

	private int quantity;

	private BigDecimal totalValue;

	private int port;

}
