package company.app.colegioBack.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cursos_profesores")
public class DetalleCursoProfesor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDetalleCursoProfesor;
	
	@ManyToOne
	@JoinColumn(name = "id_curso")
	private Curso curso;
	
	@ManyToOne
	@JoinColumn(name = "id_profesor")
	private Profesor profesor;

	public Integer getIdDetalleCursoProfesor() {
		return idDetalleCursoProfesor;
	}

	public void setIdDetalleCursoProfesor(Integer idDetalleCursoProfesor) {
		this.idDetalleCursoProfesor = idDetalleCursoProfesor;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
	
}
