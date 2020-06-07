package company.app.colegioBack.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import company.app.colegioBack.models.TipoZona;
import company.app.colegioBack.repo.TipoZonaRepo;
import company.app.colegioBack.service.TipoZonaService;



@Service
public class TipoZonaServiceImpl implements TipoZonaService{

	@Autowired
	TipoZonaRepo repo;
		
	@Override
	public TipoZona registrar(TipoZona obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoZona modificar(TipoZona obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoZona leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoZona> listar() {
		try {
			return repo.findAll();
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
