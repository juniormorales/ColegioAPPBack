package company.app.colegioBack.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipos_ambiente")
public class TipoAmbiente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTipoAmbiente;
	
	@Column
	private String descripcion;

	public Integer getIdTipoAmbiente() {
		return idTipoAmbiente;
	}

	public void setIdTipoAmbiente(Integer idTipoAmbiente) {
		this.idTipoAmbiente = idTipoAmbiente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
