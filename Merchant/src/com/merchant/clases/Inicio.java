/*
 * Copyright 2014
 * Todos los derechos reservados
 */ 
package com.merchant.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.merchant.util.Constantes;
import com.merchant.util.NumeroUtil;
import com.merchant.util.enumeraciones.NumeroRomanoEnum;
import com.merchant.util.enumeraciones.util.NumeroRomanoEnumUtil;

/** 
 * <b>
 * Pantalla de inicio del programa convertidor de numeros romanos a unidades intergalacticas.
 * </b>
 *  
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $ <p>[$Author: Marcelo Hidalgo$, $Date: 11/02/2014 $]</p>
 */
public class Inicio {
	
	protected static List<Unidad> unidades;
	protected static List<Metal> metales;
	private static final int NUMERO_OCHO = 8;
	
	/**
	 * <b>
	 * Metodo Principal que ejecuta  el funcionamiento del conversor.
	 * </b>
	 * <p>[Author: Marcelo Hidalgo, Date: 13/02/2014]</p>
	 *
	 */ 
	public static void main(String[] args) {
		Scanner entradaEscaner = new Scanner(System.in);
		presentarMensajesIniciales();
		String numeroCantidadUnidadesNueva = leerNumeroDeCantidadesNuevas(entradaEscaner);
		unidades = instanciarUnidadesMedida(entradaEscaner, numeroCantidadUnidadesNueva);
		presentarNuevasUnidades();
		String opcion = presentarMenuDeOpciones(entradaEscaner);
		long resultado = Long.valueOf(Constantes.VALOR_CERO);
		if (opcion.equals(String.valueOf(Constantes.VALOR_UNO))){
			resultado = convertirNuevaUnidadesToArabicos(entradaEscaner, resultado);
			System.out.println("El resultado es:" + resultado);
		}else {
			String numeroCantidadMetales = leerNumeroCantidadMetales(entradaEscaner);
			metales = instanciarMetales(entradaEscaner, numeroCantidadMetales);
			presentarMetalesAComercializar();
			calcularEquivalenciaDeMetal(entradaEscaner, resultado);
		}
	}

	/**
	 * <b>
	 * Calcula la equivalencia en arabicos del metal a comercializar.
	 * </b>
	 * <p>[Author: Marcelo Hidalgo, Date: 13/02/2014]</p>
	 *
	 * @param entradaEscaner
	 * @param resultado
	 */ 
	private static void calcularEquivalenciaDeMetal(Scanner entradaEscaner,	long resultado) {
		System.out.println("Ingrese el nombre del metal:");
		String metal = entradaEscaner.nextLine();
		while (Constantes.CADENA_VACIA.equals(Metal.obtenerValorSegunMetal(metales, metal))) {
			System.out.println("Ingrese el nombre del metal:");
			metal = entradaEscaner.nextLine();
		}
		String valorMetal = Metal.obtenerValorSegunMetal(metales, metal);
		resultado = convertirNuevaUnidadesToArabicos(entradaEscaner, resultado);
		resultado = resultado * Integer.valueOf(valorMetal);
		System.out.println("El resultado es:" + resultado + " creditos");
	}

	/**
	 * <b>
	 * Presenta los metales a comercializar.
	 * </b>
	 * <p>[Author: Marcelo, Date: 13/02/2014]</p>
	 *
	 */ 
	private static void presentarMetalesAComercializar() {
		System.out.println("---*** METALES A COMERCIALIZAR ***---");
		for (Metal metal : metales) {
			System.out.println(metal.getNombre().toUpperCase());
		}
	}

	/**
	 * <b>
	 * Transforma las nuevas unidades creadas a numeros arabicos.
	 * </b>
	 * <p>[Author: Marcelo, Date: 13/02/2014]</p>
	 *
	 * @param entradaEscaner objeto que lee desde consola
	 * @param resultado resultado
	 * @return long
	 */ 
	private static long convertirNuevaUnidadesToArabicos(Scanner entradaEscaner, long resultado) {
		String[] unidadesACalcular = leerCantidadAConvertir(entradaEscaner);
		System.out.println("Convirtiendo...");
		resultado = calcularNumero(unidades, unidadesACalcular, resultado);
		return resultado;
	}

	/**
	 * Presenta nen pantalla las opciones a realizar el sistema 
	 *
	 * @author  mkarcelo Hidalgo - ALES
	 * @version 13/02/2014
	 *  
	 */
	public static String presentarMenuDeOpciones(Scanner entradaEscaner) {
		System.out.println("---*** Que desea hacer?***---");
		System.out.println("1. Calcular a Unidades Intergalacticas");
		System.out.println("2. Calcular Valor de Metales");
		String opcion = entradaEscaner.nextLine();
		while (!NumeroUtil.esNumero(opcion) && 
				(opcion.equals(Constantes.CADENA_VALOR_UNO) || opcion.equals(Constantes.CADENA_VALOR_DOS))) {
			System.out.println("Número invalido, intente nuevamente");	
			opcion = entradaEscaner.nextLine();
		}
		return opcion;
	}

