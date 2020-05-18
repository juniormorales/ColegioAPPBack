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

import company.app.colegioBack.models.Alumno;
import company.app.colegioBack.service.AlumnoService;
import company.app.colegioBack.util.Constantes;

@RestController
@RequestMapping("/api/alumno")
public class AlumnoController {
	
	@Autowired
	AlumnoService service_alumno;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listarAlumnos(){
		
		Map<String,Object> response = new HashMap<>();
		
		try {
			List<Alumno> lsAlumno = service_alumno.listar();
			response.put("mensaje", Constantes.msgListarAlumnosOk);
			response.put("aaData",lsAlumno);
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);

		}catch(Exception e) {
			response.put("mensaje",Constantes.msgListarAlumnosError);
			response.put("error",e.getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	}
}
