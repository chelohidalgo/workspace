/*
 * Copyright 2014
 * Todos los derechos reservados
 */ 
package com.merchant.clases;

/** 
 * <b>
 * Clase que manejara las unidades de medida definidas para la conversion.
 * </b>
 *  
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $ <p>[$Author: Marcelo Hidalgo$, $Date: 11/02/2014 $]</p>
 */
public class Unidad {

	private String nombre;
	private Double valor;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
}
