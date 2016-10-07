
package com.cowprod.core.potrero.bases.dao;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.cowprod.core.base.DaoGenerico;
import com.cowprod.core.potrero.entidades.UnidadMedida;

/**
 * <b> Clase para el acceso a datos de Unidades de Medida. </b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 20/07/2012 $]
 *          </p>
 */
@Stateless
public class UnidadMedidaDaoJpa extends DaoGenerico<UnidadMedida> {

	/**
	 * Constructor
	 */
	public UnidadMedidaDaoJpa() {
		super(UnidadMedida.class);
	}

	/**
	 * 
	 * <b> Metodo que devuelve el numero maximo de registros almacenados en unidad de medida. </b>
	 * <p>
	 * [Author: Marcelo Hidalgo, Date: 20/07/2012]
	 * </p>
	 * 
	 * @return int : numero maximo
	 */
	public int consultarMaximoId() {
		int maximo = 0;
		Query query = em.createNamedQuery("UnidadMedida.consultarMaximoCodigo");
		maximo = (Integer) query.getSingleResult();
		return maximo;
	}

}