	/**
	 * <b>
	 * Calcula la cantidad ingresada en las nuevas unidades de medida a numeros arabicos.
	 * </b>
	 * <p>[Author: Marcelo Hidalgo, Date: 13/02/2014]</p>
	 *
	 * @param unidades lista de unidades posibles
	 * @param unidadesACalcular arreglo con cada una de/las unidades a calcular 
	 * @param resultado
	 * @return long resultado obtenido
	 */ 
	public static long calcularNumero(List<Unidad> unidades,String[] unidadesACalcular, long resultado) {
		for (int i = Constantes.VALOR_CERO; i < unidadesACalcular.length - Constantes.VALOR_UNO; i++) {
			String unidad = unidadesACalcular[i];
			String unidadSiguiente = unidadesACalcular[i + Constantes.VALOR_UNO];
			if(obtenerValorSegunNombreUnidad(unidades, unidad) < obtenerValorSegunNombreUnidad(unidades, unidadSiguiente)){
				resultado -= obtenerValorSegunNombreUnidad(unidades, unidad);
			}else {
				resultado += obtenerValorSegunNombreUnidad(unidades, unidad);
			}
		}
		String ultimaUnidad = unidadesACalcular[unidadesACalcular.length - Constantes.VALOR_UNO];
		resultado += obtenerValorSegunNombreUnidad(unidades, ultimaUnidad);
		return resultado;
	}

	/**
	 * <b>
	 * Recupera un arreglo conteniendo cada uno de las unidades a calcular segun las nuevas unidades de medida.
	 * </b>
	 * <p>[Author: Marcelo Hidalgo, Date: 13/02/2014]</p>
	 *
	 * @param entradaEscaner objeto que lee desde consola
	 * @return devuelve  un arreglo conteniendo cada uno de las unidades a calcular
	 */ 
	private static String[] leerCantidadAConvertir(Scanner entradaEscaner) {
		System.out.println("Ingrese la cantidad a convertir");
		String cantidadAConvertir = entradaEscaner.nextLine();
		StringTokenizer tokens = new StringTokenizer(cantidadAConvertir);
		String[] unidadesACalcular = new String[tokens.countTokens()];
		int posicionArreglo = Constantes.VALOR_CERO;
		while (tokens.hasMoreElements()) {
			unidadesACalcular[posicionArreglo] = tokens.nextToken();
			posicionArreglo++;
		}
		return unidadesACalcular;
	}
	
	/**
	 * <b>
	 * Recupera el numero de nuevas unidades de medida a crear.
	 * </b>
	 * <p>[Author: Marcelo Hidalgo, Date: 12/02/2014]</p>
	 *
	 * @param entradaEscaner objeto que lee desde consola
	 * @return cantidad de unidades nuevas a crear
	 */ 
	public static String leerNumeroDeCantidadesNuevas(Scanner entradaEscaner) {
		String cantidadUnidadesMedida = entradaEscaner.nextLine();
		while (!validarCantidadUnidadesDeMedida(cantidadUnidadesMedida)) {
			System.out.println("Numero mayor a 7 o número invalido, intente nuevamente");
			cantidadUnidadesMedida = entradaEscaner.nextLine();
		}
		return cantidadUnidadesMedida;
	}
	
	/**
	 * <b>
	 * Recupera el numero de nuevas unidades de medida a crear.
	 * </b>
	 * <p>[Author: Marcelo Hidalgo, Date: 12/02/2014]</p>
	 *
	 * @param entradaEscaner objeto que lee desde consola
	 * @return cantidad de unidades nuevas a crear
	 */ 
	private static String leerNumeroCantidadMetales(Scanner entradaEscaner) {
		System.out.println("---*** INGRESE EL NUMERO DE METALES A COMERCIALIZAR ***---");
		String cantidadMetales = entradaEscaner.nextLine();
		while (!NumeroUtil.esNumero(cantidadMetales)) {
			System.out.println("Numero invalido, intente nuevamente");
			cantidadMetales = entradaEscaner.nextLine();
		}
		return cantidadMetales;
	}
	
	/**
	 * <b>
	 * Recupera el valor de la unidad de medida enviada.
	 * </b>
	 * <p>[Author: Marcelo Hidalgo, Date: 12/02/2014]</p>
	 *
	 *@param unidades lista de nuevas unidades de medida
	 *@param nombreUnidad nombre de la unidad
	 *@return int valor de la unidad enviada, sino existe devuelve CERO
	 */
	public static int obtenerValorSegunNombreUnidad(List<Unidad> unidades,String nombreUnidad) {
		int valor = Constantes.VALOR_CERO;
		for (Unidad unidad : unidades) {
			if(unidad.getNombre().equals(nombreUnidad)){
				valor = unidad.getValor();
				break;
			}
		}
		return valor;
	}


