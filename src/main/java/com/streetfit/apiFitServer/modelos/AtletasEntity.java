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
@Table(name = "atletas")
public class AtletasEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String correo;
	private String nombre;
	private String apellidos;
	private String contraPassword;
	private LocalDate fechaAlta;
	
	@OneToMany(mappedBy = "atleta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference(value = "atleta-contratos")
	private List<ContratosEntity> contratos = new ArrayList<ContratosEntity>();
	
	@OneToMany(mappedBy = "atleta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference(value = "atleta-rutinasAsignadas")
	private List<RutinasAsignadasEntity> rutinasAsignadas = new ArrayList<RutinasAsignadasEntity>();	
	
	public AtletasEntity(String nombre, String apellidos, String correo, String contraPassword) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.contraPassword = contraPassword;
		this.fechaAlta = LocalDate.now();
	}
	
	public AtletasEntity() {}
	
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
	
	public List<ContratosEntity> getContratos() {
		return contratos;
	}

	public void setContratos(List<ContratosEntity> contratos) {
		this.contratos = contratos;
	}

	public List<RutinasAsignadasEntity> getRutinasAsignadas() {
		return rutinasAsignadas;
	}

	public void setRutinasAsignadas(List<RutinasAsignadasEntity> rutinasAsignadas) {
		this.rutinasAsignadas = rutinasAsignadas;
	}
}
