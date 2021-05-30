package ar.edu.unju.edm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.Poi;

@Repository
public interface IPoiDAO extends CrudRepository<Poi, Integer> {
	@Query("from Poi c order by c.codigoPoi")
public List<Poi> obtenerPois();
	
	public Optional<Poi> findByCodigoPoi(int codigoPoi);
	

}
