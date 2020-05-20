package company.app.colegioBack.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clases_cursos")
public class DetalleClaseCurso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDetalleClaseCurso;
	
	@ManyToOne
	@JoinColumn(name = "id_curso_profesor")
	private DetalleCursoProfesor detalleCursoProfesor;
	
	@ManyToOne
	@JoinColumn(name = "id_clase")
	private Clase clase;
}
