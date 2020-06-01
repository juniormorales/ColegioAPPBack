package company.app.colegioBack.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import company.app.colegioBack.models.Alumno;
import company.app.colegioBack.models.Persona;
import company.app.colegioBack.service.AlumnoService;
import company.app.colegioBack.service.PersonaService;
import company.app.colegioBack.util.Constantes;

@RestController
@RequestMapping("/api/alumno")
public class AlumnoController {

	@Autowired
	AlumnoService service_alumno;

	@Autowired
	PersonaService service_persona;

	@GetMapping("/listar")
	public ResponseEntity<?> listarAlumnos() {

		Map<String, Object> response = new HashMap<>();

		try {
			List<Alumno> lsAlumno = service_alumno.listar();
			response.put("mensaje", Constantes.msgListarAlumnosOk);
			response.put("aaData", lsAlumno);

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

		} catch (Exception e) {
			response.put("mensaje", Constantes.msgListarAlumnosError);
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/registrar")
	public ResponseEntity<?> registrarPersona(@RequestBody Alumno alumno) {

		Map<String, Object> response = new HashMap<>();

		try {
			Alumno resp = service_alumno.registrar(alumno);
			response.put("mensaje", Constantes.msgRegistrarAlumnoOk);
			response.put("defaultObj", resp);

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

		} catch (DataAccessException e) {
			response.put("mensaje", Constantes.msgRegistrarAlumnoError);
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}

	@PostMapping("/uploadImage")
	public ResponseEntity<?> subirImagen(@RequestParam("archivo") MultipartFile archivo,
			@RequestParam("id") Integer id) {
		Map<String, Object> response = new HashMap<>();

		try {
			Persona persona = service_persona.leer(id);
			if (!archivo.isEmpty()) {
				String nombreArchivo = UUID.randomUUID().toString() + "_"
						+ archivo.getOriginalFilename().replace(" ", "");
				Path rutaArchivo = Paths.get(Constantes.rutasImagenAlumno).resolve(nombreArchivo).toAbsolutePath();
				Files.copy(archivo.getInputStream(), rutaArchivo);

				String nombreFotoAnterior = persona.getUrlFoto();
				if (nombreFotoAnterior != null && nombreFotoAnterior.length() > 0) {
					Path rutaFotoAnterior = Paths.get(Constantes.rutasImagenAlumno).resolve(nombreFotoAnterior)
							.toAbsolutePath();
					File archivoFotoAnterior = rutaFotoAnterior.toFile();
					if (archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
						archivoFotoAnterior.delete();
					}
				}
				persona.setUrlFoto(nombreArchivo);
				service_persona.modificar(persona);
			}
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		} catch (DataAccessException e) {
			response.put("mensaje", Constantes.errorRegistroFoto);
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (IOException e) {
			response.put("mensaje", Constantes.errorLecturaFoto);
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/uploadImage/img/{nombreFoto:.+}")
	public ResponseEntity<?> verFoto(@PathVariable String nombreFoto) throws Exception{
		Map<String, Object> response = new HashMap<>();
		Path rutaArchivo = Paths.get(Constantes.rutasImagenAlumno).resolve(nombreFoto).toAbsolutePath();
		Resource recurso = null;
		try {
			recurso = new UrlResource(rutaArchivo.toUri());
			if(!recurso.exists() && !recurso.isReadable()){
				throw new RuntimeException(Constantes.errorCargarFoto+nombreFoto);
			}
			
			HttpHeaders cabecera = new HttpHeaders();
			cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+recurso.getFilename()+"\"");
			return new ResponseEntity<Resource>(recurso,cabecera,HttpStatus.OK);

		} catch (MalformedURLException e) {
			response.put("mensaje", Constantes.errorLecturaFoto);
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}catch (RuntimeException e) {
			response.put("mensaje", Constantes.errorLecturaFoto);
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
