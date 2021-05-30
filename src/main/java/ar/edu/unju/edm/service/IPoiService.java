package ar.edu.unju.edm.service;

import java.util.List;

import ar.edu.unju.edm.model.Poi;

public interface IPoiService {
	public void guardarPoi(Poi unPoi);
	public Poi crearPoi();
	public List<Poi> obtenerTodosPois();

}
