
package com.cowprod.core.potrero.bases.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.cowprod.core.base.DaoGenerico;
import com.cowprod.core.potrero.entidades.Maquinaria;

/**
 * <b> Implementacion para el acceso a datos de maquinaria. </b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 29/06/2012 $]
 *          </p>
 */
@Stateless
public class MaquinariaDaoJpa extends DaoGenerico<Maquinaria> {

	/**
	 * Constructor
	 */
	public MaquinariaDaoJpa() {
		super(Maquinaria.class);
	}

	/**
	 * <b> Metodo que devuelve una lista de maquinarias segun la serie enviada. </b>
	 * <p>
	 * [Author: Marcelo Hidalgo, Date: 11/07/2012]
	 * </p>
	 * 
	 * @return List<Maquinaria> : lista de maquinarias encontradas
	 */
	@SuppressWarnings("unchecked")
	public List<Maquinaria> buscarMaquinariasPorSerie(String serie) {
		Query query = em.createQuery("select o from Maquinaria o where o.numeroSerie =:serie");
		query.setParameter("serie", serie);
		return query.getResultList();
	}

	/**
	 * <b> Metodo que devuelve una lista de maquinarias activas o inactivas depedinedo del estado enviado. </b>
	 * <p>
	 * [Author: Marcelo Hidalgo, Date: 11/07/2012]
	 * </p>
	 * 
	 * @return List<Maquinaria> : lista de maquinarias encontradas
	 */
	@SuppressWarnings("unchecked")
	public List<Maquinaria> buscarMaquinariasPorEstado(String estado) {
		Query query = em.createQuery("select o from Maquinaria o where o.estado =:estado");
		query.setParameter("estado", estado);
		return query.getResultList();
	}
}
