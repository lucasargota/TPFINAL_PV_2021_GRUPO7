package ar.edu.unju.edm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.Poi;

@Repository
public interface IPoiDAO extends CrudRepository<Poi, Integer> {
	@Query("from Cliente c order by c.codigoPoi")
	public List<Poi> obtenerPoi();
	

}
