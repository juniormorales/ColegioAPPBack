package company.app.colegioBack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import company.app.colegioBack.models.TipoAmbiente;
import company.app.colegioBack.repo.TipoAmbienteRepo;
import company.app.colegioBack.service.TipoAmbienteService;

@Service
public class TipoAmbienteServiceImpl implements TipoAmbienteService {
	
	@Autowired
	TipoAmbienteRepo repo;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public TipoAmbiente registrar(TipoAmbiente obj) {
		try {
			return repo.save(obj);
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public TipoAmbiente modificar(TipoAmbiente obj) {
		try {
			return repo.save(obj);
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	public TipoAmbiente leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoAmbiente> listar() {
		try {
			return repo.findAll();
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Boolean eliminar(Integer id) {
		try {
			if(repo.existsById(id)) {
				repo.deleteById(id);
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			throw e;
		}
	}

}
