package company.app.colegioBack.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import company.app.colegioBack.models.Curso;

public interface CursoRepo extends JpaRepository<Curso, Integer>{

}
