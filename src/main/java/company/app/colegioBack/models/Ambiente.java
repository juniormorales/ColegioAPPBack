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
@Table(name = "ambientes")
public class Ambiente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAmbiente;
	
	@Column( nullable=false)
	private Integer numero;
	
	@Column(nullable=false)
	private Integer capacidad;
	
	//false = no disponible , true=disponible
	@Column(nullable=false)
	private Boolean estado;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_ambiente")
	private TipoAmbiente tipoAmbiente;

	public Integer getIdAmbiente() {
		return idAmbiente;
	}

	public void setIdAmbiente(Integer idAula) {
		this.idAmbiente = idAula;
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

	public TipoAmbiente getTipoAmbiente() {
		return tipoAmbiente;
	}

	public void setTipoAmbiente(TipoAmbiente tipoAmbiente) {
		this.tipoAmbiente = tipoAmbiente;
	}
	
}
