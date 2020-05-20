package company.app.colegioBack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import company.app.colegioBack.models.Nivel;
import company.app.colegioBack.models.Seccion;
import company.app.colegioBack.repo.SeccionRepo;
import company.app.colegioBack.service.SeccionService;

@Service
public class SeccionServiceImpl implements SeccionService {
	
	@Autowired
	SeccionRepo repo;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Seccion registrar(Seccion obj) {
		try {
			return repo.save(obj);
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Seccion modificar(Seccion obj) {
		try {
			return repo.save(obj);
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	public Seccion leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seccion> listar() {
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
	public List<Seccion> listarPorNivel(Nivel nivel) {
		try {
			return repo.findByNivel(nivel);
		}catch(Exception e) {
			throw e;
		}
	}

}
