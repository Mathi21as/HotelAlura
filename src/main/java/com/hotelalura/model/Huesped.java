package com.hotelalura.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name="huespedes")
public class Huesped {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	@OneToMany(mappedBy = "huesped")
	private List<Reserva> reservas = new ArrayList<>();
	private String name_huesped;
	private String surname;
	private Date birthdate;
	@Column(unique = true)
	private String phone;
	private String nationality;
	
	public Huesped() {}
	
	public Huesped(String name, String surname, Date birthdate, String phone, String nationality) {
		this.id = null;
		this.name_huesped = name;
		this.surname = surname;
		this.birthdate = birthdate;
		this.phone = phone;
		this.nationality = nationality;
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
	
	public String getNationality() {
		return this.nationality;
	}
	
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public List<Reserva> getReservas(){
		return reservas;
	}

	@Override
	public String toString() {
		return "Huesped [id=" + id + ", name=" + name_huesped + ", surname=" + surname
				+ ", birthdate=" + birthdate + ", phone=" + phone + "]";
	}
	
	
}
