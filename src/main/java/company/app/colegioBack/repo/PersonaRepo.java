package company.app.colegioBack.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import company.app.colegioBack.models.Persona;

public interface PersonaRepo extends JpaRepository<Persona, Integer> {

}
