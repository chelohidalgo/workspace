package net.softwareevolutivo.service;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import net.softwareevolutivo.dao.MoneyDAO;
import net.softwareevolutivo.dao.WithdrawDAO;
import net.softwareevolutivo.dao.entity.Money;
import net.softwareevolutivo.dao.entity.Withdraw;
import net.softwareevolutivo.exception.DAOException;
import net.softwareevolutivo.exception.ServiceException;
import net.softwareevolutivo.web.util.StateRequestEnum;

/**
 * <b> Servicio para manejar las operaciones sobre caja </b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
 *          </p>
 */
@Stateless
public class MoneyService {

	private Logger log = Logger.getLogger(MoneyService.class);

	@EJB
	private MoneyDAO moneyDAO;

	@EJB
	private WithdrawDAO withdrawDAO;

	/**
	 * <b> Metodo para registrar el dinero en caja </b>
	 * 
	 * @author Marcelo Hidalgo
	 * @version $Revision: 1.0 $
	 *          <p>
	 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
	 *          </p>
	 * @param money: objeto money
	 * @throws Exception : en caso de error   
	 */
	public void registerMoney(Money money) throws Exception {
		double maxValue;
		try {
			maxValue = moneyDAO.findAmountAvailable();
			money.setAmountAvailable(maxValue + money.getAmount());
			moneyDAO.insert(money);
		} catch (DAOException e) {
			log.error("Ocurrio un error al registrar el ingreso de dinero en caja chica", e);
			throw new ServiceException("ocurrio un error al registrar el ingreso de dinero en caja chica");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Oucrrio un error en el sistema, intente mas tarde...", e);
		}
	}

	/**
	 * <b> Metodo que devuelve el saldo disponible</b>
	 * 
	 * @author Marcelo Hidalgo
	 * @version $Revision: 1.0 $
	 *          <p>
	 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
	 *          </p>
	 * @return double : saldo disponible encontrado         
	 * @throws ServiceException : en caso de error   
	 */
	public double findAmountAvailable() throws ServiceException {
		try {
			return moneyDAO.findAmountAvailable();
		} catch (DAOException e) {
			log.error("Ocurrio un error al registrar el ingreso de dinero en caja chica", e);
			throw new ServiceException("ocurrio un error al registrar el ingreso de dinero en caja chica");
		} catch (Exception e) {
			log.error("Ocurrio un error al registrar el ingreso de dinero en caja chica", e);
			throw new ServiceException("Oucrrio un error en el sistema, intente mas tarde...", e);
		}
	}

	/**
	 * <b> Metodo que procesa la aceptacion de una solicitud de dinero</b>
	 * 
	 * @author Marcelo Hidalgo
	 * @version $Revision: 1.0 $
	 *          <p>
	 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
	 *          </p>
	 * @param withdraw : solicitud a procesar como entregada
	 * @param amountAvailable : saldo disponible hasta el momento      
	 * @throws ServiceException : en caso de error   
	 */
	public void processRequest(Withdraw withdraw, double amountAvailable) throws ServiceException {
		try {
			Money money = new Money();
			money.setAmountAvailable(amountAvailable - withdraw.getValue());
			money.setAmount(-withdraw.getValue());
			money.setDateIncomeOn(new Date());
			moneyDAO.insert(money);
			withdraw.setDateProcessedOn(new Date());
			withdraw.setState(StateRequestEnum.ENTREGADO.getState());
			withdrawDAO.update(withdraw);
		} catch (Exception e) {
			log.error("Ocurrio un error al registrar el ingreso de dinero en caja chica", e);
			throw new ServiceException("Oucrrio un error en el sistema, intente mas tarde...", e);
		}
	}

}
