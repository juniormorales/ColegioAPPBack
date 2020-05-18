package company.app.colegioBack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import company.app.colegioBack.models.Grado;
import company.app.colegioBack.models.Nivel;
import company.app.colegioBack.repo.GradoRepo;
import company.app.colegioBack.service.GradoService;

@Service
public class GradoServiceImpl implements GradoService {
	
	@Autowired
	GradoRepo repo;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Grado registrar(Grado obj) {
		try {
			return repo.save(obj);
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Grado modificar(Grado obj) {
		try {
			return repo.save(obj);
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	public Grado leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Grado> listar() {
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

	@Override
	public List<Grado> listarPorNivel(Nivel nivel) {
		try {
			return repo.findByNivel(nivel);
		}catch(Exception e) {
			throw e;
		}
	}

}
