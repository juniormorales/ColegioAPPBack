package company.app.colegioBack.repo;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import company.app.colegioBack.models.Modulo;




//@Component
public interface UtilitarioRepo extends JpaRepository<Modulo, Integer>{
	
	//@Query(value="insert into perfiles_pagina (id_perfil, id_pagina) VALUES (1, 1),(1, 2),(1, 3),(1, 4),(1, 5),(1, 6),(1, 7),(1, 8);", nativeQuery = true)
	@Query(value="insert into perfiles_pagina (id_perfil, id_pagina) VALUES (1, 1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8);", nativeQuery = true)
	void insertarPerfilesPagina();
	
}
