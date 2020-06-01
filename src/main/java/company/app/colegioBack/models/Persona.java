package company.app.colegioBack.models;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name =" personas")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPersona;
	
	@Column(nullable=false)
	private Integer dni;
	
	@Column( nullable=true)
	private String urlFoto;
	
	@Column(nullable = false)
	private String nombres;
	
	@Column(nullable = false)
	private String apellidos;
	
	@Column(name = "fecha_nac", nullable = false)
	private Date fechaNacimiento;
	
	@Column( nullable = false)
	private String direccion;
	
	@Column(nullable = false)
	private String sexo;
	
	@Column(nullable=true)
	private String telefono;
	
	@ManyToOne
	@JoinColumn(name="id_departamento",nullable=false)
	private Departamento departamento;
	
	@ManyToOne
	@JoinColumn(name="id_provincia",nullable=false)
	private Provincia provincia;
	
	@ManyToOne
	@JoinColumn(name="id_distrito",nullable=false)
	private Distrito distrito;
	
	@ManyToOne
	@JoinColumn(name="id_tipzona",nullable=true)
	private TipoZona tipoZona;
	
	@Transient
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "profesor")
	@JoinColumn(nullable = true)
	private Profesor Profesor;

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Profesor getProfesor() {
		return Profesor;
	}

	public void setProfesor(Profesor profesor) {
		Profesor = profesor;
	}
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public TipoZona getTipoZona() {
		return tipoZona;
	}

	public void setTipoZona(TipoZona tipoZona) {
		this.tipoZona = tipoZona;
	}
	
}
