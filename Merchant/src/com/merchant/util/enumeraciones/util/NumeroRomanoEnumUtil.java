/*
 * Copyright 2014
 * Todos los derechos reservados.
 * 
 */

package com.merchant.util.enumeraciones.util;

import com.merchant.util.Constantes;
import com.merchant.util.enumeraciones.NumeroRomanoEnum;

/**
 * Utilitario para el manejo de la enumeracion de numeros romanos
 * 
 * @author  Marcelo Hidalgo
 * @version 1.0.0, 11/02/2014
 *
 */
public final class NumeroRomanoEnumUtil {

	/**
	 * Devuelve los simbolos de numeros romanos 
	 *
	 * @author  Marcelo Hidalgo
	 * @version 11/02/2014
	 * 
	 * @return 
	 */
	public static String obtenerSimbolosNumerosRomanos() {
		String simbolosNumerosRomanos = Constantes.CADENA_VACIA;
		for (NumeroRomanoEnum romanosEnum : NumeroRomanoEnum.values()) {
			simbolosNumerosRomanos = simbolosNumerosRomanos.concat(romanosEnum.getSimbolo().concat(Constantes.CADENA_COMA));
		}
		return simbolosNumerosRomanos;
	}
	
	/**
	 * Método para la recuperación de una enumeración de tipo NumeroRomanoEnum en base al simbolo. 
	 *
	 * @author  Marcelo Hidalgo
	 * @version 02/08/2013
	 * 
	 * @param simbolo String con el simbolo numero romano.
	 * @return NumeroRomanoEnum enumeracion resultante.
	 */
	public static NumeroRomanoEnum obtenerNumeroRomanoEnumPorSimbolo(final String simbolo) {
		NumeroRomanoEnum romanoEnumEncontrado = null;
		NumeroRomanoEnum[] numerosRomanosEnums = NumeroRomanoEnum.values();
		for (int i = 0; i < numerosRomanosEnums.length; i++) {
			if(numerosRomanosEnums[i].getSimbolo().equals(simbolo)) {
				romanoEnumEncontrado = numerosRomanosEnums[i];
				break;
			}
		}
		return romanoEnumEncontrado;
	}
	
}
