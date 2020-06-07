package company.app.colegioBack.models;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="turnos")
public class Turno {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTurno;
	
	@Column(nullable=false)
	private String descripcion;
	
	@Column(nullable=false)
	private Time horaInicio;
	
	@Column(nullable=false)
	private Time horaFin;

	public Integer getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(Integer idTurno) {
		this.idTurno = idTurno;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio( Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFin() {
		return horaFin;
	}

	public void setHoraFin( Time horaFin) {
		this.horaFin = horaFin;
	}
	
	
}
