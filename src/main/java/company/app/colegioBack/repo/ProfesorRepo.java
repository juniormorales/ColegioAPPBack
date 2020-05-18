package company.app.colegioBack.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import company.app.colegioBack.models.Profesor;

public interface ProfesorRepo extends JpaRepository<Profesor, Integer>{

}
