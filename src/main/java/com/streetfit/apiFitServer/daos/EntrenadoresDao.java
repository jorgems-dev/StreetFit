package com.streetfit.apiFitServer.daos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.streetfit.apiFitServer.modelos.EntrenadoresEntity;

public interface EntrenadoresDao extends JpaRepository<EntrenadoresEntity, Long>{
    @Query("SELECT e FROM EntrenadoresEntity e WHERE e.id NOT IN (SELECT c.entrenador.id FROM ContratosEntity c WHERE c.atleta.id = :id)")
	List<EntrenadoresEntity> findEntrenadoresNoContratados(@Param("id") Long idAtleta);
    
    @Query("SELECT e FROM EntrenadoresEntity e WHERE e.id IN (SELECT c.entrenador.id FROM ContratosEntity c WHERE c.atleta.id = :id)")
   	List<EntrenadoresEntity> findEntrenadoresContratados(@Param("id") Long idAtleta);
    
	List<EntrenadoresEntity> findByCorreo(String correo);
	EntrenadoresEntity findByCorreoAndContraPassword(String correo, String contraPassword);
}
