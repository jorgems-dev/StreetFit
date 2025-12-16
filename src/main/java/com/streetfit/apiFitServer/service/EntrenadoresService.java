package com.streetfit.apiFitServer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.streetfit.apiFitServer.daos.EntrenadoresDao;
import com.streetfit.apiFitServer.modelos.EntrenadoresEntity;

@Service
public class EntrenadoresService {
	private final EntrenadoresDao entrenadoresDao;

	@Autowired
	public EntrenadoresService(EntrenadoresDao entrenadoresDao) {
		this.entrenadoresDao = entrenadoresDao;
	}
	
	public List<EntrenadoresEntity> obtenerTodos() {
		return entrenadoresDao.findAll();
	}
	
	public EntrenadoresEntity obtenerEntrenadorPorId(Long id) {
		return entrenadoresDao.findById(id).orElse(null);
	}
	
	public List<EntrenadoresEntity> obtenerEntrenadorPorCorreo(String correo) {
		return entrenadoresDao.findByCorreo(correo);
	}
	
	public EntrenadoresEntity obtenerLoginEntrenador(String correo, String contraPassword) {
		return entrenadoresDao.findByCorreoAndContraPassword(correo, contraPassword);
	}
	
	public List<EntrenadoresEntity> obtenerEntrenadoresNoContratados(Long id) {
		return entrenadoresDao.findEntrenadoresNoContratados(id);
	}
	
	public List<EntrenadoresEntity> obtenerEntrenadoresContratados(Long id) {
		return entrenadoresDao.findEntrenadoresContratados(id);
	}
	
	public EntrenadoresEntity guardarEntrenador(EntrenadoresEntity entrenador) {
		return entrenadoresDao.save(entrenador);
	}

	public void borrarEntrenador(EntrenadoresEntity entrenador) {
		entrenadoresDao.delete(entrenador);
	}
	
}
