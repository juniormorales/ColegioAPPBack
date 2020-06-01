package company.app.colegioBack.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import company.app.colegioBack.models.Ambiente;

public interface AulaRepo extends JpaRepository<Ambiente, Integer> {

}
