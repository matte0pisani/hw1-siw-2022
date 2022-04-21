package it.uniroma3.siw.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import it.uniroma3.siw.model.Allievo;
import it.uniroma3.siw.model.Corso;
import it.uniroma3.siw.model.Docente;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("homework1-unit");
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		Docente d = new Docente();
		Corso corso1 = new Corso();
		Corso corso2 = new Corso();

		d.setNome("Pippo");
		d.setCognome("Topolino");
		d.setNumeroPartitaIva("0123");
		corso1.setNome("Matematica");
		corso2.setNome("Fisica");
		corso1.setDocente(d);
		corso2.setDocente(d);
		d.getCorsi().add(corso1);
		d.getCorsi().add(corso2);

		tx.begin();
		em.persist(d);
		tx.commit();

		em.close();

		em = factory.createEntityManager();
		TypedQuery<Docente> selectQuery = em.createQuery("SELECT d FROM Docente d", Docente.class);
		List<Docente> res = selectQuery.getResultList();
		System.out.println(res.toString());
		System.out.println("----");
		for(Docente doc: res) {
			for(Corso cs : doc.getCorsi()) {
				System.out.println(cs.getNome());
			}
		}
		
		Corso corso3 = new Corso();
		Allievo a1 = new Allievo();
		a1.addCorso(corso3);
		corso3.getAllievi().add(a1);
		Allievo a2 = new Allievo();
		a2.addCorso(corso3);
		corso3.getAllievi().add(a2);
		Allievo a3 = new Allievo();
		a3.addCorso(corso3);
		corso3.getAllievi().add(a3);
		
		EntityTransaction tx2 = em.getTransaction();
		tx2.begin();
		em.persist(corso3);
		tx2.commit();
		
		factory.close();
	}


}
