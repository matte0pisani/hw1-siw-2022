package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Allievo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String cognome;
	
	private String luogoDiNascita;
	
	private LocalDate dataDiNascita;
	
	private int numeroDiMatricola;
	
	private String email;
	
	// Fetch: è plausibile che dato un Allievo si debba accedere in vari casi d'uso alla sua Società
	// Cascade: assumendo che una Societa abbia molti dipendenti, sarebbe costoso tentare di fare la persist (tra l'altro a vuoto) di una stessa Societa per ogni 
	// dipendente che viene inserito nel DB. Similmente per la merge. Mentre sarebbe sbagliato rimuovere sempre insieme ad un Allievo la sua Societa
	@ManyToOne
	private Societa societa;
	
	// Fetch: è plausibile che dato un Allievo si debba accedere in vari casi d'uso ai suoi corsi
	// Cascade: fare la persist su un Allievo e su tutti i suoi corsi sarebbe utile soltanto se l'Allievo in questione fosse il primo allievo per ogni Corso; 
	// altrimenti si farebbe la persist di oggetti già presenti nel DB. Sarebbe inoltre sbagliato rimuovere insieme ad un Allievo tutti i corsi a cui partecipa
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Corso> corsi;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getLuogoDiNascita() {
		return luogoDiNascita;
	}

	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public int getNumeroDiMatricola() {
		return numeroDiMatricola;
	}

	public void setNumeroDiMatricola(int numeroDiMatricola) {
		this.numeroDiMatricola = numeroDiMatricola;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Societa getSocieta() {
		return societa;
	}

	public void setSocieta(Societa societa) {
		this.societa = societa;
	}

	public List<Corso> getCorsi() {
		return corsi;
	}

	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}
	
	
	
}
