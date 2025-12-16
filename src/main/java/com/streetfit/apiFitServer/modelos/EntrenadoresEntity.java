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
@Table(name = "entrenadores")
public class EntrenadoresEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String correo;
	private String nombre;
	private String apellidos;
	private String contraPassword;
	private LocalDate fechaAlta;
	private String especialidad;
	private String experiencia;
	
	@OneToMany(mappedBy = "entrenador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference(value = "entrenador-contratos")
	private List<ContratosEntity> contratos = new ArrayList<ContratosEntity>();
	
	@OneToMany(mappedBy = "entrenador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference(value = "entrenador-rutinasAsignadas")
	private List<RutinasAsignadasEntity> rutinasAsignadas = new ArrayList<RutinasAsignadasEntity>();
	
	public EntrenadoresEntity() {}

	public EntrenadoresEntity(String nombre, String apellidos, String correo,
			String contraPassword, String especialidad, String experiencia) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.contraPassword = contraPassword;
		this.fechaAlta = LocalDate.now();
		this.especialidad = especialidad;
		this.experiencia = experiencia;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraPassword() {
		return contraPassword;
	}

	public void setContraPassword(String contraPassword) {
		this.contraPassword = contraPassword;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}
	
	public List<RutinasAsignadasEntity> getRutinasAsignadas() {
		return rutinasAsignadas;
	}

	public void setRutinasAsignadas(List<RutinasAsignadasEntity> rutinasAsignadas) {
		this.rutinasAsignadas = rutinasAsignadas;
	}

	public List<ContratosEntity> getContratos() {
		return contratos;
	}

	public void setContratos(List<ContratosEntity> contratos) {
		this.contratos = contratos;
	}
	
}
