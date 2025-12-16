package com.streetfit.apiFitServer.modelos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rutinasAsignadas")
public class RutinasAsignadasEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_entrenador", referencedColumnName = "id")
	@JsonBackReference(value = "entrenador-rutinasAsignadas")
	private EntrenadoresEntity entrenador;
	
	@ManyToOne
	@JoinColumn(name = "id_atleta", referencedColumnName = "id")
	@JsonBackReference(value = "atleta-rutinasAsignadas")
	private AtletasEntity atleta;
	
	@ManyToOne
	@JoinColumn(name = "id_rutina", referencedColumnName = "id")
	@JsonBackReference(value = "rutina-rutinasAsignadas")
	private RutinasEntity rutina;

	private LocalDate fechaAsignacion;

	public RutinasAsignadasEntity(EntrenadoresEntity entrenador, AtletasEntity atleta, RutinasEntity rutina) {
		this.entrenador = entrenador;
		this.atleta = atleta;
		this.rutina = rutina;
		this.fechaAsignacion = LocalDate.now();
	}
	
	public RutinasAsignadasEntity() {}

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

	public RutinasEntity getRutina() {
		return rutina;
	}

	public void setRutina(RutinasEntity rutina) {
		this.rutina = rutina;
	}

	public LocalDate getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(LocalDate fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}
	
	
}
