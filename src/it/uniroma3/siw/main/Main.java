package it.uniroma3.siw.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("homework1-unit").createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		tx.commit();
	}

}
