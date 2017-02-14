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
 * <b> Entidad que representa a la tabla withdraw en la base de datos</b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 13/02/2017 $]
 *          </p>
 */
@Entity
@Table(name = "withdraw")
@NamedQuery(name = "Withdraw.findWithdrawsByStatus", query = "select o from Withdraw o where o.state in :status")
public class Withdraw implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_withdraw_on")
	private Date dateWithdrawOn = new Date();

	private String state;

	@Column(name = "user_id")
	private Integer userId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_processed_on")
	private Date dateProcessedOn;

	private double value;

	public Withdraw() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateWithdrawOn() {
		return this.dateWithdrawOn;
	}

	public void setDateWithdrawOn(Date dateWithdrawOn) {
		this.dateWithdrawOn = dateWithdrawOn;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public double getValue() {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Date getDateProcessedOn() {
		return dateProcessedOn;
	}

	public void setDateProcessedOn(Date dateProcessedOn) {
		this.dateProcessedOn = dateProcessedOn;
	}

}