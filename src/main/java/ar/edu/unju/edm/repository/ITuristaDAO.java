package ar.edu.unju.edm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.Turista;


@Repository

public interface ITuristaDAO extends CrudRepository<Turista, Integer>{
	@Query("from Turista c order by c.id")
	
	public List<Turista> obtenerTurista();
	public Optional<Turista> findById(Integer id);
	public Optional<Turista> findByEmail(String email);
	
	@Query(value ="SELECT * FROM tpfinal_edm.turistas ORDER BY puntos DESC",nativeQuery=true)
	public List<Turista> turistaMasPuntos();
}
