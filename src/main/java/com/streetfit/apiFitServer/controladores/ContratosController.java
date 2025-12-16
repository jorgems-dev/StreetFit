package com.streetfit.apiFitServer.controladores;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.streetfit.apiFitServer.modelos.AtletasEntity;
import com.streetfit.apiFitServer.modelos.ContratosEntity;
import com.streetfit.apiFitServer.modelos.EntrenadoresEntity;
import com.streetfit.apiFitServer.service.AtletasService;
import com.streetfit.apiFitServer.service.ContratosService;
import com.streetfit.apiFitServer.service.EntrenadoresService;

@RestController
@RequestMapping("/contratos")
public class ContratosController {
	private final ContratosService contratosService;
	private final AtletasService atletasService;
	private final EntrenadoresService entrenadoresService;
	
	@Autowired
	public ContratosController(ContratosService contratosService, AtletasService atletasService,
			EntrenadoresService entrenadoresService) {
		this.contratosService = contratosService;
		this.atletasService = atletasService;
		this.entrenadoresService = entrenadoresService;
	}
	
	/**
	 * 
	 * @param contrato
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> hacerContratacion(@RequestBody ContratosEntity contrato) {
		AtletasEntity idAtleta = atletasService.obtenerAtletaPorId(contrato.getAtleta().getId());
		EntrenadoresEntity idEtnrenador = entrenadoresService.obtenerEntrenadorPorId(contrato.getEntrenador().getId());
		
		if (idAtleta == null) {
			return ResponseEntity.status(409).body(Map.of("error", "idAtleta", "mensaje", "Id del atleta no encontrada"));
		}
		
		if (idEtnrenador == null) {
			return ResponseEntity.status(409).body(Map.of("error", "idEtnrenador", "mensaje", "Id del entrenador no encontrada"));
		}
		
		return ResponseEntity.ok(contratosService.guardar(new ContratosEntity(idEtnrenador, idAtleta)));
	}
	
	/**
	 * 
	 * @param contrato
	 * @return
	 */
	@PostMapping("/baja")
	public ResponseEntity<?> darDeBajaContratacion(@RequestBody ContratosEntity contrato) {
		AtletasEntity idAtleta = atletasService.obtenerAtletaPorId(contrato.getAtleta().getId());
		EntrenadoresEntity idEtnrenador = entrenadoresService.obtenerEntrenadorPorId(contrato.getEntrenador().getId());
		
		if (idAtleta == null) {
			return ResponseEntity.status(409).body(Map.of("error", "idAtleta", "mensaje", "Id del atleta no encontrada"));
		}
		
		if (idEtnrenador == null) {
			return ResponseEntity.status(409).body(Map.of("error", "idEtnrenador", "mensaje", "Id del entrenador no encontrada"));
		}
		contratosService.borrar(idEtnrenador.getId(), idAtleta.getId());
		return ResponseEntity.noContent().build();
	}
}
