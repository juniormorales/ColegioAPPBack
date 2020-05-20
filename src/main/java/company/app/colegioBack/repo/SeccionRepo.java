package company.app.colegioBack.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import company.app.colegioBack.models.Nivel;
import company.app.colegioBack.models.Seccion;

public interface SeccionRepo extends JpaRepository<Seccion, Integer>{
	
	List<Seccion> findByNivel(Nivel nivel);
}	
