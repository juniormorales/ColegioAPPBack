package company.app.colegioBack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.exception.ConstraintViolationException;
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

import company.app.colegioBack.models.Ambiente;
import company.app.colegioBack.service.AmbienteService;
import company.app.colegioBack.util.Constantes;

@RestController
@RequestMapping("/api/ambientes")
public class AmbienteController {
	
	@Autowired
	AmbienteService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listarAmbientes(){
		Map<String,Object> response = new HashMap<>();
		try {
			List<Ambiente> lsAmbiente = service.listar();
			response.put("mensaje", Constantes.msgListarAmbientesOk);
			response.put("aaData",lsAmbiente);
			
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		}catch(Exception e) {
			response.put("mensaje", Constantes.msgListarAmbientesError);
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listarDisponibles")
	public ResponseEntity<?> listarAmbientesDisponibles(){
		Map<String,Object> response = new HashMap<>();
		try {
			List<Ambiente> lsAmbiente = service.listarAmbientesDisponibles();
			response.put("mensaje", Constantes.msgListarAmbientesOk);
			response.put("aaData",lsAmbiente);
			
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		}catch(Exception e) {
			response.put("mensaje", Constantes.msgListarAmbientesError);
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrarAmbiente(@RequestBody Ambiente ambiente){
		Map<String,Object> response = new HashMap<>();
		try {
			Ambiente resp = service.registrar(ambiente);
			response.put("mensaje", Constantes.msgRegistrarAmbienteOk);
			response.put("defaultObj", resp);
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		}catch(DataAccessException e) {
			response.put("mensaje", Constantes.msgRegistrarAmbienteError);
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizarAmbiente(@RequestBody Ambiente ambiente){
		Map<String,Object> response = new HashMap<>();
		try {
			Ambiente resp = service.modificar(ambiente);
			response.put("mensaje", Constantes.msgActualizarAmbienteOk);
			response.put("defaultObj", resp);
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		}catch(DataAccessException e) {
			response.put("mensaje", Constantes.msgActualizarAmbienteError);
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminarAmbiente(@PathVariable Integer id) {
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
}
