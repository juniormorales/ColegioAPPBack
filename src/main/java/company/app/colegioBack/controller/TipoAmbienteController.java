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

import company.app.colegioBack.models.Ambiente;
import company.app.colegioBack.models.TipoAmbiente;
import company.app.colegioBack.service.TipoAmbienteService;
import company.app.colegioBack.util.Constantes;

@RestController
@RequestMapping("/api/tipoAmbiente")
public class TipoAmbienteController {

	@Autowired
	TipoAmbienteService service;

	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
		Map<String, Object> response = new HashMap<>();
		try {
			List<TipoAmbiente> lsTiposAmbiente = service.listar();
			response.put("mensaje", Constantes.msgListarTiposAmbientesOk);
			response.put("aaData", lsTiposAmbiente);

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.put("mensaje", Constantes.msgListarTiposAmbientesError);
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/registrar")
	public ResponseEntity<?> registrarTipoAmbiente(@RequestBody TipoAmbiente tip) {
		Map<String, Object> response = new HashMap<>();
		try {
			TipoAmbiente resp = service.registrar(tip);
			response.put("mensaje", Constantes.msgRegistrarTipoAmbienteOk);
			response.put("defaultObj", resp);

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		} catch (DataAccessException e) {
			response.put("mensaje", Constantes.msgRegistrarTipoAmbienteError);
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizarTipoAmbiente(@RequestBody TipoAmbiente tip) {
		Map<String, Object> response = new HashMap<>();
		try {
			TipoAmbiente resp = service.registrar(tip);
			response.put("mensaje", Constantes.msgActualizarTipoAmbienteOk);
			response.put("defaultObj", resp);

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
		} catch (DataAccessException e) {
			response.put("mensaje", Constantes.msgActualizarTipoAmbienteError);
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminarTipoAmbiente(@PathVariable Integer id) {
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
