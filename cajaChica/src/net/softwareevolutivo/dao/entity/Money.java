package net.softwareevolutivo.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * <b> Entidad que representa a la tabla money en la base de datos</b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
 *          </p>
 */
@Entity
@Table(name = "money")
@NamedQuery(name = "Money.findAmountAvailable", query = "select u.amountAvailable from Money u where u.id = (select MAX(o.id) from Money o ) ")
public class Money implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private double amount;

	@Column(name = "amount_available")
	private double amountAvailable;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_income_on")
	private Date dateIncomeOn;

	public Money() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAmountAvailable() {
		return this.amountAvailable;
	}

	public void setAmountAvailable(double amountAvailable) {
		this.amountAvailable = amountAvailable;
	}

	public Date getDateIncomeOn() {
		return this.dateIncomeOn;
	}

	public void setDateIncomeOn(Date dateIncomeOn) {
		this.dateIncomeOn = dateIncomeOn;
	}

}