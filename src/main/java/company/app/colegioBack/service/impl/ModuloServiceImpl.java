package company.app.colegioBack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import company.app.colegioBack.models.Modulo;
import company.app.colegioBack.models.Perfil;
import company.app.colegioBack.repo.ModuloRepo;
import company.app.colegioBack.service.ModuloService;

@Service
public class ModuloServiceImpl implements ModuloService {

	@Autowired
	private ModuloRepo repo;
	
	@Override
	public Modulo registrar(Modulo obj) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public Modulo modificar(Modulo obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Modulo leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Modulo> listar() {
	
			return null;
			
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Modulo> listarModuloPorPerfil(Perfil perfil) {
		try {
			List<Modulo> lsres=repo.listarModuloPorPerfil(perfil.getIdPerfil());
			return lsres;
		}catch(Exception e) {
			return null;
		}
	}
}
