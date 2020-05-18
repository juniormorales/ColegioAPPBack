package company.app.colegioBack.dto;

import company.app.colegioBack.models.Alumno;
import company.app.colegioBack.models.Persona;
import company.app.colegioBack.models.Profesor;

public class PersonaDTO {
	
	private Persona persona;
	
	private Profesor profesor;
	
	private Alumno alumno;

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	
}
