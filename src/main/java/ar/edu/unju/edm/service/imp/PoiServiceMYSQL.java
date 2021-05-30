package ar.edu.unju.edm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Poi;
import ar.edu.unju.edm.repository.IPoiDAO;
import ar.edu.unju.edm.service.IPoiService;
@Service
@Qualifier("implementacionmysql")
public class PoiServiceMYSQL implements IPoiService{
	@Autowired
	Poi unPoi;
	@Autowired 
	IPoiDAO poiDAO;
	@Override
	public void guardarPoi(Poi unPoi) {
		// TODO Auto-generated method stub
		poiDAO.save(unPoi);
	}
	@Override
	public Poi crearPoi() {
		// TODO Auto-generated method stub
		return unPoi;
	}
	@Override
	public List<Poi> obtenerTodosPois() {
		// TODO Auto-generated method stub
		return (List<Poi>) poiDAO.findAll();
	}
	@Override
	public Poi encontrarUnPoi(int codigoPoi) throws Exception {
		// TODO Auto-generated method stub
		return poiDAO.findByCodigoPoi(codigoPoi).orElseThrow(()->new Exception("El Poi NO existe"));
	}
	@Override
	public void modificarPoi(Poi unPoiModificado) throws Exception {
		// TODO Auto-generated method stub
		Poi poiAModificar = poiDAO.findByCodigoPoi(unPoiModificado.getCodigoPoi()).orElseThrow(()->new Exception("El Poi no fue encontrado"));
		 
		cambiarPoi(unPoiModificado, poiAModificar);
		poiDAO.save(poiAModificar);
		
	}
	private void cambiarPoi(Poi desde, Poi hacia) {
		//observen que vamos a pasar todos los atributos del cliente que viene, hacia el cliente que ya está en la BD
		hacia.setBarrio(desde.getBarrio());
		hacia.setCalle(desde.getCalle());
		hacia.setDescripcion(desde.getDescripcion());
		hacia.setEtiqueta(desde.getEtiqueta());
		hacia.setLocalidad(desde.getLocalidad());
		hacia.setLocalizacionLatitud(desde.getLocalizacionLatitud());
		hacia.setLocalizacionLongitud(desde.getLocalizacionLongitud());
		hacia.setNombre(desde.getNombre());
		hacia.setNumeroCasa(desde.getNumeroCasa());
		hacia.setSitioWeb(desde.getSitioWeb());
		//observen que NO se ha cambiado el id, ya que ese atributo no debería permitirse cambiar
	}
	
	
	@Override
	public void eliminarPoi(int codigoPoi) throws Exception {
		// TODO Auto-generated method stub
		Poi poiEliminar = poiDAO.findByCodigoPoi(codigoPoi).orElseThrow(()->new Exception("El Poi no fue encontrado"));
		poiDAO.delete(poiEliminar);
	}

}
