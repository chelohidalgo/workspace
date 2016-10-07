
package com.cowprod.core.potrero.bases.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.cowprod.core.base.DaoGenerico;
import com.cowprod.core.potrero.entidades.Labores;

/**
 * <b> Implementacion para el acceso a datos de labores. </b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 29/06/2012 $]
 *          </p>
 */
@Stateless
public class LaboresDaoJpa extends DaoGenerico<Labores> {

	/**
	 * Constructor
	 */
	public LaboresDaoJpa() {
		super(Labores.class);
	}

	/**
	 * <b> Metodo que devuelve una lista de labores segun el codigo enviado. </b>
	 * <p>
	 * [Author: Marcelo Hidalgo, Date: 11/07/2012]
	 * </p>
	 * 
	 * @return List<Labores> : lista de labores encontradas
	 */
	@SuppressWarnings("unchecked")
	public List<Labores> buscarLaboresPorCodigo(String codigo) {
		Query query = em.createQuery("select o from Labores o where o.codigo =:codigo");
		query.setParameter("codigo", codigo);
		return query.getResultList();
	}
}
