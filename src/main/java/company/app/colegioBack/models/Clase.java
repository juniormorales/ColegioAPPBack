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
	
	
	@Column(name = "turno")
	private String turno;
	
	@ManyToOne
	@JoinColumn(name= "numero_salon")
	private Aula aula;
	
	@ManyToOne
	@JoinColumn(name ="id_nivel", nullable = false)
	private Nivel nivel;
	
	@ManyToOne
	@JoinColumn(name ="id_grado", nullable = false)
	private Grado grado;
	
	@ManyToOne
	@JoinColumn(name ="id_seccion", nullable = false)
	private Seccion seccion;
	
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
	
	public Integer getIdAula() {
		return idClases;
	}

	public void setIdAula(Integer idAula) {
		this.idClases = idAula;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}
}
