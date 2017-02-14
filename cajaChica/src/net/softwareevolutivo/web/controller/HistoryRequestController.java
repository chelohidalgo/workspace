package net.softwareevolutivo.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import net.softwareevolutivo.dao.entity.Withdraw;
import net.softwareevolutivo.exception.ServiceException;
import net.softwareevolutivo.service.WithdrawService;
import net.softwareevolutivo.web.util.BaseController;
import net.softwareevolutivo.web.util.StateRequestEnum;

/**
 * <b> Controlador tipo request para manejar la historia de las solicitudes </b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
 *          </p>
 */
@ManagedBean
@RequestScoped
public class HistoryRequestController extends BaseController {

	@EJB
	private WithdrawService withdrawService;

	private List<String> status;
	private List<Withdraw> withdraws;

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
			status.add(StateRequestEnum.ENTREGADO.getState());
			withdraws = withdrawService.findActiveWithdraws(status);
		} catch (ServiceException e) {
			addErrorMessage(e.getMessage());
		}
	}

	public List<Withdraw> getWithdraws() {
		return withdraws;
	}

	public void setWithdraws(List<Withdraw> withdraws) {
		this.withdraws = withdraws;
	}

}
