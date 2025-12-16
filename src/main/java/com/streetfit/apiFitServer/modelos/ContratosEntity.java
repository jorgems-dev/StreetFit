package com.streetfit.apiFitServer.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contratos")
public class ContratosEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_entrenador", referencedColumnName = "id")
	@JsonBackReference(value = "entrenador-contratos")
	private EntrenadoresEntity entrenador;
	
	@ManyToOne
	@JoinColumn(name = "id_atleta", referencedColumnName = "id")
	@JsonBackReference(value = "atleta-contratos")
	private AtletasEntity atleta;
	
	public ContratosEntity() {}

	public ContratosEntity(EntrenadoresEntity entrenador, AtletasEntity atleta) {
		this.entrenador = entrenador;
		this.atleta = atleta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EntrenadoresEntity getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(EntrenadoresEntity entrenador) {
		this.entrenador = entrenador;
	}

	public AtletasEntity getAtleta() {
		return atleta;
	}

	public void setAtleta(AtletasEntity atleta) {
		this.atleta = atleta;
	}
	
}
