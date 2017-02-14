package net.softwareevolutivo.web.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import net.softwareevolutivo.dao.entity.Withdraw;
import net.softwareevolutivo.service.WithdrawService;
import net.softwareevolutivo.web.controller.session.WithdrawSession;
import net.softwareevolutivo.web.util.BaseController;
import net.softwareevolutivo.web.util.StateRequestEnum;

/**
 * <b> Controlador tipo request para manejar solicitudes deinero que realizan los publicos</b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
 *          </p>
 */
@ManagedBean
@RequestScoped
public class WithdrawController extends BaseController {

	@EJB
	private WithdrawService withdrawService;

	@ManagedProperty(value = "#{withdrawSession}")
	private WithdrawSession withdrawSession;

	/**
	 * <b> Registra el ingreso de solicitud de dinero </b>
	 * 
	 * @author Marcelo Hidalgo
	 * @version $Revision: 1.0 $
	 *          <p>
	 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
	 *          </p>
	 */
	public void requestMoney() {
		try {
			withdrawSession.getWithdraw().setState(StateRequestEnum.ACTIVO.getState());
			withdrawService.registerRequestMoney(withdrawSession.getName(), withdrawSession.getWithdraw());
			withdrawSession.setWithdraw(new Withdraw());
			addInfoMessage("Solicitud ingresada exitosamente!");
		} catch (Exception e) {
			addErrorMessage(e.getMessage());
		}
	}

	public WithdrawSession getWithdrawSession() {
		return withdrawSession;
	}

	public void setWithdrawSession(WithdrawSession withdrawSession) {
		this.withdrawSession = withdrawSession;
	}

}
