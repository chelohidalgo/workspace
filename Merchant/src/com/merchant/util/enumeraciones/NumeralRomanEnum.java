package com.merchant.util.enumeraciones;

/**
 * Enumeracion que contiene los numeros romanos
 * 
 * @author  Marcelo Hidalgo
 * @version 1.0.0, 11/02/2014
 *
 */
public enum NumeralRomanEnum {

	THOUSAND("M",1000),
	NINE_HUNDRED("CM",900),
	FIVE_HUNDRED("D",500),
	FOUR_HUNDRED("CD",400),
	HUNDRED("C",100),
	NINETY("XC",90),
	FIFTY("L",50),
	FORTY("XL",40),
	TEN("X",10),
	NINE("IX",9),
	FIVE("V",5),
	FOUR("IV",4),
	ONE("I",1);
	
	private String symbol;
	private int value;
	
	private NumeralRomanEnum(String symbol, int value) {
		this.symbol = symbol;
		this.value = value;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public int getValue() {
		return value;
	}
	
	
}
