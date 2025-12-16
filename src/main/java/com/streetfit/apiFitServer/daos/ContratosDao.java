package com.streetfit.apiFitServer.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.streetfit.apiFitServer.modelos.ContratosEntity;

public interface ContratosDao extends JpaRepository<ContratosEntity, Long>{
	
	@Modifying
    @Transactional
	@Query("DELETE FROM ContratosEntity c WHERE c.entrenador.id = :idEntrenador AND c.atleta.id = :idAtleta")
	void deleteByAtletaIdAndEntrenadorId(@Param("idEntrenador") Long idEntrenador, @Param("idAtleta") Long idAtleta);
}
