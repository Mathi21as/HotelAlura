package com.hotelalura.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;

import com.hotelalura.model.Huesped;
import com.hotelalura.utils.JPAUtils;

public class HuespedDAO {
	private EntityManager em = JPAUtils.getEntityManager();
	
	public void insert(Huesped huesped, EntityManager em) {
		//em.getTransaction().begin();
		em.persist(huesped);
		//em.close();
	}

	public List<Huesped> findAll (EntityManager em){
		String query = "SELECT * FROM Huesped h";
		return em.createQuery(query, Huesped.class).getResultList();
	}

	public Huesped findById(BigInteger id, EntityManager em){
		return em.find(Huesped.class, id);
	}
	
	public void update(BigInteger id) {
		em.getTransaction().begin();
		Huesped huespedUpdate = em.find(Huesped.class, id);
		em.close();
	}
	
	public void delete(Huesped huesped) {
		em.getTransaction().begin();
		em.persist(huesped);
		em.getTransaction().commit();
		em.close();
	}
	
}
