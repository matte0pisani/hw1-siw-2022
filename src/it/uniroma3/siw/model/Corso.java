package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Corso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private LocalDate dataInizio;
	
	private Integer durataInMesi;
	
	// Fetch: per quanto potrebbe essere comune lavorare con gli allievi di un corso, essi potrebbero essere molto numerosi. Per evitare di avere una "catena di
	// associazioni eager", lasciamo il valore di default
	// Cascade: potrebbe essere conveniente propagare la persist sugli allievi, specie nel caso in cui si trattasse di allievi "nuovi" non nel DB. Ma se invece 
	// contenesse tutti allievi già registrati nel DB sarebbe altamente inefficiente
	@ManyToMany(mappedBy = "corsi", cascade = CascadeType.PERSIST)	// modificato per motivi di test
	private List<Allievo> allievi;
	
	// Fetch: è conveniente, per ragioni di costo e di utilizzo, caricare anche il Docente
	// Cascade: persist non sarebbe conveniente nel caso in cui il Docente già esistesse nel DB (caso comune); la remove sarebbe concettualmente sbagliata
	@ManyToOne
	private Docente docente;
	
	public Corso() {
		this.allievi = new ArrayList<>();
	}

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

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Integer getDurataInMesi() {
		return durataInMesi;
	}

	public void setDurataInMesi(Integer durataInMesi) {
		this.durataInMesi = durataInMesi;
	}

	public List<Allievo> getAllievi() {
		return allievi;
	}

	public void setAllievi(List<Allievo> allievi) {
		this.allievi = allievi;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	
	
}
