package company.app.colegioBack.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aulas")
public class Aula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAula;
	
	@Column( name = "numero", nullable=false)
	private Integer numero;
	
	@Column( name ="capacidad", nullable=false)
	private Integer capacidad;
	
	//false = no disponible , true=disponible
	@Column( name ="estado", nullable=false)
	private Boolean estado;

	public Integer getIdAula() {
		return idAula;
	}

	public void setIdAula(Integer idAula) {
		this.idAula = idAula;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
}
