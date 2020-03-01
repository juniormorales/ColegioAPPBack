package company.app.colegioBack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import company.app.colegioBack.models.Modulo;
import company.app.colegioBack.models.Pagina;
import company.app.colegioBack.models.Perfil;
import company.app.colegioBack.repo.ModuloRepo;
import company.app.colegioBack.repo.PaginaRepo;
import company.app.colegioBack.repo.PerfilRepo;
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

		}
	}

}
