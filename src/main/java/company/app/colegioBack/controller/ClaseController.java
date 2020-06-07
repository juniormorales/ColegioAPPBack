package company.app.colegioBack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import company.app.colegioBack.models.Clase;
import company.app.colegioBack.models.Nivel;
import company.app.colegioBack.service.ClaseService;
import company.app.colegioBack.util.Constantes;

@RestController
@RequestMapping("/api/clases")
public class ClaseController {
	
	
	@Autowired
	ClaseService service;
	

	@GetMapping("/listar")
	public ResponseEntity<?> listar() throws Exception {
		Map<String,Object> response = new HashMap<>();

		try {
			List<Clase> lsClase = service.listar();
			response.put("mensaje",Constantes.msgListarClasesOk);
			response.put("aaData",lsClase);
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
		} catch (Exception e) {
			response.put("mensaje",Constantes.msgListarClasesError);
			response.put("error",e.getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrarClase(@RequestBody Clase Clase){
		Map<String,Object> response = new HashMap<>();
		try {
			Clase resp = service.registrar(Clase);
			response.put("mensaje", Constantes.msgRegistrarClaseOk);
			response.put("defaultObj", resp);
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		}catch(DataAccessException e) {
			response.put("mensaje", Constantes.msgRegistrarClaseError);
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizarClase(@RequestBody Clase Clase){
		Map<String,Object> response = new HashMap<>();
		try {
			Clase resp = service.modificar(Clase);
			response.put("mensaje", Constantes.msgActualizarClaseOk);
			response.put("defaultObj", resp);
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		}catch(DataAccessException e) {
			response.put("mensaje", Constantes.msgActualizarClaseError);
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminarClase(@PathVariable Integer id) {
		Map<String, Object> response = new HashMap<>();
		try {
			Boolean resp = service.eliminar(id);
			if (resp) {
				response.put("estado",Constantes.valTransaccionOk);
				response.put("mensaje", Constantes.msgEliminarOk);

			} else {
				response.put("estado",Constantes.valTransaccionNoEncontro);
				response.put("mensaje", Constantes.msgEliminarError);
			}
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
		}catch(DataIntegrityViolationException e) {
			response.put("mensaje", Constantes.msgEliminarErrorGrave);
			response.put("error", e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/listarPorNivel")
	public ResponseEntity<?> listarPorNivel(@RequestBody Nivel nivel){
		Map<String,Object> response = new HashMap<>();

		try {
			List<Clase> lsClase = service.listarPorNivel(nivel);
			response.put("mensaje",Constantes.msgListarClasesOk);
			response.put("aaData",lsClase);
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
		} catch (Exception e) {
			response.put("mensaje",Constantes.msgListarClasesError);
			response.put("error",e.getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
