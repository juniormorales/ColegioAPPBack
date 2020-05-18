package company.app.colegioBack.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "alumnos")
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAlumno;
	
	@Column(name = "promedio_general")
	private Double promedioGeneral;
	
	@Column(name= "años_estudio")
	private Integer ano_estudio;
	
	@Column(name = "nro_repitencias")
	private Integer nro_repitencias;
	
	@Column(name= "estado")
	private Integer estado;
	
	@OneToOne
	@JoinColumn(name = "id_persona")
	private Persona persona;

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}

	public Double getPromedioGeneral() {
		return promedioGeneral;
	}

	public void setPromedioGeneral(Double promedioGeneral) {
		this.promedioGeneral = promedioGeneral;
	}

	public Integer getAno_estudio() {
		return ano_estudio;
	}

	public void setAno_estudio(Integer ano_estudio) {
		this.ano_estudio = ano_estudio;
	}

	public Integer getNro_repitencias() {
		return nro_repitencias;
	}

	public void setNro_repitencias(Integer nro_repitencias) {
		this.nro_repitencias = nro_repitencias;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	
}