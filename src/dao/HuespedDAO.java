package dao;

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
	
	public void updateHuesped(Huesped huesped) {
		em.getTransaction().begin();
		em.persist(huesped);
		Huesped huespedUpdate = em.find(Huesped.class, huesped);
		em.close();
	}
	
	public void deleteHuesped(Huesped huesped) {
		em.getTransaction().begin();
		em.persist(huesped);
		em.getTransaction().commit();
		em.close();
	}
	
}
