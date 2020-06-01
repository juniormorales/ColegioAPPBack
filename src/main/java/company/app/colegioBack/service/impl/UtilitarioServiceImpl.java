package company.app.colegioBack.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import company.app.colegioBack.models.Grado;
import company.app.colegioBack.models.Modulo;
import company.app.colegioBack.models.Nivel;
import company.app.colegioBack.models.Pagina;
import company.app.colegioBack.models.Perfil;
import company.app.colegioBack.models.Seccion;
import company.app.colegioBack.repo.GradoRepo;
import company.app.colegioBack.repo.ModuloRepo;
import company.app.colegioBack.repo.NivelRepo;
import company.app.colegioBack.repo.PaginaRepo;
import company.app.colegioBack.repo.PerfilRepo;
import company.app.colegioBack.repo.SeccionRepo;
import company.app.colegioBack.repo.UtilitarioRepo;
import company.app.colegioBack.service.UtilitarioService;

@Service
public class UtilitarioServiceImpl implements UtilitarioService {

	@Autowired
	UtilitarioRepo repoUtilitario;

	@Autowired
	ModuloRepo repoModulo;

	@Autowired
	PaginaRepo repoPagina;

	@Autowired
	PerfilRepo repoPerfil;
	
	@Autowired
	NivelRepo repoNivel;
	
	@Autowired
	GradoRepo repoGrado;
	
	@Autowired
	SeccionRepo repoSeccion;

	public void insertarDatosModulo(List<Modulo> obj) {
		try {
			repoModulo.saveAll(obj);
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " insertarListaModulos. ERROR : " + e.getMessage());

		}
	}

	public void insertarDatosPagina(List<Pagina> obj) {
		try {
			repoPagina.saveAll(obj);
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " insertarPaginas. ERROR : " + e.getMessage());

		}
	}

	public void insertarDatosPerfil(List<Perfil> obj) {
		try {
			repoPerfil.saveAll(obj);
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " insertarPerfiles. ERROR : " + e.getMessage());

		}
	}

	public void insertarDatosPerfilesPaginas() {
		try {
			repoUtilitario.insertarPerfilesPagina();
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " insertarPerfiles. ERROR : " + e.getMessage());

		}
	}

	@Override
	public void insertarGrado(List<Grado> grados) {
		try {
			repoGrado.saveAll(grados);
		}catch(Exception e) {
			System.out.println(this.getClass().getSimpleName() + " insertarGrado. ERROR : " + e.getMessage());

		}
		
	}

	@Override
	public void insertarSeccion(List<Seccion> seccion) {
		try {
			repoSeccion.saveAll(seccion);
		}catch(Exception e) {
			System.out.println(this.getClass().getSimpleName() + " insertarSeccion. ERROR : " + e.getMessage());

		}
		
	}

	@Override
	public void insertarNivel(List<Nivel> nivel) {
		try {
			repoNivel.saveAll(nivel);
		}catch(Exception e) {
			System.out.println(this.getClass().getSimpleName() + " insertarNivel. ERROR : " + e.getMessage());
		}	
	}

	@Override
	public void insertarDepartamento() {
		try {
			repoUtilitario.insertarDepartamento();
		}catch(Exception e) {
			System.out.println(this.getClass().getSimpleName() + " insertarDepartamento. ERROR : " + e.getMessage());
		}
		
	}

	@Override
	public void insertarProvincia() {
		try {
			repoUtilitario.insertarProvincia();
		}catch(Exception e) {
			System.out.println(this.getClass().getSimpleName() + " insertarProvincia. ERROR : " + e.getMessage());
		}
		
	}

	@Override
	public void insertarDistrito() {
		try {
			repoUtilitario.insertarDistrito();
		}catch(Exception e) {
			System.out.println(this.getClass().getSimpleName() + " insertarDistrito. ERROR : " + e.getMessage());
		}
		
	}

	@Override
	public void insertarTipoZona() {
		try {
			repoUtilitario.insertarTipoZona();
		}catch(Exception e) {
			System.out.println(this.getClass().getSimpleName() + " insertarTipoZona. ERROR : " + e.getMessage());
		}
		
	}

}
