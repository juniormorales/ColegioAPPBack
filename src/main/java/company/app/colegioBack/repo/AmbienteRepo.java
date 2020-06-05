package company.app.colegioBack.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import company.app.colegioBack.models.Ambiente;

public interface AmbienteRepo extends JpaRepository<Ambiente, Integer> {
	
	Ambiente findByNumero(Integer numero);
}