	/**
	 * <b>
	 * Imprime en consola las nuevas unidades de medida.
	 * </b>
	 * <p>[Author: Marcelo Hidalgo, Date: 12/02/2014]</p>
	 * 
	 */
	private static void presentarNuevasUnidades() {
		System.out.println("Las nuevas unidades son:");
		for (Unidad unidad : unidades) {
			System.out.println("Nombre: " + unidad.getNombre().toUpperCase() + "\t Valor: " + unidad.getValor());
		}
	}

	/**
	 * <b>
	 * Imprime en consola los mensajes iniciales.
	 * </b>
	 * <p>[Author: Marcelo Hidalgo, Date: 12/02/2014]</p>
	 *  
	 */
	private static void presentarMensajesIniciales() {
		System.out.println("---******************************** BIENVENIDO ****************************************---");
		System.out.println("---*** CONVERSOR NUMEROS ROMANOS A UNIDADES INTERGALACTICAS ***---");
		System.out.println("--------NUMEROS ROMANOS Y VALORES POSIBLES----------");
		System.out.println("1.- I \t 1");
		System.out.println("2.- V \t 5");
		System.out.println("3.- X \t 10");
		System.out.println("4.- L \t 50");
		System.out.println("5.- C \t 100");
		System.out.println("6.- D \t 500");
		System.out.println("7.- M \t 1000");
		System.out.println("---*** INGRESE EL NUMERO DE UNIDADES DE MEDIDA A DEFINIR (MAX 7) ***---");
	}

	/**
	 * <b>
	 * Construye los objetos nuevos de unidad de medida.
	 * </b>
	 * <p>[Author: Marcelo Hidalgo, Date: 12/02/2014]</p>
	 * 
	 * @param entradaEscaner objeto que lee desde consola
	 * @param cantidadUnidadesMedida cantidad de nuevas unidades a construir
	 * @return List<Unidad> lista de unidades instanciadas
	 */
	public static List<Unidad> instanciarUnidadesMedida(Scanner entradaEscaner, String cantidadUnidadesMedida) {
		List<Unidad> unidades = new ArrayList<Unidad>();
		for (int i = Constantes.VALOR_UNO; i <= Integer.valueOf(cantidadUnidadesMedida); i++) {
			Unidad unidad = instanciarUnidad(entradaEscaner, i, unidades);
			unidades.add(unidad);
		}
		return unidades;
	}
	
	/**
	 * <b>
	 * Construye los objetos nuevos de metales a comercializar.
	 * </b>
	 * <p>[Author: Marcelo Hidalgo, Date: 12/02/2014]</p>
	 * 
	 * @param entradaEscaner objeto que lee desde consola
	 * @param cantidadMetales cantidad de metales a comercializar
	 * @return List<Metal> lista de unidades instanciadas
	 */
	private static List<Metal> instanciarMetales(Scanner entradaEscaner, String cantidadMetales) {
		List<Metal> metales = new ArrayList<Metal>();
		for (int i = Constantes.VALOR_UNO; i <= Integer.valueOf(cantidadMetales); i++) {
			Metal metal = instanciarMetal(entradaEscaner, i, metales);
			metales.add(metal);
		}
		return metales;
	}

	/**
	 * <b>
	 * Construye los objetos nuevos de unidad de medida.
	 * </b>
	 * <p>[Author: Marcelo Hidalgo, Date: 12/02/2014]</p>
	 * 
	 * @param entradaEscaner objeto que lee desde consola
	 * @param numeroUnidad numero de la unidad a instanciar
	 * @return Unidad devuelve la unidad instanciada
	 */
	private static Unidad instanciarUnidad(Scanner entradaEscaner, int numeroUnidad, List<Unidad> unidades) {
		String nombre;
		String simbolo;
		Unidad unidad = new Unidad();
		System.out.print("Unidad " + numeroUnidad + ": Nombre:");
		nombre = entradaEscaner.nextLine();
		unidad.setNombre(nombre);
		System.out.print("Unidad " + numeroUnidad + ": Valor(" + NumeroRomanoEnumUtil.obtenerSimbolosNumerosRomanos() + "):");
		simbolo = entradaEscaner.nextLine();
		simbolo = validarSimboloIngresado(entradaEscaner, numeroUnidad, simbolo);
		while (validarExistenciaDeUnidadSegunSimbolo(unidades, simbolo, unidad) == null) {
			System.out.print("Unidad " + numeroUnidad + ": Valor(" + NumeroRomanoEnumUtil.obtenerSimbolosNumerosRomanos() + "):");
			simbolo = entradaEscaner.nextLine();
		}
		unidad = validarExistenciaDeUnidadSegunSimbolo(unidades, simbolo, unidad);
		return unidad;
	}
	
