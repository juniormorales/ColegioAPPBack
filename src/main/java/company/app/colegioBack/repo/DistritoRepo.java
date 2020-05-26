package company.app.colegioBack.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import company.app.colegioBack.models.Distrito;
import company.app.colegioBack.models.Provincia;


public interface DistritoRepo extends JpaRepository<Distrito, Integer>{

	List<Distrito> findByProvincia(Provincia prov);

}
