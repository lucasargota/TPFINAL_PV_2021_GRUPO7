package ar.edu.unju.edm.service.imp;

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
	IPoiDAO PoiDAO;

}
