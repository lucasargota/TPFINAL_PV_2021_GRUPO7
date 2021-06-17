package ar.edu.unju.edm.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.Turista_Poi;
@Repository
public interface ITurista_PoiDAO  extends CrudRepository<Turista_Poi, Integer>{
	@Query("from Turista_Poi c order by c.idTP")
	
	
	public List<Turista_Poi> obtenerTuristas_Pois();
	public Optional<Turista_Poi> findByIdTP(Integer idTP);


}