package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Poi;
import ar.edu.unju.edm.model.Turista;
@Service
public interface IPoiService {
	public void guardarPoi(Poi unPoi);
	public Poi crearPoi();
	public List<Poi> obtenerTodosPois();
	public void modificarPoi(Poi unPoi) throws Exception;
	void eliminarPoi(Integer codigoPoi) throws Exception;
	Poi encontrarUnPoi(Integer codigoPoi) throws Exception;
	public List<Poi> obtenerMisPois(Turista turistaAutor);
	
}
