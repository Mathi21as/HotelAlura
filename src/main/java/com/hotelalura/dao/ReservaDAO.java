package com.hotelalura.dao;

import java.math.BigInteger;

import javax.persistence.EntityManager;

import com.hotelalura.model.Reserva;
import com.hotelalura.utils.JPAUtils;

public class ReservaDAO {
	private EntityManager em = JPAUtils.getEntityManager();
	
	public Reserva insertReserva(Reserva reserva, EntityManager em) {
		//em.getTransaction().begin();
		em.persist(reserva);
		return em.getReference(Reserva.class, reserva.getId());
		//em.close();
	}
	
	
	
	public void updateReserva(BigInteger id) {
		em.getTransaction().begin();
		Reserva reservaUpdate = em.find(Reserva.class, id);
		
		em.close();
	}
	
	public void deleteReserva(BigInteger id) {
		em.getTransaction().begin();
		Reserva reservaDelete = em.find(Reserva.class, id);
		em.remove(reservaDelete);
		em.getTransaction().commit();
		em.close();
	}
	
}
