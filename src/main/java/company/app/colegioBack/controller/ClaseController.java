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

import company.app.colegioBack.models.Clase;
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
			List<Clase> lsdepa = service.listar();
			response.put("mensaje",Constantes.msgListarClasesOk);
			response.put("aaData",lsdepa);
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
		} catch (Exception e) {
			response.put("mensaje",Constantes.msgListarClasesError);
			response.put("error",e.getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
