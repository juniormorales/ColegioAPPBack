package company.app.colegioBack.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "niveles")
public class Nivel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idNivel;
	
	@Column(name = "descripcion", nullable=false)
	private String descripcion;

	public Integer getIdNivel() {
		return idNivel;
	}

	public void setIdNivel(Integer idNivel) {
		this.idNivel = idNivel;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String nombre) {
		this.descripcion = nombre;
	}
	
	
}
