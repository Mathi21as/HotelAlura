package com.hotelalura.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import jakarta.persistence.OneToOne;

@Entity
@Table(name="huespedes")
public class Huesped {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	private BigInteger bookingId;
	private String nameHuesped;
	private String surname;
	private Date birthdate;
	private String phone;
	
	public Huesped(BigInteger bookingId, String name, String surname, Date birthdate, String phone) {
		this.bookingId = bookingId;
		this.nameHuesped = name;
		this.surname = surname;
		this.birthdate = birthdate;
		this.phone = phone;
	}
	
	public BigInteger getBookingId() {
		return bookingId;//.getId();
	}
	public String getName() {
		return nameHuesped;
	}
	public void setName(String name) {
		this.nameHuesped = name;
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
		return "Huesped [id=" + id + ", bookingId=" + bookingId + ", name=" + nameHuesped + ", surname=" + surname
				+ ", birthdate=" + birthdate + ", phone=" + phone + "]";
	}
	
	
}
