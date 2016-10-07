
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cowprod.core.entidades.Empresa;

/**
 * <b> Clase entidad estado del tiempo. </b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 29/06/2012 $]
 *          </p>
 */
@Entity
@Table(name = "estado_tiempo")
@NamedQueries({ @NamedQuery(name = "EstadoTiempo.consultarEstadosTiempoPorFecha", query = "select o from EstadoTiempo o where o.fecha = :fecha") })
public class EstadoTiempo implements Serializable {

	/**
	 * Constructor
	 */
	public EstadoTiempo() {
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estado")
	private Integer idEstadoTiempo;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fecha;

	@Column(name = "clima_maniana")
	private String climaManiana;

	@Column(name = "temperatura_maniana")
	private double temperaturaManiana;

	@Column(name = "pluviosidad_maniana")
	private double pluviosidadManiana;

	@Column(name = "clima_tarde")
	private String climaTarde;

	@Column(name = "temperatura_tarde")
	private double temperaturaTarde;

	@Column(name = "pluviosidad_tarde")
	private double pluviosidadTarde;

	@ManyToOne
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;

	/**
	 * @return the idEstadoTiempo
	 */
	public Integer getIdEstadoTiempo() {
		return idEstadoTiempo;
	}

	/**
	 * @param idEstadoTiempo
	 *            the idEstadoTiempo to set
	 */
	public void setIdEstadoTiempo(Integer idEstadoTiempo) {
		this.idEstadoTiempo = idEstadoTiempo;
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
	 * @return the climaManiana
	 */
	public String getClimaManiana() {
		return climaManiana;
	}

	/**
	 * @param climaManiana
	 *            the climaManiana to set
	 */
	public void setClimaManiana(String climaManiana) {
		this.climaManiana = climaManiana;
	}

	/**
	 * @return the temperaturaManiana
	 */
	public double getTemperaturaManiana() {
		return temperaturaManiana;
	}

	/**
	 * @param temperaturaManiana
	 *            the temperaturaManiana to set
	 */
	public void setTemperaturaManiana(double temperaturaManiana) {
		this.temperaturaManiana = temperaturaManiana;
	}

	/**
	 * @return the pluviosidadManiana
	 */
	public double getPluviosidadManiana() {
		return pluviosidadManiana;
	}

	/**
	 * @param pluviosidadManiana
	 *            the pluviosidadManiana to set
	 */
	public void setPluviosidadManiana(double pluviosidadManiana) {
		this.pluviosidadManiana = pluviosidadManiana;
	}

	/**
	 * @return the climaTarde
	 */
	public String getClimaTarde() {
		return climaTarde;
	}

	/**
	 * @param climaTarde
	 *            the climaTarde to set
	 */
	public void setClimaTarde(String climaTarde) {
		this.climaTarde = climaTarde;
	}

	/**
	 * @return the temperaturaTarde
	 */
	public double getTemperaturaTarde() {
		return temperaturaTarde;
	}

	/**
	 * @param temperaturaTarde
	 *            the temperaturaTarde to set
	 */
	public void setTemperaturaTarde(double temperaturaTarde) {
		this.temperaturaTarde = temperaturaTarde;
	}

	/**
	 * @return the pluviosidadTarde
	 */
	public double getPluviosidadTarde() {
		return pluviosidadTarde;
	}

	/**
	 * @param pluviosidadTarde
	 *            the pluviosidadTarde to set
	 */
	public void setPluviosidadTarde(double pluviosidadTarde) {
		this.pluviosidadTarde = pluviosidadTarde;
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

}
