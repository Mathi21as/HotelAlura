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
	
	public String getMaxId() {
		EntityManager em = JPAUtils.getEntityManager();
		BigInteger id;
		String query = "SELECT MAX(r.id) FROM Reserva AS r";

		em.getTransaction().begin();
		id = (BigInteger) em.createQuery(query, BigInteger.class).getSingleResult();
		em.close();
		if(id != null) {
			return String.valueOf(id.add(BigInteger.valueOf(1)));
		} else {
			return "1";
		}
		
		
	}
	
	public List<Reserva> findAll (){
		EntityManager em = JPAUtils.getEntityManager();
		List<Reserva> reservas;
		String query = "SELECT r FROM Reserva AS r";

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

	public void update(Reserva reserva, BigInteger id) {
		EntityManager em = JPAUtils.getEntityManager();
		Reserva reservaUpdate;
		
		em.getTransaction().begin();
		reservaUpdate = em.find(Reserva.class, id);
		if(!reserva.getEntryDate().equals(null))
			reservaUpdate.setEntryDate(reserva.getEntryDate());
		if(!reserva.getDepartureDate().equals(null))
			reservaUpdate.setDepartureDate(reserva.getDepartureDate());
		if(!reserva.getValue().equals(""))
			reservaUpdate.setValue(reserva.getValue());
		if(!reserva.getWayToPay().equals(""))
			reservaUpdate.setWayToPay(reserva.getWayToPay());
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
