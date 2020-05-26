package company.app.colegioBack.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import company.app.colegioBack.models.Distrito;
import company.app.colegioBack.models.Provincia;
import company.app.colegioBack.repo.DistritoRepo;
import company.app.colegioBack.service.DistritoService;



@Service
public class DistritoServiceImpl implements DistritoService{
	
	@Autowired
	DistritoRepo repo;
	
	private static final Logger LOG = LoggerFactory.getLogger(Exception.class);

	@Override
	public Distrito registrar(Distrito obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Distrito modificar(Distrito obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Distrito leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Distrito> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Distrito> listarPorProvincia(Provincia prov) {
		try {
			return repo.findByProvincia(prov);
		}catch(Exception e) {
			LOG.error(this.getClass().getSimpleName()+" listarPorProvincia. ERROR : "+e.getMessage());
			throw e;
		}
	}

}