	/**
	 * <b>
	 * Construye los objetos nuevos de unidad de medida.
	 * </b>
	 * <p>[Author: Marcelo Hidalgo, Date: 12/02/2014]</p>
	 * 
	 * @param entradaEscaner objeto que lee desde consola
	 * @param numeroUnidad numero de la unidad a instanciar
	 * @return Unidad devuelve la unidad instanciada
	 */
	private static Metal instanciarMetal(Scanner entradaEscaner, int numeroMetal, List<Metal> metales) {
		String nombre;
		String valor;
		Metal metal = new Metal();
		System.out.print("Metal " + numeroMetal + "):");
		nombre = entradaEscaner.nextLine();
		metal.setNombre(nombre);
		System.out.print("Valor(creditos):");
		valor = entradaEscaner.nextLine();
		while (!NumeroUtil.esNumero(valor)) {
			System.out.print("Valor incorrecto, ingrese nuevamente:");
			valor = entradaEscaner.nextLine();
		}
		metal.setValor(valor); 
		return metal;
	}

	/**
	 * <b>
	 * Valida si la nueva unidad a registrar ya fue considerada anteriormente, sino es el caso asigna su respectivo valor.
	 * </b>
	 * <p>[Author: Marcelo Hidalgo, Date: 12/02/2014]</p>
	 * 
	 * @param unidades lista de unidades
	 * @param simbolo nombre o simbolo de la unidad
	 * @param unidad de medida
	 * @return Unidad unidad de medida
	 */
	public static Unidad validarExistenciaDeUnidadSegunSimbolo(List<Unidad> unidades, String simbolo, Unidad unidad) {
		if (unidades.isEmpty()) {
			unidad.setValor(asignarValorSegunNumeroRomano(simbolo.toUpperCase()));
		}else {
			for (Unidad unidadAlmacenada : unidades) {
				if (unidadAlmacenada.getValor() == asignarValorSegunNumeroRomano(simbolo.toUpperCase())) {
					System.out.println("Ya existe una unidad almacenada con el mismo simbolo");
				}else {
					unidad.setValor(asignarValorSegunNumeroRomano(simbolo.toUpperCase()));
				}
			}
		}
		return unidad;
	}

	/**
	 * <b>
	 * Valida si el simbolo escogido para la nueva unidad es valido.
	 * </b>
	 * <p>[Author: Marcelo Hidalgo, Date: 12/02/2014]</p>
	 * 
	 * @param entradaEscaner objeto que lee desde consola
	 * @param numeroUnidad numero de unidad a instanciar
	 * @param simbolo nombre de la unidad enviado
	 * @return 
	 */
	public static String validarSimboloIngresado(Scanner entradaEscaner,int numeroUnidad, String simbolo) {
		while (asignarValorSegunNumeroRomano(simbolo.toUpperCase()) == Constantes.VALOR_CERO) {
			System.out.print("Unidad " + numeroUnidad + ": Valor(" + NumeroRomanoEnumUtil.obtenerSimbolosNumerosRomanos() + "):");
			simbolo = entradaEscaner.next();
		}
		return simbolo;
	}

	/**
	 * <b>
	 * Asigna el valor de la nueva unidad tomando como referencia su equivalencia en numeros romanos.
	 * </b>
	 * <p>[Author: Marcelo Hidalgo, Date: 12/02/2014]</p>
	 * 
	 * @param simbolo nombre de la unidad
	 */
	private static int asignarValorSegunNumeroRomano(String simbolo) {
		NumeroRomanoEnum numeroRomanoEnum = NumeroRomanoEnumUtil.obtenerNumeroRomanoEnumPorSimbolo(simbolo);
		int valor = Constantes.VALOR_CERO;
		if (numeroRomanoEnum != null) {
			valor = numeroRomanoEnum.getValor();	
		}else {
			System.out.println("El simbolo ingresado no es correcto");
		}
		return valor;
	}


	/**
	 * Valida si la cantidad ingresada es un numero y si es menor a 8 
	 *
	 * @author  Marcelo Hidalgo - ALES
	 * @version 11/02/2014
	 * 
	 * @param cantidadUnidadesMedida
	 * @return verdadero si cumple las dos condiciones
	 */
	private static boolean validarCantidadUnidadesDeMedida(String cantidadUnidadesMedida) {
		return NumeroUtil.esNumero(cantidadUnidadesMedida)	&& 
			(Integer.valueOf(cantidadUnidadesMedida) > Constantes.VALOR_CERO && Integer.valueOf(cantidadUnidadesMedida) < NUMERO_OCHO);
	}

}
