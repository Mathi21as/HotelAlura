package dao;

import java.math.BigInteger;

import javax.persistence.EntityManager;

import model.Reserva;
import utils.JPAUtils;

public class ReservaDAO {
	private EntityManager em = JPAUtils.getEntityManager();
	
	public void insertReserva(Reserva reserva) {
		em.getTransaction().begin();
		em.persist(reserva);
		em.close();
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
