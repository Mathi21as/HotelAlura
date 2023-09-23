package com.hotelalura.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;

import com.hotelalura.model.Huesped;
import com.hotelalura.utils.JPAUtils;

public class HuespedDAO {
	public Huesped insert(Huesped huesped) {
		EntityManager em = JPAUtils.getEntityManager();
		String query = "SELECT h FROM Huesped AS h WHERE h.phone = :phone";
		Huesped huespedRes = null;
		
		try {
			em.getTransaction().begin();
			huespedRes = (Huesped) em.createQuery(query, Huesped.class)
					.setParameter("phone", (huesped.getPhone()))
					.getResultList().get(0);
			em.close();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("IndexOutOfBoundsException por intentar buscar un "
					+ "usuario inexistente en la clase HuespedDAO metodo insert.");
		}
		
		if(huespedRes != null)
			return huespedRes;
		else
			insertNew(huesped);
		
		return null;
	}
	
	public void insertNew(Huesped huesped) {
		EntityManager em = JPAUtils.getEntityManager();
		em.getTransaction().begin();
		em.persist(huesped);
		em.getTransaction().commit();
		em.close();
	}

	public List<Huesped> findAll (){
		EntityManager em = JPAUtils.getEntityManager();
		String query = "SELECT h FROM Huesped AS h";
		List<Huesped> list;

		em.getTransaction().begin();
		list = em.createQuery(query, Huesped.class).getResultList();
		em.close();

		return list;
	}

	public List<Huesped> findByLastname(String surname){
		EntityManager em = JPAUtils.getEntityManager();
		String query = "SELECT h FROM Huesped AS h WHERE h.surname = :surname";
		List<Huesped> list;

		em.getTransaction().begin();
		list = em.createQuery(query, Huesped.class).setParameter("surname", surname).getResultList();
		em.close();

		return list;
	}
	
	public void update(Huesped huesped, BigInteger id) {
		EntityManager em = JPAUtils.getEntityManager();
		em.getTransaction().begin();
		Huesped huespedUpdate = em.find(Huesped.class, id);
		if(!huesped.getName().equals(""))
			huespedUpdate.setName(huesped.getName());
		if(!huesped.getSurname().equals(""))
			huespedUpdate.setSurname(huesped.getSurname());
		if(!huesped.getBirthdate().equals(null))
			huespedUpdate.setBirthdate(huesped.getBirthdate());
		if(!huesped.getNationality().equals(""))
			huespedUpdate.setNationality(huesped.getNationality());
		if(!huesped.getPhone().equals(""))
			huespedUpdate.setPhone(huesped.getPhone());
		em.getTransaction().commit();
		em.close();
	}
	
	public void delete(BigInteger id) {
		EntityManager em = JPAUtils.getEntityManager();
		em.getTransaction().begin();
		Huesped huespedDel = em.find(Huesped.class, id);
		em.remove(huespedDel);
		em.getTransaction().commit();
		em.close();
	}
	
}
