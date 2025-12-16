package com.streetfit.apiFitServer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.streetfit.apiFitServer.daos.AtletasDao;
import com.streetfit.apiFitServer.modelos.AtletasEntity;

@Service
public class AtletasService {
	private final AtletasDao atletasDao;

	@Autowired
	public AtletasService(AtletasDao atletasDao) {
		this.atletasDao = atletasDao;
	}
	
	public List<AtletasEntity> obtenerTodos() {
		return atletasDao.findAll();
	}
	
	public AtletasEntity obtenerAtletaPorId(Long id) {
		return atletasDao.findById(id).orElse(null);
	}
	
	public List<AtletasEntity> obtenerAtletaPorCorreo(String correo){
		return atletasDao.findByCorreo(correo);
	}
	
	public AtletasEntity obtenerAtletaContraPassword(String contraPassword) {
		return atletasDao.findByContraPassword(contraPassword);
	}
	
	public AtletasEntity obtenerLoginAtleta(String correo, String contraPassword) {
		return atletasDao.findByCorreoAndContraPassword(correo, contraPassword);
	}
	
	public List<AtletasEntity> obtenerAtletasDisponibles(Long id) {
		return atletasDao.findAtletasDisponibles(id);
	}
	
	public AtletasEntity guardarAtleta(AtletasEntity atleta) {
		return atletasDao.save(atleta);
	}
	
	public void eliminarAtleta(AtletasEntity atleta) {
		atletasDao.delete(atleta);
	}
}
