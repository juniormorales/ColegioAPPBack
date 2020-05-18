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

import company.app.colegioBack.models.Nivel;
import company.app.colegioBack.service.NivelService;
import company.app.colegioBack.util.Constantes;

@RestController
@RequestMapping("/api/nivel")
public class NivelController {
	
	@Autowired
	NivelService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listarNiveles(){
		
		Map<String,Object> response = new HashMap<>();
		
		try {
			List<Nivel> lsNivel = service.listar();
			response.put("mensaje", Constantes.msgListarNivelOk);
			response.put("aaData",lsNivel);
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);

		}catch(Exception e) {
			response.put("mensaje",Constantes.msgListarNivelError);
			response.put("error",e.getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	}
	
}
