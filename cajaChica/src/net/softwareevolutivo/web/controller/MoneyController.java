package net.softwareevolutivo.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import net.softwareevolutivo.dao.entity.Money;
import net.softwareevolutivo.dao.entity.Withdraw;
import net.softwareevolutivo.exception.ServiceException;
import net.softwareevolutivo.service.MoneyService;
import net.softwareevolutivo.service.WithdrawService;
import net.softwareevolutivo.web.controller.session.MoneySession;
import net.softwareevolutivo.web.util.BaseController;
import net.softwareevolutivo.web.util.StateRequestEnum;

/**
 * <b> Controlador tipo request para manejar caja chica</b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
 *          </p>
 */
@ManagedBean
@RequestScoped
public class MoneyController extends BaseController {

	@EJB
	private MoneyService moneyService;

	@EJB
	private WithdrawService withdrawService;

	@ManagedProperty(value = "#{moneySession}")
	private MoneySession moneySession;
	private double amountAvailable;
	private Boolean isOptionRegister;

	private List<String> status;

	/**
	 * <b> Constructor </b>
	 * 
	 * @author Marcelo Hidalgo
	 * @version $Revision: 1.0 $
	 *          <p>
	 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
	 *          </p>
	 */
	@PostConstruct
	private void inicializar() {
		try {
			status = new ArrayList<String>();
			status.add(StateRequestEnum.ACTIVO.getState());
			moneySession.setWithdraws(withdrawService.findActiveWithdraws(status));
			amountAvailable = moneyService.findAmountAvailable();
		} catch (ServiceException e) {
			addErrorMessage(e.getMessage());
		}
	}

	/**
	 * <b> Registra el ingreso de dinero a caja </b>
	 * 
	 * @author Marcelo Hidalgo
	 * @version $Revision: 1.0 $
	 *          <p>
	 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
	 *          </p>
	 */
	public void registerIncome() {
		try {
			moneyService.registerMoney(moneySession.getMoney());
			moneySession.setMoney(new Money());
			amountAvailable = moneyService.findAmountAvailable();
			addInfoMessage("Procesado correctamente!");
		} catch (Exception e) {
			addErrorMessage(e.getMessage());
		}
	}

	/**
	 * <b> Procesa la solicitud de dinero activa, para cambiarla a entregada </b>
	 * 
	 * @author Marcelo Hidalgo
	 * @version $Revision: 1.0 $
	 *          <p>
	 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
	 *          </p>
	 */
	public void processRequest(Withdraw withdraw) {
		try {
			if (withdraw.getValue() <= amountAvailable) {
				moneyService.processRequest(withdraw, amountAvailable);
				amountAvailable = moneyService.findAmountAvailable();
				moneySession.setWithdraws(withdrawService.findActiveWithdraws(status));
				addInfoMessage("Procesado correctamente!");
			} else {
				addInfoMessage("La cantidad seleccionada es mayor a la disponible, no se puede procesar!");
			}
			addInfoMessage("Procesado correctamente!");
		} catch (Exception e) {
			addErrorMessage(e.getMessage());
		}
	}

	public MoneySession getMoneySession() {
		return moneySession;
	}

	public void setMoneySession(MoneySession moneySession) {
		this.moneySession = moneySession;
	}

	public double getAmountAvailable() {
		return amountAvailable;
	}

	public void setAmountAvailable(double amountAvailable) {
		this.amountAvailable = amountAvailable;
	}

	public Boolean getIsOptionRegister() {
		return isOptionRegister;
	}

	public void setIsOptionRegister(Boolean isOptionRegister) {
		this.isOptionRegister = isOptionRegister;
	}

}
