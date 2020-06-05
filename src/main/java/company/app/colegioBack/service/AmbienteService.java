package company.app.colegioBack.service;

import company.app.colegioBack.models.Ambiente;

public interface AmbienteService extends ICRUD<Ambiente>{
	
	Ambiente buscarPorNumero(Integer numero);
	
}
