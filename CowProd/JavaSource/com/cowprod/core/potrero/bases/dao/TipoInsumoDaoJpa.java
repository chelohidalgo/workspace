
package com.cowprod.core.potrero.bases.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.cowprod.core.base.DaoGenerico;
import com.cowprod.core.potrero.entidades.TipoInsumo;

/**
 * <b> Clase para el acceso a datos de tipos de insumos. </b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 29/06/2012 $]
 *          </p>
 */
@Stateless
public class TipoInsumoDaoJpa extends DaoGenerico<TipoInsumo> {

	/**
	 * Constructor
	 */
	public TipoInsumoDaoJpa() {
		super(TipoInsumo.class);
	}

	/**
	 * <b> Metodo que devuelve una lista de tipos de insumos segun el codigo enviado. </b>
	 * <p>
	 * [Author: Marcelo Hidalgo, Date: 11/07/2012]
	 * </p>
	 * 
	 * @return List<TipoInsumo> : lista de tipos insumos
	 */
	@SuppressWarnings("unchecked")
	public List<TipoInsumo> buscarTipoInsumoPorCodigo(String codigo) {
		Query query = em.createQuery("select o from TipoInsumo o where o.codigo =:codigo");
		query.setParameter("codigo", codigo);
		return query.getResultList();
	}
}
