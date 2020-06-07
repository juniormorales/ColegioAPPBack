package company.app.colegioBack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import company.app.colegioBack.models.Turno;
import company.app.colegioBack.repo.TurnoRepo;
import company.app.colegioBack.service.TurnoService;

@Service
public class TurnoServiceImpl implements TurnoService {
	
	@Autowired
	TurnoRepo repo;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Turno registrar(Turno obj) {
		try {
			return repo.save(obj);
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Turno modificar(Turno obj) {
		try {
			return repo.save(obj);
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	public Turno leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Turno> listar() {
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
