package company.app.colegioBack.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	@JoinColumn(name = "id_curso", nullable = false)
	private Curso curso;
	
	@ManyToOne
	@JoinColumn(name = "id_clase", nullable = false)
	private Clase clase;
	
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

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}
	
}
