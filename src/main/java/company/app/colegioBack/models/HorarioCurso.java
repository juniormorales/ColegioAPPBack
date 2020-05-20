package company.app.colegioBack.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "horarios_cursos")
public class HorarioCurso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHorarioCurso;
	
	@Column(name = "hora_inicio", nullable = false)
	private Timestamp horaInicio;
	
	@Column(name = "hora_fin", nullable = false)
	private Timestamp horaFin;
	
	@Column(name = "dias", nullable = false)
	private String dias;
	
	@ManyToOne
	@JoinColumn(name = "id_curso_clase", nullable = false)
	private DetalleClaseCurso detalleClaseCurso;

	
	public Integer getIdHorarioCurso() {
		return idHorarioCurso;
	}

	public void setIdHorarioCurso(Integer idHorario) {
		this.idHorarioCurso = idHorario;
	}

	public Timestamp getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Timestamp horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Timestamp getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Timestamp horaFin) {
		this.horaFin = horaFin;
	}

	public String getDias() {
		return dias;
	}

	public void setDias(String dias) {
		this.dias = dias;
	}

	public DetalleClaseCurso getDetalleClaseCurso() {
		return detalleClaseCurso;
	}

	public void setDetalleClaseCurso(DetalleClaseCurso detalleClaseCurso) {
		this.detalleClaseCurso = detalleClaseCurso;
	}	
}
