package com.streetfit.apiFitServer.controladores;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.streetfit.apiFitServer.modelos.RutinasEntity;
import com.streetfit.apiFitServer.service.RutinasService;

@RestController
@RequestMapping("rutinas")
public class RutinasController {
	private final RutinasService rutinasService;

	@Autowired
	public RutinasController(RutinasService rutinasService) {
		this.rutinasService = rutinasService;
	}
	
	/**
	 * Sirve para obtener todas las rutinas creadas por el creador.
	 * @return
	 */
	@GetMapping
	public List<RutinasEntity> obtenerRutinas() {
		return rutinasService.obtenerTodas();
	}
	
	/**
	 * 
	 * @param identificacionCreador
	 * @return
	 */
	@GetMapping("/creador/{identificacionCreador}")
	public List<RutinasEntity> obtenerRutinasPorCreador(@PathVariable String identificacionCreador) {
		return rutinasService.obtenerTodasPorIdentificacionCreador(identificacionCreador);
	}
	
	/**
	 * Metodo para crear las rutinas.
	 * @param rutina
	 * @return
	 */
	@PostMapping("/crear")
	public ResponseEntity<?> crearRutina(@RequestBody RutinasEntity rutina) {
		if (!rutinasService.obtenerTodasPorNombre(rutina.getNombre()).isEmpty()) {
	        return ResponseEntity.status(409)
	                .body(Map.of("error", "nombre", "mensaje", "El nombre de la rutina ya existe"));
		}
		
		RutinasEntity nueva = rutinasService.guardar(rutina);
		return ResponseEntity.ok(nueva);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public RutinasEntity obtenerRutinasPorId(@PathVariable Long id) {
		return rutinasService.obtenerRutinaPorId(id);
	}
	
	@PutMapping("/detalles-editar/{id}")
	public ResponseEntity<?> actualizarRutina(@PathVariable Long id, @RequestBody RutinasEntity rutina) {
		if (rutinasService.obtenerRutinaPorId(id) == null) {
	        return ResponseEntity.status(409)
	                .body(Map.of("error", "id", "mensaje", "La rutina no existe"));
		}
		RutinasEntity rutinaExiste = rutinasService.obtenerRutinaPorId(id);
		
		
		List<RutinasEntity> rutinasConMismoNombre = rutinasService.obtenerTodasPorNombre(rutina.getNombre());
		boolean existeOtraRutina = rutinasConMismoNombre.stream()
		        .anyMatch(r -> !r.getId().equals(id));
		
		if (existeOtraRutina) {
	        return ResponseEntity.status(409)
	                .body(Map.of("error", "nombre", "mensaje", "El nombre de la rutina ya existe"));
		}
		
		rutinaExiste.setNombre(rutina.getNombre());
		rutinaExiste.setGrupoMuscular(rutina.getGrupoMuscular());
		rutinaExiste.setSeries(rutina.getSeries());
		rutinaExiste.setRepeticiones(rutina.getRepeticiones());
		rutinaExiste.setPeso(rutina.getPeso());
		return ResponseEntity.ok(rutinasService.guardar(rutinaExiste));
	}
	
	/**
	 * Metodo para borrar las rutinas por su id.
	 * @param contrato
	 * @return
	 */
	@DeleteMapping("/detalles-editar/{id}")
	public ResponseEntity<?> borrarRutina(@PathVariable Long id) {
		if (rutinasService.obtenerRutinaPorId(id) == null) {
	        return ResponseEntity.status(404)
	                .body(Map.of("error", "id", "mensaje", "La rutina no existe"));
		}
		rutinasService.borrarPorId(id);
		return ResponseEntity.noContent().build();
	}
	
}
