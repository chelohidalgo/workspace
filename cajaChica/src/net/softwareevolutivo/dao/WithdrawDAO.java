package net.softwareevolutivo.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import net.softwareevolutivo.dao.entity.Withdraw;
import net.softwareevolutivo.exception.DAOException;

/**
 * <b> DAO para acceder a funcionalidades relacionadas a solicitudes de dinero </b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
 *          </p>
 */
@Stateless
public class WithdrawDAO extends GenericDAO<Withdraw> {

	private Logger log = Logger.getLogger(WithdrawDAO.class);

	/**
	 * <b> Constructor </b>
	 * 
	 * @author Marcelo Hidalgo
	 * @version $Revision: 1.0 $
	 *          <p>
	 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
	 *          </p>
	 */
	public WithdrawDAO() {
		super(Withdraw.class);
	}

	/**
	 * <b> Obtiene las solicitudes de dinero segun los estados enviados </b>
	 * 
	 * @author Marcelo Hidalgo
	 * @version $Revision: 1.0 $
	 *          <p>
	 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
	 *          </p>
	 * @param status: estados posibles
	 * @return List<Withdraw> : solicitudes encontradas
	 * @throws DAOException : en caso de error   
	 */
	public List<Withdraw> findActiveWithdraws(List<String> status) throws DAOException {
		List<Withdraw> withdraws = null;
		try {
			Query query = em.createNamedQuery("Withdraw.findWithdrawsByStatus");
			query.setParameter("status", status);
			withdraws = query.getResultList();
		} catch (Exception e) {
			log.error("Ocurrio un error al buscar las solicitudes... ", e);
			throw new DAOException("Ocurrio un error al buscar las solicitudes ");
		}
		return withdraws;
	}

}
