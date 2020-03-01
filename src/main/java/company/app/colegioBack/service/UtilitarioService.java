package company.app.colegioBack.service;

import java.util.List;

import company.app.colegioBack.models.Modulo;
import company.app.colegioBack.models.Pagina;
import company.app.colegioBack.models.Perfil;

public interface UtilitarioService {
	
	public void insertarDatosPerfilesPaginas();

	public void insertarDatosModulo(List<Modulo> modulos);
	public void insertarDatosPagina(List<Pagina> paginas);
	public void insertarDatosPerfil(List<Perfil> perfiles);

	
}
