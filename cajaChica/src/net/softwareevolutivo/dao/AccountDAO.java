package net.softwareevolutivo.dao;

import javax.ejb.Stateless;
import javax.persistence.Query;

import net.softwareevolutivo.dao.entity.Account;
import net.softwareevolutivo.exception.DAOException;

/**
 * <b> Excepcion para manejar errores con los servicios</b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
 *          </p>
 */
@Stateless
public class AccountDAO extends GenericDAO<Account> {

	/**
	 * <b> Constructor </b>
	 * 
	 * @author Marcelo Hidalgo
	 * @version $Revision: 1.0 $
	 *          <p>
	 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
	 *          </p>
	 */
	public AccountDAO() {
		super(Account.class);
	}
	
	/**
	 * <b> Obtiene la cuenta relacionada segun su usuario </b>
	 * 
	 * @author Marcelo Hidalgo
	 * @version $Revision: 1.0 $
	 *          <p>
	 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
	 *          </p>
	 * @param username: nombre de usuario         
	 * @return Account : cuenta encontrada
	 * @throws DAOException : en caso de error   
	 */
	public Account findAccountByUsername(String username) throws DAOException {
		Account account = null;
		try {
			Query query = em.createNamedQuery("Account.findAccountByUsername");
			query.setParameter("username", username);
			account = (Account) query.getSingleResult();
		} catch (Exception e) {
			throw new DAOException("Ocurrio un error al buscar la cuenta...", e);
		}
		return account;
	}

	/**
	 * <b> Obtiene la cuenta relacionada segun su usuario y password </b>
	 * 
	 * @author Marcelo Hidalgo
	 * @version $Revision: 1.0 $
	 *          <p>
	 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
	 *          </p>
	 * @param username: nombre de usuario 
	 * @param  password : password
	 * @return Account : cuenta encontrada
	 * @throws DAOException : en caso de error   
	 */
	public Account findAccountByUsernameAndPassword(String username, String password) throws DAOException {
		Account account = null;
		try {
			Query query = em.createNamedQuery("Account.findAccountByUsernameAndPassword");
			query.setParameter("username", username);
			query.setParameter("password", password);
			account = (Account) query.getSingleResult();
		} catch (Exception e) {
			throw new DAOException("Ocurrio un error al buscar la cuenta...", e);
		}
		return account;
	}

}
