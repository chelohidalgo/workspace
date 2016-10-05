/*
 * Copyright 2014
 * Todos los derechos reservados
 */ 
package com.merchant.clases;

import java.util.List;

import com.merchant.util.Constantes;


/** 
 * <b>
 * Clase que manejara los metales que se comercializan.
 * </b>
 *  
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $ <p>[$Author: Marcelo Hidalgo$, $Date: 11/02/2014 $]</p>
 */
public class Metal {

	private String nombre;
	private String valor;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getValor() {
		return valor;
	}
	
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	/**
	 * Retorna el valor de un metal por su nombre 
	 *
	 * @author  Marcelo Hidalgo
	 * @version 13/02/2014
	 *  
	 */
	public static String obtenerValorSegunMetal(List<Metal> metales, String nombreMetal) {
		String valorMetal = Constantes.CADENA_VACIA;
		for (Metal metal : metales) {
			if(metal.getNombre().equals(nombreMetal)){
				valorMetal = metal.getValor();
				break;
			}
		}
		return valorMetal;
	}
}
