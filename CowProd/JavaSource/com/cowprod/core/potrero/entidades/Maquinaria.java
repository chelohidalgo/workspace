
package com.cowprod.core.potrero.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cowprod.core.entidades.Empresa;

/**
 * <b> Clase entidad maquinaria. </b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 29/06/2012 $]
 *          </p>
 */
@Entity
@Table(name = "maquinaria")
public class Maquinaria implements Serializable {

	/**
	 * Constructor
	 */
	public Maquinaria() {
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_maquinaria")
	private Integer idMaquinaria;

	@Column(nullable = false, insertable = true, updatable = true)
	private String nombre;

	@Column(name = "numero_serie", unique = true)
	private String numeroSerie;

	private double costo;

	private double valor;

	private String estado;

	private String observacion;

	@OneToMany(mappedBy = "maquinaria")
	private List<MantenimientoMaquinaria> mantenimientoMaquinariaList;

	@ManyToOne
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;

	@OneToMany(mappedBy = "maquinaria")
	private List<IngresoTrabajo> ingresoTrabajoList;

	/**
	 * @return the idMaquinaria
	 */
	public Integer getIdMaquinaria() {
		return idMaquinaria;
	}

	/**
	 * @param idMaquinaria
	 *            the idMaquinaria to set
	 */
	public void setIdMaquinaria(Integer idMaquinaria) {
		this.idMaquinaria = idMaquinaria;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the numeroSerie
	 */
	public String getNumeroSerie() {
		return numeroSerie;
	}

	/**
	 * @param numeroSerie
	 *            the numeroSerie to set
	 */
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
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

	/**
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(double valor) {
		this.valor = valor;
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

	/**
	 * @return the mantenimientoMaquinariaList
	 */
	public List<MantenimientoMaquinaria> getMantenimientoMaquinariaList() {
		return mantenimientoMaquinariaList;
	}

	/**
	 * @param mantenimientoMaquinariaList
	 *            the mantenimientoMaquinariaList to set
	 */
	public void setMantenimientoMaquinariaList(List<MantenimientoMaquinaria> mantenimientoMaquinariaList) {
		this.mantenimientoMaquinariaList = mantenimientoMaquinariaList;
	}

	/**
	 * @return the ingresoTrabajoList
	 */
	public List<IngresoTrabajo> getIngresoTrabajoList() {
		return ingresoTrabajoList;
	}

	/**
	 * @param ingresoTrabajoList
	 *            the ingresoTrabajoList to set
	 */
	public void setIngresoTrabajoList(List<IngresoTrabajo> ingresoTrabajoList) {
		this.ingresoTrabajoList = ingresoTrabajoList;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @param observacion
	 *            the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

}
