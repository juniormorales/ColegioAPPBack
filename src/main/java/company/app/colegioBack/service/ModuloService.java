package company.app.colegioBack.service;

import java.util.List;

import company.app.colegioBack.models.Modulo;
import company.app.colegioBack.models.Perfil;

public interface ModuloService extends ICRUD<Modulo> {

	List<Modulo> listarModuloPorPerfil(Perfil perfil);

}
