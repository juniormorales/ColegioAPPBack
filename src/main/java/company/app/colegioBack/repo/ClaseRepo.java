package company.app.colegioBack.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import company.app.colegioBack.models.Clase;

public interface ClaseRepo extends JpaRepository<Clase, Integer> {

}
