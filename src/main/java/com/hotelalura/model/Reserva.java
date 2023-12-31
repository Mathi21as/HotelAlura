package com.hotelalura.model;

import com.hotelalura.model.Huesped;

import jakarta.persistence.JoinColumn;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservas")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	@ManyToOne
	@JoinColumn(name="huesped_id")
	private Huesped huesped;
	private Date entryDate;
	private Date departureDate;
	private String valueReserva;
	private String wayToPay;
	
	public Reserva() {}
	
	public Reserva(Date entryDate, Date departureDate, String value, String wayToPay) {
		this.id = null;
		this.entryDate = entryDate;
		this.departureDate = departureDate;
		this.valueReserva = value;
		this.wayToPay = wayToPay;
	}
	
	public BigInteger getId() {
		return this.id;
	}
	
	public BigInteger getHuespedId() {
		return this.huesped.getId();
	}
	
	public void setHuesped(Huesped huesped) {
		this.huesped = huesped;
	}
	
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public String getValue() {
		return valueReserva;
	}
	public void setValue(String value) {
		this.valueReserva = value;
	}
	public String getWayToPay() {
		return wayToPay;
	}
	public void setWayToPay(String wayToPay) {
		this.wayToPay = wayToPay;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", entryDate=" + entryDate + ", departureDate=" + departureDate + ", value="
				+ valueReserva + ", wayToPay=" + wayToPay + "]";
	}
	
	
}
