package company.app.colegioBack.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import company.app.colegioBack.dto.PersonaDTO;
import company.app.colegioBack.models.Alumno;
import company.app.colegioBack.models.Persona;
import company.app.colegioBack.models.Profesor;
import company.app.colegioBack.service.AlumnoService;
import company.app.colegioBack.service.ProfesorService;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {
	
	
	@Autowired
	ProfesorService service_profesor;
	
	@Autowired
	AlumnoService service_alumno;
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrarPersona(@RequestBody PersonaDTO personaDTO ){
		
		Persona persona = personaDTO.getPersona();
		int tipo;
		Map<String,Object> response = new HashMap<>();
		
		if(personaDTO.getAlumno() != null) {
			tipo = 1;
		}else {
			tipo = 2;
		}
		
		try {			
			if(tipo == 1) {
				personaDTO.getAlumno().setPersona(persona);
				Alumno alumno = service_alumno.registrar(personaDTO.getAlumno());
				response.put("mensaje","El alumno se ha registrado con éxito!");
				response.put("defaultObj",alumno);
			}else {
				personaDTO.getProfesor().setPersona(persona);
				Profesor profesor = service_profesor.registrar(personaDTO.getProfesor());
				response.put("mensaje","El profesor se ha registrado con éxito!");
				response.put("defaultObj",profesor);
			}
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
			
		}catch(DataAccessException e) {
			if(tipo == 1) {
				response.put("mensaje", "Error al registrar al alumno en la Base de Datos");
			}else {
				response.put("mensaje", "Error al registrar al profesor en la Base de Datos");
			}
			
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	}
	
}
