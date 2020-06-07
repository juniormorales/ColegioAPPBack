package company.app.colegioBack.service;

import java.util.List;

import company.app.colegioBack.models.Clase;
import company.app.colegioBack.models.Nivel;

public interface ClaseService extends ICRUD<Clase> {
	
	List<Clase> listarPorNivel(Nivel nivel);
}
