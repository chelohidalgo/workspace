
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
 * <b> Clase entidad de labores. </b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 29/06/2012 $]
 *          </p>
 */
@Entity
@Table(name = "labores")
public class Labores implements Serializable {

	/**
	 * Constructor
	 */
	public Labores() {
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_labor")
	private Integer idLabor;

	@Column(nullable = false)
	private String codigo;

	@Column(nullable = false)
	private String nombre;

	@Column(name = "maquinaria_utilizada")
	private String maquinariaUtilizada;

	@ManyToOne
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;

	@OneToMany(mappedBy = "labores")
	private List<IngresoTrabajo> ingresoTrabajoList;

	/**
	 * @return the idLabor
	 */
	public Integer getIdLabor() {
		return idLabor;
	}

	/**
	 * @param idLabor
	 *            the idLabor to set
	 */
	public void setIdLabor(Integer idLabor) {
		this.idLabor = idLabor;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the maquinariaUtilizada
	 */
	public String getMaquinariaUtilizada() {
		return maquinariaUtilizada;
	}

	/**
	 * @param maquinariaUtilizada
	 *            the maquinariaUtilizada to set
	 */
	public void setMaquinariaUtilizada(String maquinariaUtilizada) {
		this.maquinariaUtilizada = maquinariaUtilizada;
	}

}
