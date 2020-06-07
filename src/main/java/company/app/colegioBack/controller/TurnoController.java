package company.app.colegioBack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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

import company.app.colegioBack.models.Turno;
import company.app.colegioBack.service.TurnoService;
import company.app.colegioBack.util.Constantes;

@RestController
@RequestMapping("/api/turno")
public class TurnoController {
	
	@Autowired
	TurnoService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
		Map<String, Object> response = new HashMap<>();
		try {
			List<Turno> lsturnoosAmbiente = service.listar();
			response.put("mensaje", Constantes.msgListarTurnosOk);
			response.put("aaData", lsturnoosAmbiente);

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.put("mensaje", Constantes.msgListarTurnosError);
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/registrar")
	public ResponseEntity<?> registrarTurno(@RequestBody Turno turno) {
		Map<String, Object> response = new HashMap<>();
		try {
			Turno resp = service.registrar(turno);
			response.put("mensaje", Constantes.msgRegistrarTurnoOk);
			response.put("defaultObj", resp);

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		} catch (DataAccessException e) {
			response.put("mensaje", Constantes.msgRegistrarTurnoError);
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizarTurno(@RequestBody Turno turno) {
		Map<String, Object> response = new HashMap<>();
		try {
			Turno resp = service.registrar(turno);
			response.put("mensaje", Constantes.msgActualizarTurnoOk);
			response.put("defaultObj", resp);

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
		} catch (DataAccessException e) {
			response.put("mensaje", Constantes.msgActualizarTurnoError);
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminarTurno(@PathVariable Integer id) {
		Map<String, Object> response = new HashMap<>();

		Boolean resp = service.eliminar(id);
		if (resp) {
			response.put("estado",Constantes.valTransaccionOk);
			response.put("mensaje", Constantes.msgEliminarOk);

		} else {
			response.put("estado",Constantes.valTransaccionNoEncontro);
			response.put("mensaje", Constantes.msgEliminarError);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
	}

}
