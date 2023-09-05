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
	private BigInteger reservaCreada;
	
	public BigInteger getReservaCreada() {
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
				huespedDAO.insertHuesped(huesped, em);
				return;
			}
		}
	}
	
	public void operations(Reserva reserva, EntityManager em) {
		switch(this.mode) {
			case "insert": {
				ReservaDAO reservaDAO = new ReservaDAO();
				this.reservaCreada = reservaDAO.insertReserva(reserva, em).getId();
				return;
			}
		}
	}
	
	public void mainMethod() {
		//em.getTransaction().begin();
		if(huesped == null) {
			em.getTransaction().begin();
			em.persist(reserva);
			operations(reserva, em);
			em.getTransaction().commit();
			em.close();
		}
		else {
			em.persist(huesped);
			operations(huesped, em);
		}
		//em.getTransaction().commit();
		//em.close();
	}
	
}
