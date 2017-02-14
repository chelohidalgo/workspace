package net.softwareevolutivo.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import net.softwareevolutivo.dao.AccountDAO;
import net.softwareevolutivo.dao.entity.Account;
import net.softwareevolutivo.exception.DAOException;
import net.softwareevolutivo.exception.ServiceException;

/**
 * <b> Servicio para manejar las cuentas </b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
 *          </p>
 */
@Stateless
public class AccountService {

	private static final Logger log = Logger.getLogger(AccountService.class);

	@EJB
	private AccountDAO accountDAO;

	/**
	 * <b> Obtiene la cuenta relacionada segun su usuario y password </b>
	 * 
	 * @author Marcelo Hidalgo
	 * @version $Revision: 1.0 $
	 *          <p>
	 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
	 *          </p>
	 * @param username: nombre de usuario
	 * @param password : password         
	 * @return Account : cuenta encontrada
	 * @throws ServiceException : en caso de error   
	 */
	public Account findAccountByUsernameAndPassword(String username, String password) throws ServiceException {
		try {
			return accountDAO.findAccountByUsernameAndPassword(username, password);
		} catch (DAOException e) {
			log.error("Usuario no encontrado...");
			throw new ServiceException("Usuario no registrado o usuario y clave incorrectos", e);
		} catch (Exception e) {
			throw new ServiceException("Oucrrio un error en el sistema, intente mas tarde..", e);
		}

	}

}
