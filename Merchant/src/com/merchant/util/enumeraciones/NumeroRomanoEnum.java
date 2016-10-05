/*
 * Copyright 2014
 * Todos los derechos reservados.
 * 
 */

package com.merchant.util.enumeraciones;

/**
 * Enumeracion que contiene los numeros romanos
 * 
 * @author  Marcelo Hidalgo
 * @version 1.0.0, 11/02/2014
 *
 */
public enum NumeroRomanoEnum {

	UNO("I",1),
	CINCO("V",5),
	DIEZ("X",10),
	CINCUENTA("L",50),
	CIEN("C",100),
	QUINIENTOS("D",500),
	MIL("M",1000);
	
	private String simbolo;
	private int valor;
	
	/**
	 * Constructor de la clase 
	 *
	 * @param simbolo
	 * @param valor
	 */
	private NumeroRomanoEnum(String simbolo, int valor) {
		this.simbolo = simbolo;
		this.valor = valor;
	}
	
	public String getSimbolo() {
		return simbolo;
	}
	
	public int getValor() {
		return valor;
	}
	
	
}
