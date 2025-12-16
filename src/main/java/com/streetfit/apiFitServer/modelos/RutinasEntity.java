package com.streetfit.apiFitServer.modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "rutinas")
public class RutinasEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	private String grupoMuscular;
	private Integer series;
	private Integer repeticiones;
	private Float peso;
	private String identificacionCreador;
	private LocalDate fechaCreacion;

	
	@OneToMany(mappedBy = "rutina", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference(value = "rutina-rutinasAsignadas")
	private List<RutinasAsignadasEntity> rutinasAsignadas = new ArrayList<RutinasAsignadasEntity>();
	
	public RutinasEntity() {}
	
	public RutinasEntity(String nombre, String grupoMuscular, Integer series, Integer repeticiones, Float peso,
			String identificacionCreador) {
		this.nombre = nombre;
		this.grupoMuscular = grupoMuscular;
		this.series = series;
		this.repeticiones = repeticiones;
		this.peso = peso;
		this.identificacionCreador = identificacionCreador;
		this.fechaCreacion = LocalDate.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGrupoMuscular() {
		return grupoMuscular;
	}

	public void setGrupoMuscular(String grupoMuscular) {
		this.grupoMuscular = grupoMuscular;
	}

	public Integer getSeries() {
		return series;
	}

	public void setSeries(Integer series) {
		this.series = series;
	}

	public Integer getRepeticiones() {
		return repeticiones;
	}

	public void setRepeticiones(Integer repeticiones) {
		this.repeticiones = repeticiones;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public String getIdentificacionCreador() {
		return identificacionCreador;
	}

	public void setIdentificacionCreador(String identificacionCreador) {
		this.identificacionCreador = identificacionCreador;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<RutinasAsignadasEntity> getRutinasAsignadas() {
		return rutinasAsignadas;
	}

	public void setRutinasAsignadas(List<RutinasAsignadasEntity> rutinasAsignadas) {
		this.rutinasAsignadas = rutinasAsignadas;
	}
	
}
