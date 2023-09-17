package com.hotelalura.connection;

import java.math.BigInteger;

import javax.persistence.EntityManager;

import com.hotelalura.dao.HuespedDAO;
import com.hotelalura.dao.ReservaDAO;
import com.hotelalura.model.Huesped;
import com.hotelalura.model.Reserva;
import com.hotelalura.utils.JPAUtils;

public class TransactionAluraHotel {
	private EntityManager em = JPAUtils.getEntityManager();
	private Huesped huesped;
	private Reserva reserva;
	private String mode; //this variable will contain accion type (insert, update or delete a regist)
	private Reserva reservaCreada;
	
	public Reserva getReservaCreada() {
		return this.reservaCreada;
	}
	
	public TransactionAluraHotel(Huesped huesped, String mode) {
		this.huesped = huesped;
		this.mode = mode;
	}
	
	public TransactionAluraHotel(Reserva reserva, String mode) {
		this.reserva = reserva;
		this.mode = mode;
	}
	
	public void operations(Huesped huesped, EntityManager em) {
		switch(this.mode) {
			case "insert": {
				HuespedDAO huespedDAO = new HuespedDAO();
				huespedDAO.insert(huesped);
				return;
			}
			case "read":
			case "update":
			case "delete":
		}
	}
	
	public void operations(Reserva reserva, EntityManager em) {
		switch(this.mode) {
			case "insert": {
				ReservaDAO reservaDAO = new ReservaDAO();
				this.reservaCreada = reservaDAO.insert(reserva);
				return;
			}
			case "read":
			case "update":
			case "delete":
		}
	}
	
	public void mainMethod() {
		em.getTransaction().begin();
		if(reserva != null) {
			em.persist(reserva);
			operations(reserva, em);
		}
		else{
			em.persist(huesped);
			operations(huesped, em);
		}
		em.getTransaction().commit();
		em.close();

	}
	
}
