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

import com.streetfit.apiFitServer.modelos.AtletasEntity;
import com.streetfit.apiFitServer.service.AtletasService;
import com.streetfit.apiFitServer.service.EntrenadoresService;

@RestController
@RequestMapping("atletas")
public class AtletasController {
	private final AtletasService atletasService;
	private final EntrenadoresService entrenadoresService;

	/**
	 * Inyeccion de dependencia.
	 * @param atletasService
	 */
	@Autowired
	public AtletasController(AtletasService atletasService, EntrenadoresService entrenadoresService) {
		this.atletasService = atletasService;
		this.entrenadoresService = entrenadoresService;
	}
	
	/**
	 * Obtener todos los atletas.
	 * @return
	 */
	@GetMapping
	public List<AtletasEntity> obtenerLista() {
    	return atletasService.obtenerTodos();
	}
	
	/**
	 *  Crear nuevo atleta;
	 * @param atleta
	 * @return
	 */
	@PostMapping("/registro")
	public ResponseEntity<?> crearAtleta(@RequestBody AtletasEntity atleta) {
	    if (!atletasService.obtenerAtletaPorCorreo(atleta.getCorreo()).isEmpty() 
	    		|| !entrenadoresService.obtenerEntrenadorPorCorreo(atleta.getCorreo()).isEmpty()) {
	        return ResponseEntity.status(409)
	                .body(Map.of("error", "correo", "mensaje", "Correo ya existente"));
	    }
		AtletasEntity nuevo = atletasService.guardarAtleta(atleta);
	    return ResponseEntity.ok(nuevo);
	}
	
	/**
	 * 
	 * @param atleta
	 * @return
	 */
	@PostMapping("/login")
	public ResponseEntity<?> obtenerLogin(@RequestBody AtletasEntity atleta) {
    	String correo = atleta.getCorreo();
    	String contraPassword = atleta.getContraPassword();
    	
		AtletasEntity encontrado = atletasService.obtenerLoginAtleta(correo, contraPassword);

	    if (encontrado == null) {
	        return ResponseEntity.status(409)
	            .body(Map.of("error", "correo", "mensaje", "Correo o contraseña no validos"));
	    }
		
	    return ResponseEntity.ok(encontrado);
	}
	
	/**
	 * 
	 * @param correo
	 * @return
	 */
    @GetMapping("/correo/{correo}")
    public List<AtletasEntity> obtenerPorCorreo(@PathVariable String correo) {
        return atletasService.obtenerAtletaPorCorreo(correo);
    }
    
    /**
     * 
     * @param id
     * @return
     */
    @GetMapping("/disponibles/{id}")
    public List<AtletasEntity> obtenerAtletasDisponibles(@PathVariable Long id) {
    	return atletasService.obtenerAtletasDisponibles(id);
    }
}
