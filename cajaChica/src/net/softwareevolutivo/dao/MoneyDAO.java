package net.softwareevolutivo.dao;

import javax.ejb.Stateless;
import javax.persistence.Query;

import net.softwareevolutivo.dao.entity.Money;
import net.softwareevolutivo.exception.DAOException;

/**
 * <b> DAO para acceder a funcionalidades relacionadas a caja chica </b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
 *          </p>
 */
@Stateless
public class MoneyDAO extends GenericDAO<Money> {

	/**
	 * <b> Constructor </b>
	 * 
	 * @author Marcelo Hidalgo
	 * @version $Revision: 1.0 $
	 *          <p>
	 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
	 *          </p>
	 */
	public MoneyDAO() {
		super(Money.class);
	}
	
	/**
	 * <b> Obtiene el saldo disponible en caja </b>
	 * 
	 * @author Marcelo Hidalgo
	 * @version $Revision: 1.0 $
	 *          <p>
	 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
	 *          </p>
	 * @return double : saldo disponible
	 * @throws DAOException : en caso de error   
	 */
	public double findAmountAvailable() throws DAOException {
		double value = 0;
		try {
			Query query = em.createNamedQuery("Money.findAmountAvailable");
			Object valObj = (Object) query.getSingleResult();
			if (valObj != null) {
				value = (Double) valObj;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
		return value;
	}

}
