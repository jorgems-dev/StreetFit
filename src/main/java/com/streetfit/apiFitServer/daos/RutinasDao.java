package com.streetfit.apiFitServer.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.streetfit.apiFitServer.modelos.RutinasEntity;

public interface RutinasDao extends JpaRepository<RutinasEntity, Long>{
	List<RutinasEntity> findByNombre(String nombre);
	List<RutinasEntity> findByIdentificacionCreador(String identificacionCreador);
}
