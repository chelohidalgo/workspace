package net.softwareevolutivo.web.controller.session;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.softwareevolutivo.dao.entity.Withdraw;

/**
 * <b> Controlador tipo session para almacenar variables en session </b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
 *          </p>
 */
@ManagedBean(name = "withdrawSession")
@SessionScoped
public class WithdrawSession {

	private Withdraw withdraw = new Withdraw();
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Withdraw getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(Withdraw withdraw) {
		this.withdraw = withdraw;
	}

}
