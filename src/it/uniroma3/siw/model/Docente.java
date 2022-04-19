package it.uniroma3.siw.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Docente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String cognome;
	
	private LocalDateTime dataDiNascita;
	
	private String luogoDiNascita;
	
	private String numeroPartitaIva;
	
	// Fetch: è molto probabile che dato un Docente si debba lavorare sui suoi corsi, quindi li carichiamo subito usando una strategia eager
	// Cascade: quando carico nel DB un nuovo docente, ha senso caricare i suoi corsi (che sicuramente non sono presenti nel DB). 
	@OneToMany(mappedBy = "docente", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
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

	public LocalDateTime getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDateTime dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getLuogoDiNascita() {
		return luogoDiNascita;
	}

	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
	}

	public String getNumeroPartitaIva() {
		return numeroPartitaIva;
	}

	public void setNumeroPartitaIva(String numeroPartitaIva) {
		this.numeroPartitaIva = numeroPartitaIva;
	}

	public List<Corso> getCorsi() {
		return corsi;
	}

	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}
	
}
