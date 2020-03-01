package company.app.colegioBack.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import company.app.colegioBack.models.Perfil;


public interface  PerfilRepo extends JpaRepository<Perfil, Integer>{
	
}
