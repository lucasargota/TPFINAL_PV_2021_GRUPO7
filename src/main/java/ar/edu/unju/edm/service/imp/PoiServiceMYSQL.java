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

}
