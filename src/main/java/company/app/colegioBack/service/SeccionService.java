package company.app.colegioBack.service;

import java.util.List;

import company.app.colegioBack.models.Nivel;
import company.app.colegioBack.models.Seccion;

public interface SeccionService extends ICRUD<Seccion>{
	
	List<Seccion> listarPorNivel(Nivel nivel);
}
