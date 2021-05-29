package ar.edu.unju.edm.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import ar.edu.unju.edm.model.Turista;


@Repository

public interface ITuristaDAO extends CrudRepository<Turista, Integer>{
	@Query("from Cliente c order by c.nroDocumento")
	public List<Turista> obtenerTurista();
	
	
	

}