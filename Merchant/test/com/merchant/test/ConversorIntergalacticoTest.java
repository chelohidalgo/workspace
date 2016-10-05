/*
 * ConversorIntergalacticoTest.java
 *
 * INDUSTRIAS ALES CA
 *
 * Copyright 2014
 * Todos los derechos reservados.
 * 
 */

package com.merchant.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

import com.merchant.clases.Inicio;
import com.merchant.clases.Unidad;
import com.merchant.util.NumeroUtil;
import com.merchant.util.enumeraciones.util.NumeroRomanoEnumUtil;


/**
 * Test del Conversor Intergalactico, se púede hacer pruebas individuales de cada metodo e ingresar datos por consola
 * 
 * @author  Marcelo Hidalgo
 * @version 1.0.0, 13/02/2014
 *
 */
public class ConversorIntergalacticoTest extends TestCase{

	/**
	 * <b>
	 * Valida que el numero de unidades de medida sea un numero.
	 * </b>
	 * <p>[Author: Marcelo, Date: 13/02/2014]</p>
	 *
	 */
	@Test
	public void testEsNumeroValido() {
		String cantidadUnidadesMedida = "5";
		NumeroUtil.esNumero(cantidadUnidadesMedida);
		Assert.assertEquals(true, NumeroUtil.esNumero(cantidadUnidadesMedida));
	}
	
	/**
	 * <b>
	 * VErifica que el numero ingresado sea 7.
	 * </b>
	 * <p>[Author: Marcelo, Date: 13/02/2014]</p>
	 *
	 */
	@Test
	public void testLeerNumeroDeCantidadesNuevas() {
		Scanner entradaEscaner = new Scanner(System.in);
		Assert.assertEquals("7", Inicio.leerNumeroDeCantidadesNuevas(entradaEscaner));
	}
	
	/**
	 * <b>
	 * Verifica que el simbolo romano escogido sea romano.
	 * </b>
	 * <p>[Author: Marcelo, Date: 13/02/2014]</p>
	 *
	 */
	@Test
	public void testValidarSimboloIngresado() {
		Scanner entradaEscaner = new Scanner(System.in);
		int numeroUnidad= 1;
		String simbolo = "I";
		Assert.assertEquals("I",Inicio.validarSimboloIngresado(entradaEscaner, numeroUnidad, simbolo));
	}

	/**
	 * <b>
	 * Obtiene la cadena con todos los posibles simbolos romanos definidos.
	 * </b>
	 * <p>[Author: Marcelo, Date: 13/02/2014]</p>
	 *
	 */
	@Test
	public void testObtenerSimbolosPosibles() {
		String simbolos = "I,V,X,L,C,D,M,";
		Assert.assertEquals(simbolos,NumeroRomanoEnumUtil.obtenerSimbolosNumerosRomanos());
	}
	
	/**
	 * <b>
	 * Valida si ya existe una unidad creada con el mismo simbolo enviado.
	 * </b>
	 * <p>[Author: Marcelo, Date: 13/02/2014]</p>
	 *
	 */
	@Test
	public void testValidarExistenciaDeUnidadSegunSimbolo() {
		String simbolo = "I";
		Unidad unidad = new Unidad();
		unidad.setNombre("UNO");
		unidad.setValor(1);
		List<Unidad> unidades = new ArrayList<Unidad>();
		unidades.add(unidad);
		Assert.assertEquals(unidad,Inicio.validarExistenciaDeUnidadSegunSimbolo(unidades, simbolo, unidad));
	}
	
	/**
	 * <b>
	 * Lee la opcion deseada a realizar en el programa 1. Calcular a Unidades Intergalacticas/ 2Calcular Valor de Metales.
	 * </b>
	 * <p>[Author: Marcelo, Date: 13/02/2014]</p>
	 *
	 */
	@Test
	public void testLeerOpcionDesdeMenu() {
		Scanner entradaEscaner = new Scanner(System.in);
		String opcion = "1";
		Assert.assertEquals(opcion,Inicio.presentarMenuDeOpciones(entradaEscaner));
	}
	
	/**
	 * <b>
	 * Calucla el numero ingresado en las nuevas unidades creadas, que se basan en los numeros romanos
	 * </b>
	 * <p>[Author: Marcelo, Date: 13/02/2014]</p>
	 *
	 */
	@Test
	public void testCalcularNumero() {
		Unidad unidad1 = new Unidad();
		unidad1.setNombre("UNO");
		unidad1.setValor(1);
		Unidad unidad2 = new Unidad();
		unidad2.setNombre("DOS");
		unidad2.setValor(5);
		Unidad unidad3 = new Unidad();
		unidad3.setNombre("TRES");
		unidad3.setValor(10);
		Unidad unidad4 = new Unidad();
		unidad4.setNombre("CUATRO");
		unidad4.setValor(50);
		Unidad unidad5 = new Unidad();
		unidad5.setNombre("CINCO");
		unidad5.setValor(100);
		Unidad unidad6 = new Unidad();
		unidad6.setNombre("SEIS");
		unidad6.setValor(500);
		Unidad unidad7 = new Unidad();
		unidad7.setNombre("SIETE");
		unidad7.setValor(1000);
		List<Unidad> unidades = new ArrayList<Unidad>();
		unidades.add(unidad1);
		unidades.add(unidad2);
		unidades.add(unidad3);
		unidades.add(unidad4);
		unidades.add(unidad5);
		unidades.add(unidad6);
		unidades.add(unidad7);
		long resultado =0;
		long resultadoEsperado =1903;
		String[] unidadesACalcular = new String[6];
		unidadesACalcular [0] = "SIETE";
		unidadesACalcular [1] = "CINCO";
		unidadesACalcular [2] = "SIETE";
		unidadesACalcular [3] = "UNO";
		unidadesACalcular [4] = "UNO";
		unidadesACalcular [5] = "UNO";
		Assert.assertEquals(resultadoEsperado,Inicio.calcularNumero(unidades, unidadesACalcular, resultado));
	}
	
	@Test
	public void testInstanciarUnidadesMedida(){
		Scanner entradaEscaner = new Scanner(System.in);
		Inicio.instanciarUnidadesMedida(entradaEscaner, "3");
	}
	
	@Test
	public void testPresentarMenuDeOpciones(){
		Scanner entradaEscaner = new Scanner(System.in);
		Inicio.presentarMenuDeOpciones(entradaEscaner);
	}
	
	
}
