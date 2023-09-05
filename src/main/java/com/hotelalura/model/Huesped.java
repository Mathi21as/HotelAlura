package com.hotelalura.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="huespedes")
public class Huesped {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	@OneToMany
	private Reserva bookingId;
	private String name;
	private String surname;
	private Date birthdate;
	private String phone;
	
	public Huesped(Reserva bookingId, String name, String surname, Date birthdate, String phone) {
		this.bookingId = bookingId;
		this.name = name;
		this.surname = surname;
		this.birthdate = birthdate;
		this.phone = phone;
	}
	
	public BigInteger getBookingId() {
		return bookingId.getId();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Huesped [id=" + id + ", bookingId=" + bookingId + ", name=" + name + ", surname=" + surname
				+ ", birthdate=" + birthdate + ", phone=" + phone + "]";
	}
	
	
}
