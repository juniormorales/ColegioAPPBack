package company.app.colegioBack.service;

import java.util.List;

import company.app.colegioBack.models.Grado;
import company.app.colegioBack.models.Nivel;

public interface GradoService  extends ICRUD<Grado>{
	
	public List<Grado> listarPorNivel(Nivel nivel);
}
