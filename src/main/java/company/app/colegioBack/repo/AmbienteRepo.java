package company.app.colegioBack.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import company.app.colegioBack.models.Ambiente;

public interface AmbienteRepo extends JpaRepository<Ambiente, Integer> {
	
	Ambiente findByNumero(Integer numero);
	
	List<Ambiente> findByEstado(Boolean estado);
}
