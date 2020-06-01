package company.app.colegioBack.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import company.app.colegioBack.models.Grado;
import company.app.colegioBack.models.Modulo;
import company.app.colegioBack.models.Nivel;
import company.app.colegioBack.models.Pagina;
import company.app.colegioBack.models.Perfil;
import company.app.colegioBack.models.Seccion;
import company.app.colegioBack.service.UtilitarioService;

@RestController
@RequestMapping("/api/utilitario")
public class UtilitarioController {

	@Autowired
	private UtilitarioService service;

	@PostMapping("/llenarBD")
	public void insertarDatos() {
		try {
			List<Modulo> tmp_modulo = new ArrayList<>();
			Modulo modAlumno= this.CrearModulo("Alumno", 1, "mdi mdi-human-child", 2, "app.uial");
			Modulo modAdmi = this.CrearModulo("Administrador", 1, "mdi mdi-account-settings-variant", 1,"app.uiadmi");
			Modulo modGrado = this.CrearModulo("Grados", 1, "mdi mdi-briefcase", 3, "app.uigrado");
			Modulo modAsistencia= this.CrearModulo("Asistencias", 1, "mdi mdi-calendar-check", 4, "app.uiasist");
			Modulo modCursos= this.CrearModulo("Cursos", 1, "mdi mdi-library-books", 5, "app.uicurso");
			Modulo modProfesor= this.CrearModulo("Profesor", 1, "mdi mdi-school", 6, "app.uiprof");
			Modulo modHorarios= this.CrearModulo("Horarios", 1, "mdi  mdi-clock", 7, "app.uihor");
			Modulo modAulas= this.CrearModulo("Aulas", 1, "mdi   mdi-home-variant", 8, "app.uiaula");
			tmp_modulo.add(modAlumno);
			tmp_modulo.add(modAdmi);
			tmp_modulo.add(modGrado);
			tmp_modulo.add(modAsistencia);
			tmp_modulo.add(modCursos);
			tmp_modulo.add(modProfesor);
			tmp_modulo.add(modHorarios);
			tmp_modulo.add(modAulas);
			service.insertarDatosModulo(tmp_modulo);

			List<Pagina> tmp_pagina = new ArrayList<>();
			Pagina ga = this.CrearPagina("Gestion Alumnos", 1, "-", 0, "-", "/gestionalumnos", modAlumno);
			Pagina ca = this.CrearPagina("Registrar Alumno", 1, "mdi mdi-pencil", 0, "-", "/registraralumno", modAlumno);
			Pagina gc = this.CrearPagina("Cuentas y Roles", 1, "mdi  mdi-account-key", 0, "-", "/gestioncuentas", modAdmi);
			Pagina gg = this.CrearPagina("Gestion Grados", 1, "-", 0, "-", "/gestiongrado", modGrado);
			Pagina gas = this.CrearPagina("Gestion Asistencia", 1, "-", 0, "-", "/gestionasistencia", modAsistencia);
			Pagina gcu = this.CrearPagina("Gestion Cursos", 1, "-", 0, "-", "/gestioncurso", modCursos);
			Pagina gpr = this.CrearPagina("Gestion Profesor", 1, "-", 0, "-", "/gestionprofesor", modProfesor);
			Pagina ghr = this.CrearPagina("Gestion Horarios", 1, "-", 0, "-", "/gestionhorarios", modHorarios);
			Pagina gau = this.CrearPagina("Gestion Aulas", 1, "-", 0, "-", "/gestionaulas", modAulas);
			tmp_pagina.add(ga);
			tmp_pagina.add(gc);
			tmp_pagina.add(gg);
			tmp_pagina.add(gas);
			tmp_pagina.add(gcu);
			tmp_pagina.add(gpr);
			tmp_pagina.add(gau);
			tmp_pagina.add(ghr);

			service.insertarDatosPagina(tmp_pagina);

			List<Perfil> tmp_perfil = new ArrayList<>();
			Perfil admi = this.CrearPerfil(1, true, "Administrador");
			tmp_perfil.add(admi);
			service.insertarDatosPerfil(tmp_perfil);
			
			service.insertarDatosPerfilesPaginas();
			
			List<Nivel> tmp_nivel = new ArrayList<>();
			Nivel niv1 = this.CrearNivel("Primaria");
			Nivel niv2 = this.CrearNivel("Secundaria");
			tmp_nivel.add(niv1);
			tmp_nivel.add(niv2);
			
			service.insertarNivel(tmp_nivel);
			
			List<Grado> tmp_grado = new ArrayList<>();
			tmp_grado.add(CrearGrado("1",niv1));
			tmp_grado.add(CrearGrado("2",niv1));
			tmp_grado.add(CrearGrado("3",niv1));
			tmp_grado.add(CrearGrado("4",niv1));
			tmp_grado.add(CrearGrado("5",niv1));
			tmp_grado.add(CrearGrado("6",niv1));
			
			tmp_grado.add(CrearGrado("1",niv2));
			tmp_grado.add(CrearGrado("2",niv2));
			tmp_grado.add(CrearGrado("3",niv2));
			tmp_grado.add(CrearGrado("4",niv2));
			tmp_grado.add(CrearGrado("5",niv2));
			
			service.insertarGrado(tmp_grado);
			
			List<Seccion> tmp_seccion = new ArrayList<>();
			tmp_seccion.add(CrearSeccion("A",niv1));
			tmp_seccion.add(CrearSeccion("B",niv1));
			tmp_seccion.add(CrearSeccion("C",niv1));
			tmp_seccion.add(CrearSeccion("D",niv1));
			tmp_seccion.add(CrearSeccion("E",niv1));
			tmp_seccion.add(CrearSeccion("A",niv2));
			tmp_seccion.add(CrearSeccion("B",niv2));
			tmp_seccion.add(CrearSeccion("C",niv2));
			tmp_seccion.add(CrearSeccion("D",niv2));
			
			service.insertarSeccion(tmp_seccion);
			service.insertarDepartamento();
			service.insertarProvincia();
			service.insertarDistrito();
			service.insertarTipoZona();
			
			

		} catch (Exception e) {

		}
		

	}

	private Modulo CrearModulo(String des, int estado, String icono, int orden, String raiz) {
		Modulo modulo = new Modulo();
		modulo.setDescripcion(des);
		modulo.setEstado(estado);
		modulo.setIcono(icono);
		modulo.setOrden(orden);
		modulo.setRaiz(raiz);

		return modulo;
	}

	private Pagina CrearPagina(String desc, int estado, String icono, int orden, String param, String url,
			Modulo modulo) {
		Pagina pagina = new Pagina();
		pagina.setDescripcion(desc);
		pagina.setEstado(estado);
		pagina.setIcono(icono);
		pagina.setOrden(orden);
		pagina.setParametros(param);
		pagina.setUrl(url);
		pagina.setModulo(modulo);

		return pagina;
	}

	private Perfil CrearPerfil(int ambito, boolean estado, String nombres) {
		Perfil p = new Perfil();
		p.setAmbito(ambito);
		p.setEstado(estado);
		p.setNombres(nombres);
		return p;
	}
	
	private Nivel CrearNivel(String nombre) {
		Nivel n = new Nivel();
		n.setDescripcion(nombre);
		return n;
	}
	
	private Grado CrearGrado(String nombre, Nivel nivel) {
		Grado g = new Grado();
		g.setDescripcion(nombre);
		g.setNivel(nivel);
		return g;
	}
	
	private Seccion CrearSeccion(String nombre,Nivel nivel) {
		Seccion s = new Seccion();
		s.setDescripcion(nombre);
		s.setNivel(nivel);
		return s;
	}

}
