package it.uniroma3.siw.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Societa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 512)
	private String ragioneSociale;
	
	private String numeroTelefonico;
	
	// Fetch: è probabile che, accedendo a un oggetto Societa, si debba accedere anche al suo Indirizzo; confermiamo esplicitamente il valore di default
	// Cascade: è ragionevole che ad un indirizzo corrisponda una sola società nella maggior parte dei casi. Per cui questa associazione può essere vista come una 
	// OneToOne, in cui è opportuno propagare la persist
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
	private Indirizzo indirizzo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}

	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}
	
}
