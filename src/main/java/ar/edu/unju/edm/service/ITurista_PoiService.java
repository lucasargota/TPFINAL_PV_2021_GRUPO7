package ar.edu.unju.edm.service;

import java.util.List;

import ar.edu.unju.edm.model.Turista;
import ar.edu.unju.edm.model.Turista_Poi;


public interface ITurista_PoiService {
	
	public void guardarTurista_Poi(Turista_Poi unTurista_Poi);
	public Turista_Poi crearTurista_Poi();
	public List<Turista_Poi> obtenerTodosTuristas_Pois();
	public void modificarTurista_Poi(Turista_Poi unTurista_PoiModificado) throws Exception;
	void eliminarTurista_Poi(Integer idTP) throws Exception;
	Turista_Poi encontrarUnTurista_Poi(Integer idTP) throws Exception;
	public List<Turista_Poi> obtenerMisComentarios(Turista turistaAutor);

}
