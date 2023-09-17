package com.hotelalura.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;

import com.hotelalura.model.Reserva;
import com.hotelalura.utils.JPAUtils;

public class ReservaDAO {
	public Reserva insert(Reserva reserva) {
		EntityManager em = JPAUtils.getEntityManager();
		Reserva reservaCreada;

		em.getTransaction().begin();
		em.persist(reserva);
		reservaCreada = em.getReference(Reserva.class, reserva.getId());
		em.getTransaction().commit();
		em.close();

		return reservaCreada;
	}
	
	public List<Reserva> findAll (){
		EntityManager em = JPAUtils.getEntityManager();
		List<Reserva> reservas;
		String query = "SELECT * FROM Reserva r";

		em.getTransaction().begin();
		reservas = em.createQuery(query, Reserva.class).getResultList();
		em.close();

		return reservas;
	}

	public Reserva findById (BigInteger id){
		EntityManager em = JPAUtils.getEntityManager();
		Reserva reserva;

		em.getTransaction().begin();
		reserva = em.find(Reserva.class, id);
		em.close();

		return reserva;
	}

	public void update(BigInteger id) {
		EntityManager em = JPAUtils.getEntityManager();
		Reserva reservaUpdate;
		
		em.getTransaction().begin();
		reservaUpdate = em.find(Reserva.class, id);
		//Insert update fields
		em.getTransaction().commit();
		em.close();
	}
	
	public void delete(BigInteger id) {
		EntityManager em = JPAUtils.getEntityManager();
		em.getTransaction().begin();
		Reserva reservaDelete = em.find(Reserva.class, id);
		em.remove(reservaDelete);
		em.getTransaction().commit();
		em.close();
	}
	
}
