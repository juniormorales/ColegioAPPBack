package company.app.colegioBack.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="alumnos_clases")
public class DetalleAlumnoClase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDetalleAlumnoClase;
	
	@Column(name = "periodo", nullable=false)
	private Integer periodo;
	
	@Column(name = "promedio_anual",nullable=false)
	private Double promedioAnual;
	
	//0= Repitio, 1=Estudiando, 2=Aprobo
	@Column(name= "estado_acabado",nullable=false)
	private Integer estadoAcabado;
	
	@Column(name = "observaciones",nullable=true)
	private String observaciones;
	
	@ManyToOne
	@JoinColumn(name = "id_alumno",nullable=false)
	private Alumno alumno;
	
	@ManyToOne
	@JoinColumn(name = "id_clase",nullable=false)
	private Clase clase;

	public Integer getIdDetalleAlumnoClase() {
		return idDetalleAlumnoClase;
	}

	public void setIdDetalleAlumnoClase(Integer idDetalleAlumnoClase) {
		this.idDetalleAlumnoClase = idDetalleAlumnoClase;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}
	
}
