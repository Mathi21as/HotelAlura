package connection;

import javax.persistence.EntityManager;

import model.Huesped;
import model.Reserva;
import utils.JPAUtils;

public class TransactionAluraHotel {
	private EntityManager em = JPAUtils.getEntityManager();
	private Huesped huesped;
	private Reserva reserva;
	private String mode; //this variable will contain accion type (insert, update or delete a regist)
	
	public TransactionAluraHotel(Huesped huesped) {
		this.huesped = huesped;
	}
	
	public TransactionAluraHotel(Reserva reserva) {
		this.reserva = reserva;
	}
	
	public void msinmrthod() {
		em.getTransaction().begin();
		if(huesped == null)
			em.persist(reserva);
		else
			em.persist(huesped);
		
		switch(mode) {
			
		}
		
		em.getTransaction().commit();
		em.close();
	}
	
}
