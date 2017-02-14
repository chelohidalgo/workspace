package net.softwareevolutivo.web.controller.session;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.softwareevolutivo.dao.entity.Money;
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
@ManagedBean(name = "moneySession")
@SessionScoped
public class MoneySession {

	private List<Withdraw> withdraws;
	private Money money = new Money();
	private Boolean isOptionRegister;

	public List<Withdraw> getWithdraws() {
		return withdraws;
	}

	public void setWithdraws(List<Withdraw> withdraws) {
		this.withdraws = withdraws;
	}

	public Money getMoney() {
		return money;
	}

	public void setMoney(Money money) {
		this.money = money;
	}

	public Boolean getIsOptionRegister() {
		return isOptionRegister;
	}

	public void setIsOptionRegister(Boolean isOptionRegister) {
		this.isOptionRegister = isOptionRegister;
	}
}
