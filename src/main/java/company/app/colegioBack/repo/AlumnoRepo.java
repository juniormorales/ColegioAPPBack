package company.app.colegioBack.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import company.app.colegioBack.models.Alumno;

public interface AlumnoRepo extends JpaRepository<Alumno, Integer> {

}
