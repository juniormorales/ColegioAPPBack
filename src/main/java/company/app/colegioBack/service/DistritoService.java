package company.app.colegioBack.service;

import java.util.List;

import company.app.colegioBack.models.Distrito;
import company.app.colegioBack.models.Provincia;


public interface DistritoService extends ICRUD<Distrito>{
	
	public List<Distrito> listarPorProvincia(Provincia prov); 

}
