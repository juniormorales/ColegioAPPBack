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
	
	@Column(nullable=false)
	private Double promedioGeneral;
	
	@Column(nullable=false)
	private Integer anosEstudio;
	
	@Column(nullable=false)
	private Integer nroRepitencias;
	
	@Column(nullable=false)
	private String familia;
	
	@Column(nullable=true)
	private String colegioProcedencia;
	
	//0 = No Matriculado, 1 = Matriculado, 2 = Repitente, 3 = Suspendido
	@Column(name= "estado",nullable=false)
	private Integer estado;
	
	@OneToOne
	@JoinColumn(name = "id_persona",nullable=false)
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

	public Integer getAnosEstudio() {
		return anosEstudio;
	}

	public void setAnosEstudio(Integer ano_estudio) {
		this.anosEstudio = ano_estudio;
	}

	public Integer getNroRepitencias() {
		return nroRepitencias;
	}

	public void setNroRepitencias(Integer nro_repitencias) {
		this.nroRepitencias = nro_repitencias;
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

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public String getColegioProcedencia() {
		return colegioProcedencia;
	}

	public void setColegioProcedencia(String colegioProcedencia) {
		this.colegioProcedencia = colegioProcedencia;
	}

}
