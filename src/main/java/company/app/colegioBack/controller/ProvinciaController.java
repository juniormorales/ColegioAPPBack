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

import company.app.colegioBack.models.Departamento;
import company.app.colegioBack.models.Provincia;
import company.app.colegioBack.service.ProvinciaService;
import company.app.colegioBack.util.Constantes;


@RestController
@RequestMapping("/api/provincia")
public class ProvinciaController {

	@Autowired
	ProvinciaService service;
	
	@PostMapping("/porDepartamento")
	public ResponseEntity<?> listarPorDepartamento(@RequestBody Departamento depa) throws Exception {
		
		Map<String,Object> response = new HashMap<>();
		
		try {
			List<Provincia> lsprov = service.listarPorDepartamento(depa);
			response.put("mensaje",Constantes.msgListarProvinciaOK);
			response.put("aaData",lsprov);
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
		} catch (Exception e) {
			response.put("mensaje",Constantes.msgListarProvinciaError);
			response.put("error",e.getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
}
