package company.app.colegioBack.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import company.app.colegioBack.models.Departamento;
import company.app.colegioBack.models.Provincia;



public interface ProvinciaRepo extends JpaRepository<Provincia, Integer>{

	List<Provincia> findByDepartamento(Departamento depa);

}
