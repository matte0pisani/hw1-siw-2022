package it.uniroma3.siw.model;

import java.time.LocalDate;
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
	
	private int durataInMesi;
	
	// Fetch: per quanto potrebbe essere comune lavorare con gli allievi di un corso, essi potrebbero essere molto numerosi. Per evitare di avere una "catena di
	// associazioni eager", lasciamo il valore di default
	// Cascade: potrebbe essere conveniente propagare la persist sugli allievi, specie nel caso in cui si trattasse di allievi "nuovi" non nel DB. Inoltre questa
	// associazione può essere vista come una composizione
	@ManyToMany(mappedBy = "corsi")
	private List<Allievo> allievi;
	
	// Fetch: è conveniente, per ragioni di costo e di utilizzo, caricare anche il Docente
	// Cascade: persist non sarebbe conveniente nel caso in cui il Docente già esistesse nel DB (caso comune); la remove sarebbe concettualmente sbagliata
	@ManyToOne
	private Docente docente;

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

	public int getDurataInMesi() {
		return durataInMesi;
	}

	public void setDurataInMesi(int durataInMesi) {
		this.durataInMesi = durataInMesi;
	}

	public List<Allievo> getAllievi() {
		return allievi;
	}

	public void setAllievi(List<Allievo> allievi) {
		this.allievi = allievi;
	}
	
	
}
