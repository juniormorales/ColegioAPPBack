package company.app.colegioBack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import company.app.colegioBack.models.Ambiente;
import company.app.colegioBack.repo.AulaRepo;
import company.app.colegioBack.service.AmbienteService;

@Service
public class AmbienteServiceImpl implements AmbienteService {
	
	@Autowired
	AulaRepo repo;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Ambiente registrar(Ambiente obj) {
		try {
			return repo.save(obj);
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Ambiente modificar(Ambiente obj) {
		try {
			return repo.save(obj);
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	public Ambiente leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ambiente> listar() {
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
