
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

import com.cowprod.core.entidades.Cuenta;
import com.cowprod.core.entidades.Empresa;
import com.cowprod.core.entidades.Producto;

/**
 * <b> Clase entidad de Nutricion. </b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 28/06/2012 $]
 *          </p>
 */
@Entity
@Table(name = "nutricion")
public class Nutricion implements Serializable {

	/**
	 * Constructor por defecto
	 */
	public Nutricion() {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_nutricion")
	private Integer idNutricion;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false, insertable = true, updatable = true)
	private Date fecha;

	@ManyToOne
	@JoinColumn(name = "id_cuenta", nullable = false)
	private Cuenta cuenta;

	@ManyToOne
	@JoinColumn(name = "id_producto", nullable = false)
	private Producto producto;

	@Column(nullable = false)
	private double cantidad;

	@Column(nullable = false)
	private double costo;

	@ManyToOne
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;

	/**
	 * @return the idNutricion
	 */
	public Integer getIdNutricion() {
		return idNutricion;
	}

	/**
	 * @param idNutricion
	 *            the idNutricion to set
	 */
	public void setIdNutricion(Integer idNutricion) {
		this.idNutricion = idNutricion;
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
	 * @return the cuenta
	 */
	public Cuenta getCuenta() {
		return cuenta;
	}

	/**
	 * @param cuenta
	 *            the cuenta to set
	 */
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
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
	 * @return the costo
	 */
	public double getCosto() {
		return costo;
	}

	/**
	 * @param costo
	 *            the costo to set
	 */
	public void setCosto(double costo) {
		this.costo = costo;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
