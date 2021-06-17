package ar.edu.unju.edm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Poi;
import ar.edu.unju.edm.model.Turista;
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
	public Poi encontrarUnPoi(Integer codigoPoi) throws Exception {
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
	
	
	@Override
	public List<Poi> obtenerMisPois(Turista turistaAutor) {
		// TODO Auto-generated method stub
		return (List<Poi>) poiDAO.findAllByTuristaAutor(turistaAutor) ;
	}
	
	
	private void cambiarPoi(Poi desde, Poi hacia) {
		hacia.setBarrio(desde.getBarrio());
		hacia.setCalle(desde.getCalle());
		hacia.setDescripcion(desde.getDescripcion());
		hacia.setEtiqueta(desde.getEtiqueta());
		hacia.setLocalidad(desde.getLocalidad());
		//hacia.setLocalizacionLatitud(desde.getLocalizacionLatitud());
		//hacia.setLocalizacionLongitud(desde.getLocalizacionLongitud());
		hacia.setFotografia(desde.getFotografia());
		hacia.setImagen(desde.getImagen());
		
		hacia.setFotografia2(desde.getFotografia2());
		hacia.setImagen2(desde.getImagen2());
		
		hacia.setFotografia3(desde.getFotografia3());
		hacia.setImagen3(desde.getImagen3());
		
		
		
		hacia.setNombre(desde.getNombre());
		hacia.setNumeroCasa(desde.getNumeroCasa());
		hacia.setSitioWeb(desde.getSitioWeb());
		}
	
	
	
	@Override
	public void eliminarPoi(Integer codigoPoi) throws Exception {
		// TODO Auto-generated method stub
		Poi poiEliminar = poiDAO.findByCodigoPoi(codigoPoi).orElseThrow(()->new Exception("El Poi no fue encontrado"));
		poiDAO.delete(poiEliminar);
	}


}
