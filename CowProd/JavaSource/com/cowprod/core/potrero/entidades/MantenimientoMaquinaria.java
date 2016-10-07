
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

/**
 * <b> Clase para el acceso a datos del mantenimiento de maquinarias. </b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 29/06/2012 $]
 *          </p>
 */
@Entity
@Table(name = "mantenimiento_maquinaria")
public class MantenimientoMaquinaria implements Serializable {

	/**
	 * Constructor
	 */
	public MantenimientoMaquinaria() {
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mantenimiento")
	private Integer idMantenimiento;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fecha;

	@ManyToOne
	@JoinColumn(name = "id_maquinaria", nullable = false)
	private Maquinaria maquinaria;

	@ManyToOne
	@JoinColumn(name = "id_insumo")
	private Insumo insumo;

	private double unidad;

	private double cantidad;

	private double total;

	@ManyToOne
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;

	/**
	 * @return the idMantenimiento
	 */
	public Integer getIdMantenimiento() {
		return idMantenimiento;
	}

	/**
	 * @param idMantenimiento
	 *            the idMantenimiento to set
	 */
	public void setIdMantenimiento(Integer idMantenimiento) {
		this.idMantenimiento = idMantenimiento;
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
	 * @return the unidad
	 */
	public double getUnidad() {
		return unidad;
	}

	/**
	 * @param unidad
	 *            the unidad to set
	 */
	public void setUnidad(double unidad) {
		this.unidad = unidad;
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
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * @return the insumo
	 */
	public Insumo getInsumo() {
		return insumo;
	}

	/**
	 * @param insumo
	 *            the insumo to set
	 */
	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
