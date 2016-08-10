package com.jwd.spring.currency;

public interface CurrencyConverter {
	public float convert(String currencyFrom, String currencyTo) throws Exception;

}
