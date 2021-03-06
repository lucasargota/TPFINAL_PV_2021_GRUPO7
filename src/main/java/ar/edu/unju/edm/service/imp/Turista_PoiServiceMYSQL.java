package ar.edu.unju.edm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Poi;
import ar.edu.unju.edm.model.Turista;
import ar.edu.unju.edm.model.Turista_Poi;
import ar.edu.unju.edm.repository.ITurista_PoiDAO;
import ar.edu.unju.edm.service.ITurista_PoiService;

@Service
@Qualifier("implementacion3mysql")
public class Turista_PoiServiceMYSQL implements ITurista_PoiService {

	@Autowired
	Turista_Poi unTurista_Poi;
	@Autowired
	ITurista_PoiDAO turista_PoiDAO;

	@Override
	public void guardarTurista_Poi(Turista_Poi unTurista_Poi) {
		// TODO Auto-generated method stub
		turista_PoiDAO.save(unTurista_Poi);
	}

	@Override
	public Turista_Poi crearTurista_Poi() {
		// TODO Auto-generated method stub
		return unTurista_Poi;
	}

	@Override
	public List<Turista_Poi> obtenerTodosTuristas_Pois() {
		// TODO Auto-generated method stub
		return (List<Turista_Poi>) turista_PoiDAO.findAll();
	}

	@Override
	public void modificarTurista_Poi(Turista_Poi unTurista_PoiModificado) throws Exception {
		// TODO Auto-generated method stub
		Turista_Poi turista_PoiAModificar = turista_PoiDAO.findByIdTP(unTurista_PoiModificado.getIdTP())
				.orElseThrow(() -> new Exception("El Turista_Poi no fue encontrado"));

		cambiarPoi(unTurista_PoiModificado, turista_PoiAModificar);
		System.out.println("guardando poi modificado");
		turista_PoiDAO.save(turista_PoiAModificar);
	}

	private void cambiarPoi(Turista_Poi desde, Turista_Poi hacia) {

		// TODO Auto-generated method stub
		hacia.setComentario(desde.getComentario());
		hacia.setValoracion(desde.getValoracion());
		System.out.println(desde.getIdTP() + "trayendo id");
		hacia.setFechaComentario(desde.getFechaComentario());
		hacia.setHoraComentario(desde.getHoraComentario());
		hacia.setIdTP(desde.getIdTP());

	}

	@Override
	public void eliminarTurista_Poi(Integer idTP) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(idTP + " eliminando");
		// Turista_Poi turista_PoiEliminar =
		// turista_PoiDAO.findByIdTP(idTP).orElseThrow(()->new Exception("El turista_Poi
		// no fue encontrado"));
		// turista_PoiDAO.delete(turista_PoiEliminar);
		turista_PoiDAO.deleteById(idTP);
	}

	@Override
	public Turista_Poi encontrarUnTurista_Poi(Integer idTP) throws Exception {
		// TODO Auto-generated method stub

		return turista_PoiDAO.findByIdTP(idTP).orElseThrow(() -> new Exception("El Turista_Poi NO existe"));
	}

	@Override
	public List<Turista_Poi> obtenerMisComentarios(Turista turistaAutor) {
		// TODO Auto-generated method stub
		return (List<Turista_Poi>) turista_PoiDAO.findAllByTuristaAutor(turistaAutor);
	}

	@Override
	public List<Turista_Poi> obtenerComentariosPoi(Poi otroPoi) {
		// TODO Auto-generated method stub
		return (List<Turista_Poi>) turista_PoiDAO.obtenerValPoi(otroPoi.getCodigoPoi());
	}

}
