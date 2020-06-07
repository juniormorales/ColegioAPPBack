package company.app.colegioBack.service;

import java.util.List;

import company.app.colegioBack.models.Ambiente;

public interface AmbienteService extends ICRUD<Ambiente>{
	
	Ambiente buscarPorNumero(Integer numero);
	
	List<Ambiente> listarAmbientesDisponibles();
	
}
