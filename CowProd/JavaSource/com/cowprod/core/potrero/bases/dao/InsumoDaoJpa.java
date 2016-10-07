
package com.cowprod.core.potrero.bases.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.cowprod.core.base.DaoGenerico;
import com.cowprod.core.potrero.entidades.Insumo;
import com.cowprod.core.potrero.entidades.TipoInsumo;
import com.cowprod.core.potrero.entidades.UnidadMedida;

/**
 * <b> Clase para el acceso a datos de insumos. </b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 29/06/2012 $]
 *          </p>
 */

@Stateless
public class InsumoDaoJpa extends DaoGenerico<Insumo> {

	/**
	 * Constructor
	 */
	public InsumoDaoJpa() {
		super(Insumo.class);
	}

	/**
	 * 
	 * <b> Metodo que devuelve una lista de insumos segun el tipo de insumo enviado. </b>
	 * <p>
	 * [Author: Marcelo Hidalgo, Date: 11/07/2012]
	 * </p>
	 * 
	 * @param tipoInsumo
	 *            : tipo de insumo
	 */
	@SuppressWarnings("unchecked")
	public List<Insumo> buscarInsumosPorTipoInsumo(TipoInsumo tipoInsumo) {
		Query query = em.createQuery("select o from Insumo o where o.tipoInsumo =:tipoInsumo");
		query.setParameter("tipoInsumo", tipoInsumo);
		return query.getResultList();
	}

	/**
	 * 
	 * <b> Metodo que devuelve una lista de insumos segun la unidad de medida. </b>
	 * <p>
	 * [Author: Marcelo Hidalgo, Date: 11/07/2012]
	 * </p>
	 * 
	 * @param unidadMedida
	 *            : unidad de medida enviadaF
	 */
	@SuppressWarnings("unchecked")
	public List<Insumo> buscarInsumosPorUnidadMedida(UnidadMedida unidadMedida) {
		Query query = em.createQuery("select o from Insumo o where o.unidadMedida =:unidadMedida");
		query.setParameter("unidadMedida", unidadMedida);
		return query.getResultList();
	}
}
