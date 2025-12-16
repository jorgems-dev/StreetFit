package com.streetfit.apiFitServer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.streetfit.apiFitServer.daos.RutinasDao;
import com.streetfit.apiFitServer.modelos.RutinasEntity;

@Service
public class RutinasService {
	private final RutinasDao rutinasDao;

	@Autowired
	public RutinasService(RutinasDao rutinasDao) {
		this.rutinasDao = rutinasDao;
	}
	
	public List<RutinasEntity> obtenerTodas(){
		return rutinasDao.findAll();
	}
	
	public RutinasEntity obtenerRutinaPorId(Long id) {
	    return rutinasDao.findById(id)
	                     .orElseThrow(() -> new RuntimeException("Rutina no encontrada con id " + id));
	}
	
	public List<RutinasEntity> obtenerTodasPorNombre(String nombre) {
		return rutinasDao.findByNombre(nombre);
	}
	
	public List<RutinasEntity> obtenerTodasPorIdentificacionCreador(String identificacionCreador) {
		return rutinasDao.findByIdentificacionCreador(identificacionCreador);
	}
	
	public RutinasEntity guardar(RutinasEntity rutina) {
		return rutinasDao.save(rutina);
	}
	
	public void borrarPorId(Long id) {
		rutinasDao.deleteById(id);
	}
	
	public void borrar(RutinasEntity rutina) {
		rutinasDao.delete(rutina);
	}
	
}
