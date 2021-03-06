package company.app.colegioBack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import company.app.colegioBack.models.Distrito;
import company.app.colegioBack.models.Provincia;
import company.app.colegioBack.service.DistritoService;
import company.app.colegioBack.util.Constantes;

@RestController
@RequestMapping("/api/distrito")
public class DistritoController {

	@Autowired
	DistritoService service;
	
	@PostMapping("/porProvincia")
	public ResponseEntity<?> listarPorProvincia(@RequestBody Provincia prov) throws Exception {
		
		Map<String,Object> response = new HashMap<>();
	
		try {
			List<Distrito> lsdist = service.listarPorProvincia(prov);
			response.put("mensaje",Constantes.msgListarDistritoOK);
			response.put("aaData",lsdist);
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
		} catch (Exception e) {
			response.put("mensaje",Constantes.msgListarDistritoError);
			response.put("error",e.getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
