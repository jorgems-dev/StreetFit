package com.streetfit.apiFitServer.controladores;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.streetfit.apiFitServer.modelos.EntrenadoresEntity;
import com.streetfit.apiFitServer.service.AtletasService;
import com.streetfit.apiFitServer.service.EntrenadoresService;

@RestController
@RequestMapping("entrenadores")
public class EntrenadoresController {
	private final EntrenadoresService entrenadoresService;
	private final AtletasService atletasService;
	
	@Autowired
	public EntrenadoresController(EntrenadoresService entrenadoresService, AtletasService atletasService) {
		this.entrenadoresService = entrenadoresService;
		this.atletasService = atletasService;
	}
	
	/**
	 * Sirve para obtener todos los entrenadores que se han registrado.
	 * @return
	 */
	@GetMapping
	public List<EntrenadoresEntity> obtenerEntrenadores() {
		return entrenadoresService.obtenerTodos();
	}
	
	/**
	 * 
	 * @param entrenador
	 * @return
	 */
	@PostMapping("/registro")
	public ResponseEntity<?> crearEntrenador(@RequestBody EntrenadoresEntity entrenador) {
	    if (!entrenadoresService.obtenerEntrenadorPorCorreo(entrenador.getCorreo()).isEmpty() 
	    		|| !atletasService.obtenerAtletaPorCorreo(entrenador.getCorreo()).isEmpty()) {
	        return ResponseEntity.status(409)
	                .body(Map.of("error", "correo", "mensaje", "Correo ya existente"));
	    }
		
		EntrenadoresEntity nuevo = entrenadoresService.guardarEntrenador(entrenador);
		return ResponseEntity.ok(nuevo);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> obtenerLogin(@RequestBody EntrenadoresEntity entrenador) {
    	String correo = entrenador.getCorreo();
    	String contraPassword = entrenador.getContraPassword();
    	
		EntrenadoresEntity encontrado = entrenadoresService.obtenerLoginEntrenador(correo, contraPassword);

	    if (encontrado == null) {
	        return ResponseEntity.status(409)
	            .body(Map.of("error", "correo", "mensaje", "Correo o contraseña no validos"));
	    }
		
	    return ResponseEntity.ok(encontrado);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/id/{id}")
	public EntrenadoresEntity obtenerPorId(@PathVariable Long id) {
		return entrenadoresService.obtenerEntrenadorPorId(id);
	}
	
	/**
	 * 
	 * @param correo
	 * @return
	 */
	@GetMapping("/correo/{correo}")
	public List<EntrenadoresEntity> obtenerPorCorreo(@PathVariable String correo) {
		return entrenadoresService.obtenerEntrenadorPorCorreo(correo);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/contrataciones/{id}")
	public List<EntrenadoresEntity> obtenerEntrenadoresSinContrato(@PathVariable Long id) {
		return entrenadoresService.obtenerEntrenadoresNoContratados(id);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/contratados/{id}")
	public List<EntrenadoresEntity> obtenerEntrenadoresContrato(@PathVariable Long id) {
		return entrenadoresService.obtenerEntrenadoresContratados(id);
	}
}
