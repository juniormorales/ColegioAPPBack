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
@Table( name = "secciones")
public class Seccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSeccion;
	
	@Column(name = "descripcion", nullable=false)
	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "id_nivel", nullable=false)
	private Nivel nivel;
	
	public String getDescripcion() {
		return descripcion;
	}
	

	public void setDescripcion(String nombre) {
		this.descripcion = nombre;
	}

	public Integer getIdSeccion() {
		return idSeccion;
	}

	public void setIdSeccion(Integer idSeccion) {
		this.idSeccion = idSeccion;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
	
}

