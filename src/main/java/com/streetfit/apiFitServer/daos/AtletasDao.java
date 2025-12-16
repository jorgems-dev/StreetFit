package com.streetfit.apiFitServer.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.streetfit.apiFitServer.modelos.AtletasEntity;

public interface AtletasDao extends JpaRepository<AtletasEntity, Long>{
    @Query("SELECT a FROM AtletasEntity a WHERE a.id IN (SELECT c.atleta.id FROM ContratosEntity c WHERE c.entrenador.id = :id)")
	List<AtletasEntity> findAtletasDisponibles(@Param("id") Long idEntrenador);
	
	List<AtletasEntity> findByCorreo(String correo);
	AtletasEntity findByContraPassword(String contraPassword);
	AtletasEntity findByCorreoAndContraPassword(String correo, String contraPassword);
}
