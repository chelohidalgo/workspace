
package com.cowprod.core.potrero.bases.dao;

import javax.ejb.Stateless;

import com.cowprod.core.base.DaoGenerico;
import com.cowprod.core.potrero.entidades.Potrero;

/**
 * <b> Clase para el acceso a datos de potrero. </b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 28/06/2012 $]
 *          </p>
 */
@Stateless
public class PotreroDaoJpa extends DaoGenerico<Potrero> {

	/**
	 * Constructor
	 */
	public PotreroDaoJpa() {
		super(Potrero.class);
	}

}
