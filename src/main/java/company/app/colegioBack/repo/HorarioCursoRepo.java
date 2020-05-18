package company.app.colegioBack.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import company.app.colegioBack.models.HorarioCurso;

public interface HorarioCursoRepo extends JpaRepository<HorarioCurso, Integer> {

}
