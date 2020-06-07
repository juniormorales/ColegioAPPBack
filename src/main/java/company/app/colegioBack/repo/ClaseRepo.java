package company.app.colegioBack.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import company.app.colegioBack.models.Clase;
import company.app.colegioBack.models.Grado;
import company.app.colegioBack.models.Nivel;

public interface ClaseRepo extends JpaRepository<Clase, Integer> {
	
	List<Clase> findByNivel(Nivel nivel);
	
}
