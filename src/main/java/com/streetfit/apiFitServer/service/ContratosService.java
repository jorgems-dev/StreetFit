package com.streetfit.apiFitServer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.streetfit.apiFitServer.daos.AtletasDao;
import com.streetfit.apiFitServer.daos.ContratosDao;
import com.streetfit.apiFitServer.daos.EntrenadoresDao;
import com.streetfit.apiFitServer.modelos.ContratosEntity;

@Service
public class ContratosService {
	private final ContratosDao contratosDao;
	
	@Autowired
	public ContratosService(ContratosDao contratosDao, AtletasDao atletasDao, EntrenadoresDao entrenadoresDao) {
		this.contratosDao = contratosDao;
	}

	public List<ContratosEntity> obtenerTodos(){
		return contratosDao.findAll();
	}
	
	public ContratosEntity guardar(ContratosEntity contrato) {
		return contratosDao.save(contrato);
	}
	
	public void borrar(Long idEntrenador, Long idAtleta) {
		contratosDao.deleteByAtletaIdAndEntrenadorId(idEntrenador, idAtleta);
	}
	
	
}
