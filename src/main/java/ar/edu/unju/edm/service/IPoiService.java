package ar.edu.unju.edm.service;

import java.util.List;

import ar.edu.unju.edm.model.Poi;

public interface IPoiService {
	public void guardarPoi(Poi unPoi);

	public Poi crearPoi();

	public List<Poi> obtenerTodosPois();

	public Poi encontrarUnPoi(int codigoPoi) throws Exception;
	// public Poi encontrarUnPoiId(int id) throws Exception;

	public void modificarPoi(Poi unPoi) throws Exception;

	public void eliminarPoi(int codigoPoi) throws Exception;

}
