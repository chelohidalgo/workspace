
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
 * <b> Clase entidad insumo. </b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 29/06/2012 $]
 *          </p>
 */
@Entity
@Table(name = "insumo")
public class Insumo implements Serializable {

	/**
	 * Constructor
	 */
	public Insumo() {
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_insumo")
	private int idInsumo;

	@ManyToOne
	@JoinColumn(name = "id_tipo_insumo", nullable = false)
	private TipoInsumo tipoInsumo;

	private String descripcion;
	private double stock;
	private double costo;
	private double stockInicial;
	private double costoInicial;
	private double iva;

	@OneToMany(mappedBy = "insumo")
	private List<MantenimientoMaquinaria> mantenimientoMaquinariaList;

	@ManyToOne
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;

	@ManyToOne
	@JoinColumn(name = "id_unidad_Medida")
	private UnidadMedida unidadMedida;

	/**
	 * @return the idInsumo
	 */
	public int getIdInsumo() {
		return idInsumo;
	}

	/**
	 * @param idInsumo
	 *            the idInsumo to set
	 */
	public void setIdInsumo(int idInsumo) {
		this.idInsumo = idInsumo;
	}

	/**
	 * @return the tipoInsumo
	 */
	public TipoInsumo getTipoInsumo() {
		return tipoInsumo;
	}

	/**
	 * @param tipoInsumo
	 *            the tipoInsumo to set
	 */
	public void setTipoInsumo(TipoInsumo tipoInsumo) {
		this.tipoInsumo = tipoInsumo;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the stock
	 */
	public double getStock() {
		return stock;
	}

	/**
	 * @param stock
	 *            the stock to set
	 */
	public void setStock(double stock) {
		this.stock = stock;
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
	 * @return the stockInicial
	 */
	public double getStockInicial() {
		return stockInicial;
	}

	/**
	 * @param stockInicial
	 *            the stockInicial to set
	 */
	public void setStockInicial(double stockInicial) {
		this.stockInicial = stockInicial;
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public double getCostoInicial() {
		return costoInicial;
	}

	public void setCostoInicial(double costoInicial) {
		this.costoInicial = costoInicial;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	/**
	 * @return the unidadMedida
	 */
	public UnidadMedida getUnidadMedida() {
		return unidadMedida;
	}

	/**
	 * @param unidadMedida
	 *            the unidadMedida to set
	 */
	public void setUnidadMedida(UnidadMedida unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

}
