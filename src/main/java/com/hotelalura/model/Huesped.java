package com.hotelalura.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import jakarta.persistence.Column;

@Entity
@Table(name="huespedes")
public class Huesped {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	private String name_huesped;
	private String surname;
	private Date birthdate;
	@Column(unique = true)
	private String phone;
	
	public Huesped() {}
	
	public Huesped(String name, String surname, Date birthdate, String phone) {
		this.id = null;
		this.name_huesped = name;
		this.surname = surname;
		this.birthdate = birthdate;
		this.phone = phone;
	}
	
	public BigInteger getId() {
		return this.id;
	}
	
	public String getName() {
		return name_huesped;
	}
	public void setName(String name) {
		this.name_huesped = name;
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
		return "Huesped [id=" + id + ", name=" + name_huesped + ", surname=" + surname
				+ ", birthdate=" + birthdate + ", phone=" + phone + "]";
	}
	
	
}
