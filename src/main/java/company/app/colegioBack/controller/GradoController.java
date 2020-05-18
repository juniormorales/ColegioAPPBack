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

import company.app.colegioBack.models.Grado;
import company.app.colegioBack.models.Nivel;
import company.app.colegioBack.service.GradoService;
import company.app.colegioBack.util.Constantes;

@RestController
@RequestMapping("/api/grado")
public class GradoController {
	
	@Autowired
	GradoService service;
	
	@PostMapping("/listarPorNivel")
	public ResponseEntity<?> listarPorNivel(@RequestBody Nivel nivel){

		Map<String,Object> response = new HashMap<>();
		
		try {
			List<Grado> lsGrado = service.listarPorNivel(nivel);
			response.put("mensaje", Constantes.msgListarGradoOk);
			response.put("aaData",lsGrado);
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);

		}catch(Exception e) {
			response.put("mensaje",Constantes.msgListarGradoError);
			response.put("error",e.getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	}
}
