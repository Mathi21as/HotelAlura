package com.hotelalura.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;

import com.hotelalura.model.Huesped;
import com.hotelalura.utils.JPAUtils;

public class HuespedDAO {
	public void insert(Huesped huesped) {
		EntityManager em = JPAUtils.getEntityManager();
		em.getTransaction().begin();
		em.persist(huesped);
		em.getTransaction().commit();
		em.close();
	}

	public List<Huesped> findAll (){
		EntityManager em = JPAUtils.getEntityManager();
		String query = "SELECT * FROM Huesped h";
		List<Huesped> list;

		em.getTransaction().begin();
		list = em.createQuery(query, Huesped.class).getResultList();
		em.close();

		return list;
	}

	public List<Huesped> findByLastname(String surname){
		EntityManager em = JPAUtils.getEntityManager();
		String query = "SELECT * FROM Huesped h WHERE h.surname = :surname";
		List<Huesped> list;

		em.getTransaction().begin();
		list = em.createQuery(query, Huesped.class).getResultList();
		em.close();

		return list;
	}
	
	public void update(BigInteger id) {
		EntityManager em = JPAUtils.getEntityManager();
		em.getTransaction().begin();
		Huesped huespedUpdate = em.find(Huesped.class, id);
		//Insert update fields
		em.getTransaction().commit();
		em.close();
	}
	
	public void delete(Huesped huesped) {
		EntityManager em = JPAUtils.getEntityManager();
		em.getTransaction().begin();
		Huesped huespedDel = em.find(Huesped.class, huesped.getId());
		em.remove(huespedDel);
		em.getTransaction().commit();
		em.close();
	}
	
}
