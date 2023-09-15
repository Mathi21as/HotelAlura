package com.hotelalura.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;

import com.hotelalura.model.Reserva;
import com.hotelalura.utils.JPAUtils;

public class ReservaDAO {
	private EntityManager em = JPAUtils.getEntityManager();
	
	public Reserva insert(Reserva reserva, EntityManager em) {
		//em.getTransaction().begin();
		em.persist(reserva);
		return em.getReference(Reserva.class, reserva.getId());
		//em.close();
	}
	
	public List<Reserva> findAll (EntityManager em){
		String query = "SELECT * FROM Reserva r";
		return em.createQuery(query, Reserva.class).getResultList();
	}

	public Reserva findById (BigInteger id, EntityManager em){
		return em.find(Reserva.class, id);
	}

	public void update(BigInteger id) {
		em.getTransaction().begin();
		Reserva reservaUpdate = em.find(Reserva.class, id);
		
		em.close();
	}
	
	public void delete(BigInteger id) {
		em.getTransaction().begin();
		Reserva reservaDelete = em.find(Reserva.class, id);
		em.remove(reservaDelete);
		em.getTransaction().commit();
		em.close();
	}
	
}
