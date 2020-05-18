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

import company.app.colegioBack.models.Profesor;
import company.app.colegioBack.service.ProfesorService;
import company.app.colegioBack.util.Constantes;

@RestController
@RequestMapping("/api/profesor")
public class ProfesorController {
	
	@Autowired
	ProfesorService service_prof;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listarProfesores(){
		Map<String,Object> response = new HashMap<>();
		
		try {
			List<Profesor> lsProfe = service_prof.listar();
			response.put("mensaje", Constantes.msgListarAlumnosOk);
			response.put("aaData",lsProfe);
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);

		}catch(Exception e) {
			response.put("mensaje",Constantes.msgListarProfesorError);
			response.put("error",e.getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	}
		
}
