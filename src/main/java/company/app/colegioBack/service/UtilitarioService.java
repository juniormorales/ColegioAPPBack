package company.app.colegioBack.service;

import java.util.List;

import company.app.colegioBack.models.Grado;
import company.app.colegioBack.models.Modulo;
import company.app.colegioBack.models.Nivel;
import company.app.colegioBack.models.Pagina;
import company.app.colegioBack.models.Perfil;
import company.app.colegioBack.models.Seccion;

public interface UtilitarioService {
	
	public void insertarDatosPerfilesPaginas();

	public void insertarDatosModulo(List<Modulo> modulos);
	public void insertarDatosPagina(List<Pagina> paginas);
	public void insertarDatosPerfil(List<Perfil> perfiles);
	public void insertarGrado(List<Grado> grados);
	public void insertarSeccion(List<Seccion> seccion);
	public void insertarNivel(List<Nivel> nivel);
	public void insertarDepartamento();
	public void insertarProvincia();
	public void insertarDistrito();
	public void insertarTipoZona();
	
}
