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
<<<<<<< HEAD
	private BigInteger reservaCreada;
	
	public BigInteger getReservaCreada() {
=======
	private Reserva reservaCreada;
	
	public Reserva getReservaCreada() {
>>>>>>> c3e6c8721d7ef20b353812b791575d156cfba096
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
<<<<<<< HEAD
				this.reservaCreada = reservaDAO.insertReserva(reserva, em).getId();
=======
				this.reservaCreada = reservaDAO.insertReserva(reserva, em);
>>>>>>> c3e6c8721d7ef20b353812b791575d156cfba096
				return;
			}
		}
	}
	
	public void mainMethod() {
<<<<<<< HEAD
		//em.getTransaction().begin();
		if(huesped == null) {
			em.getTransaction().begin();
			em.persist(reserva);
			operations(reserva, em);
			em.getTransaction().commit();
			em.close();
=======
		em.getTransaction().begin();
		if(huesped == null) {
			em.persist(reserva);
			operations(reserva, em);
>>>>>>> c3e6c8721d7ef20b353812b791575d156cfba096
		}
		else {
			em.persist(huesped);
			operations(huesped, em);
		}
<<<<<<< HEAD
		//em.getTransaction().commit();
		//em.close();
=======
		em.getTransaction().commit();
		em.close();
>>>>>>> c3e6c8721d7ef20b353812b791575d156cfba096
	}
	
}
