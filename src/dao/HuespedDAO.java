package dao;

import java.math.BigInteger;

import javax.persistence.EntityManager;

import model.Huesped;
import utils.JPAUtils;

public class HuespedDAO {
	private EntityManager em = JPAUtils.getEntityManager();
	
	public void insertHuesped(Huesped huesped) {
		em.getTransaction().begin();
		em.persist(huesped);
		em.close();
	}
	
	public void updateHuesped(String name) {
		em.getTransaction().begin();
		Huesped huespedUpdate = em.find(Huesped.class, name);
		em.close();
	}
	
	public void updateHuesped(BigInteger id) {
		em.getTransaction().begin();
		Huesped huespedUpdate = em.find(Huesped.class, id);
		em.close();
	}
	
	public void deleteHuesped(Huesped huesped) {
		em.getTransaction().begin();
		em.persist(huesped);
		em.getTransaction().commit();
		em.close();
	}
	
}
