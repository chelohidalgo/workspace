
package com.cowprod.core.potrero.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cowprod.core.entidades.Empresa;
import com.cowprod.core.entidades.Producto;

/**
 * <b> Clase entidad para el ingreso de trabajos. </b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 29/06/2012 $]
 *          </p>
 */
@Entity
@Table(name = "ingreso_trabajo")
public class IngresoTrabajo implements Serializable {

	/**
	 * Constructor
	 */
	public IngresoTrabajo() {
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ingreso")
	private Integer idIngreso;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fecha;

	@Column(name = "numero_horas")
	private double numeroHoras;

	@Column(name = "costo_por_hora")
	private double costoPorHora;

	private String razon;

	private double cantidad;

	private double costoUnitario;

	@Column(name = "costo_adicional")
	private double costoAdicional;

	@ManyToOne
	@JoinColumn(name = "id_potrero", nullable = false)
	private Potrero potrero;

	@ManyToOne
	@JoinColumn(name = "id_labor", nullable = false)
	private Labores labores;

	@ManyToOne
	@JoinColumn(name = "id_producto", nullable = false)
	private Producto producto;

	@ManyToOne
	@JoinColumn(name = "id_maquinaria", nullable = false)
	private Maquinaria maquinaria;

	@ManyToOne
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;

	/**
	 * @return the idIngreso
	 */
	public Integer getIdIngreso() {
		return idIngreso;
	}

	/**
	 * @param idIngreso
	 *            the idIngreso to set
	 */
	public void setIdIngreso(Integer idIngreso) {
		this.idIngreso = idIngreso;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha
	 *            the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the numeroHoras
	 */
	public double getNumeroHoras() {
		return numeroHoras;
	}

	/**
	 * @param numeroHoras
	 *            the numeroHoras to set
	 */
	public void setNumeroHoras(double numeroHoras) {
		this.numeroHoras = numeroHoras;
	}

	/**
	 * @return the razon
	 */
	public String getRazon() {
		return razon;
	}

	/**
	 * @param razon
	 *            the razon to set
	 */
	public void setRazon(String razon) {
		this.razon = razon;
	}

	/**
	 * @return the costoAdicional
	 */
	public double getCostoAdicional() {
		return costoAdicional;
	}

	/**
	 * @param costoAdicional
	 *            the costoAdicional to set
	 */
	public void setCostoAdicional(double costoAdicional) {
		this.costoAdicional = costoAdicional;
	}

	/**
	 * @return the potrero
	 */
	public Potrero getPotrero() {
		return potrero;
	}

	/**
	 * @param potrero
	 *            the potrero to set
	 */
	public void setPotrero(Potrero potrero) {
		this.potrero = potrero;
	}

	/**
	 * @return the labores
	 */
	public Labores getLabores() {
		return labores;
	}

	/**
	 * @param labores
	 *            the labores to set
	 */
	public void setLabores(Labores labores) {
		this.labores = labores;
	}

	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * @param producto
	 *            the producto to set
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	/**
	 * @return the cantidad
	 */
	public double getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad
	 *            the cantidad to set
	 */
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the maquinaria
	 */
	public Maquinaria getMaquinaria() {
		return maquinaria;
	}

	/**
	 * @param maquinaria
	 *            the maquinaria to set
	 */
	public void setMaquinaria(Maquinaria maquinaria) {
		this.maquinaria = maquinaria;
	}

	/**
	 * @return the empresa
	 */
	public Empresa getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa
	 *            the empresa to set
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public double getCostoPorHora() {
		return costoPorHora;
	}

	public void setCostoPorHora(double costoPorHora) {
		this.costoPorHora = costoPorHora;
	}

	public double getCostoUnitario() {
		return costoUnitario;
	}

	public void setCostoUnitario(double costoUnitario) {
		this.costoUnitario = costoUnitario;
	}

}
