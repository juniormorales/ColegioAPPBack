package company.app.colegioBack.service;

import java.util.List;

import company.app.colegioBack.models.Departamento;
import company.app.colegioBack.models.Provincia;


public interface ProvinciaService extends ICRUD<Provincia>{
	
	public List<Provincia> listarPorDepartamento(Departamento depa);

}
