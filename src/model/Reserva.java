package model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reserva")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	private Date entryDate;
	private Date departureDate;
	private String value;
	private String wayToPay;
	
	public Reserva(Date entryDate, Date departureDate, String value, String wayToPay) {
		this.entryDate = entryDate;
		this.departureDate = departureDate;
		this.value = value;
		this.wayToPay = wayToPay;
	}
	
	public BigInteger getId() {
		return this.id;
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
		return value;
	}
	public void setValue(String value) {
		this.value = value;
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
				+ value + ", wayToPay=" + wayToPay + "]";
	}
	
	
}
