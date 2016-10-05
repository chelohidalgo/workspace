/*
 * Copyright 2014
 * Todos los derechos reservados
 */
package com.merchant.util;

/**
 * <b> Clase utilitaria para numeros</b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 11/02/2014 $]
 *          </p>
 */
public class NumeroUtil {

	/**
	 * Funcion para validar si un valor es numero o no.
	 * 
	 * @author Marcelo Hidalgo
	 * @version 11/02/2014
	 * 
	 * @param value
	 *            String con la cadena a ser evaluada.
	 * @return boolean con la respuesta a la validacion.
	 */
	public static boolean esNumero(String value) {
		@SuppressWarnings("unused")
		int dat = 0;
		boolean valor = true;
		if (value != null) {
			try {
				dat = Integer.valueOf(value).intValue();
			} catch (NumberFormatException e) {
				valor = false;
			}
		}
		return valor;
	}

	/**
	 * Funcion para redondear un numero en funcion de numero fijo de decimales
	 * (0).
	 * 
	 * @author Marcelo Hidalgo 
	 * @version 11/02/2014
	 * 
	 * @param numero
	 *            double con el valor del numero a redondear.
	 * @return double con el resultado final redondeado.
	 */
	public static double redondear(double numero) {
		return Math.round(numero * Math.pow(10, Constantes.VALOR_CERO))
				/ Math.pow(10, Constantes.VALOR_CERO);
	}

	/**
	 * Funcion que transforma una cadena a un long.
	 * 
	 * @author Marcelo Hidalgo
	 * @version 11/02/2014
	 * 
	 * @param value
	 *            String con la cadena a ser transformada.
	 * @return boolean con la respuesta a la validacion.
	 */
	public static Long StringToLong(String value) {
		return Long.valueOf(value);
	}
	
}
