package company.app.colegioBack.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import company.app.colegioBack.models.Grado;
import company.app.colegioBack.models.Nivel;

public interface GradoRepo extends JpaRepository<Grado, Integer> {
	
	List<Grado> findByNivel(Nivel nivel);
}
