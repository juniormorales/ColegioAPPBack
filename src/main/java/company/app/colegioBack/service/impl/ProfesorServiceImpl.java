package company.app.colegioBack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import company.app.colegioBack.models.Persona;
import company.app.colegioBack.models.Profesor;
import company.app.colegioBack.repo.PersonaRepo;
import company.app.colegioBack.repo.ProfesorRepo;
import company.app.colegioBack.service.ProfesorService;

@Service
public class ProfesorServiceImpl implements ProfesorService {
	
	@Autowired
	ProfesorRepo repo;
	
	@Autowired
	PersonaRepo repo_persona;
	
	@Override
	@Transactional( readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Profesor registrar(Profesor obj) {
		try {
			Persona response_persona = repo_persona.save(obj.getPersona());
			obj.setPersona(response_persona);
			return repo.save(obj);
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Profesor modificar(Profesor obj) {
		try {
			return repo.save(obj);
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	public Profesor leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Profesor> listar() {
		try {
			return repo.findAll();
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
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
