package company.app.colegioBack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import company.app.colegioBack.models.DetalleCursoProfesor;
import company.app.colegioBack.repo.DetalleCursoProfesorRepo;
import company.app.colegioBack.service.DetalleCursoProfesorService;

@Service
public class DetalleCursoProfesorServiceImpl implements DetalleCursoProfesorService {
	
	@Autowired
	DetalleCursoProfesorRepo repo;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public DetalleCursoProfesor registrar(DetalleCursoProfesor obj) {
		try {
			return repo.save(obj);
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public DetalleCursoProfesor modificar(DetalleCursoProfesor obj) {
		try {
			return repo.save(obj);
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	public DetalleCursoProfesor leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetalleCursoProfesor> listar() {
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
