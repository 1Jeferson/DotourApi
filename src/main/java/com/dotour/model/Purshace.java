package com.dotour.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Purshace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private Date datePurshace;

	@Column
	private Date dateDeparture;

	@Column
	private Date dateReturn;

	@Column
	private int numOrder;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id")
	private Client client;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "destiny_id")
	private Destiny destiny;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatePurshace() {
		return datePurshace;
	}

	public void setDatePurshace(Date datePurshace) {
		this.datePurshace = datePurshace;
	}

	public int getNumOrder() {
		return numOrder;
	}

	public Date getDateDeparture() {
		return dateDeparture;
	}

	public void setDateDeparture(Date dateDeparture) {
		this.dateDeparture = dateDeparture;
	}

	public Date getDateReturn() {
		return dateReturn;
	}

	public void setDateReturn(Date dateReturn) {
		this.dateReturn = dateReturn;
	}

	public void setNumOrder(int numOrder) {
		this.numOrder = numOrder;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Destiny getDestiny() {
		return destiny;
	}

	public void setDestiny(Destiny destiny) {
		this.destiny = destiny;
	}

}
