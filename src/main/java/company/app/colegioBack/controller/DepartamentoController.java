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

import company.app.colegioBack.models.Departamento;
import company.app.colegioBack.service.DepartamentoService;
import company.app.colegioBack.util.Constantes;

@RestController
@RequestMapping("/api/departamento")
public class DepartamentoController {

	@Autowired
	DepartamentoService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar() throws Exception {
		Map<String,Object> response = new HashMap<>();

		try {
			List<Departamento> lsdepa = service.listar();
			response.put("mensaje",Constantes.msgListarDepartamentoOK);
			response.put("aaData",lsdepa);
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
		} catch (Exception e) {
			response.put("mensaje",Constantes.msgListarDepartamentoError);
			response.put("error",e.getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
