package net.softwareevolutivo.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import net.softwareevolutivo.dao.AccountDAO;
import net.softwareevolutivo.dao.WithdrawDAO;
import net.softwareevolutivo.dao.entity.Account;
import net.softwareevolutivo.dao.entity.Withdraw;
import net.softwareevolutivo.exception.DAOException;
import net.softwareevolutivo.exception.ServiceException;

/**
 * <b> Servicio para realizar solicitudes de dinero</b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
 *          </p>
 */
@Stateless
public class WithdrawService {

	private Logger log = Logger.getLogger(WithdrawService.class);

	@EJB
	private WithdrawDAO withdrawDAO;

	@EJB
	private AccountDAO accountDAO;

	/**
	 * <b> Registrar solicitud de dinero </b>
	 * 
	 * @author Marcelo Hidalgo
	 * @version $Revision: 1.0 $
	 *          <p>
	 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
	 *          </p>
	 * @param name: nombre de usuario
	 * @param withdraw : solicitud de dinero a registrar         
	 * @throws ServiceException : en caso de error   
	 */
	public void registerRequestMoney(String name, Withdraw withdraw) throws ServiceException {
		try {
			log.info("buscando cuenta...");
			Account account = accountDAO.findAccountByUsername(name);
			if (account != null) {
				log.info("Cuenta encontrada para " + name + " id: " + account.getId());
				withdraw.setUserId(account.getId());
				withdrawDAO.insert(withdraw);
			} else {
				log.warn("El usuario que solicita el dinero no existe...");
				throw new ServiceException("El usuario que solicita el dinero no existe...");
			}
		} catch (DAOException e) {
			log.error("Ocurrio un error al registrar el ingreso de dinero en caja chica", e);
			throw new ServiceException("ocurrio un error al registrar el ingreso de dinero en caja chica");
		} catch (Exception e) {
			throw new ServiceException("Oucrrio un error en el sistema, intente mas tarde...", e);
		}
	}

	/**
	 * <b> Devuleve lista de solicitudes de dinero segun los estdos enviados</b>
	 * 
	 * @author Marcelo Hidalgo
	 * @version $Revision: 1.0 $
	 *          <p>
	 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
	 *          </p>
	 * @param status: estados enviados
	 * @return List<Withdraw> : solicitudes encontradas
	 * @throws ServiceException : en caso de error   
	 */
	public List<Withdraw> findActiveWithdraws(List<String> status) throws ServiceException {
		try {
			return withdrawDAO.findActiveWithdraws(status);
		} catch (DAOException e) {
			log.error("Ocurrio un error al buscar en las solicitudes registradas en base", e);
			throw new ServiceException("Ocurrio un error al buscar en las solicitudes registradas en base");
		} catch (Exception e) {
			throw new ServiceException("Ocurrio un error en el sistema, intente mas tarde...", e);
		}
	}

}
