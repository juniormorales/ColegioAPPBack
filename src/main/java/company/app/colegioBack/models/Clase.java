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
@Table(name = "clases")
public class Clase {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Integer idClases;
	
	@Column(name = "turno",nullable=false)
	private String turno;
	
	@ManyToOne
	@JoinColumn(name= "id_ambiente",nullable=false)
	private Ambiente ambiente;
	
	@ManyToOne
	@JoinColumn(name ="id_nivel", nullable = false)
	private Nivel nivel;
	
	@ManyToOne
	@JoinColumn(name ="id_grado", nullable = false)
	private Grado grado;
	
	@ManyToOne
	@JoinColumn(name ="id_seccion", nullable = false)
	private Seccion seccion;

	public Integer getIdClases() {
		return idClases;
	}

	public void setIdClases(Integer idClases) {
		this.idClases = idClases;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public Grado getGrado() {
		return grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}
	
	
}
