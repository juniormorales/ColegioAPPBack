package company.app.colegioBack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import company.app.colegioBack.models.TipoZona;
import company.app.colegioBack.service.TipoZonaService;
import company.app.colegioBack.util.Constantes;

@RestController
@RequestMapping("/api/tipoZona")
public class TipoZonaController {
	
	@Autowired
	TipoZonaService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar() throws Exception {
		
		Map<String,Object> response = new HashMap<>();

		try {
			List<TipoZona> lstpz = service.listar();
			response.put("mensaje",Constantes.msgListarTipoZonaOK);
			response.put("aaData",lstpz);
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
		} catch (Exception e) {
			response.put("mensaje",Constantes.msgListarTipoZonaError);
			response.put("error",e.getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
