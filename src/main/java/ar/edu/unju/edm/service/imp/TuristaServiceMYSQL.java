package ar.edu.unju.edm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import ar.edu.unju.edm.model.Turista;
import ar.edu.unju.edm.repository.ITuristaDAO;
import ar.edu.unju.edm.service.ITuristaService;

@Service
@Qualifier("implementacionmysql")
public class TuristaServiceMYSQL implements ITuristaService{
	@Autowired
	Turista unTurista;
	@Autowired 
	ITuristaDAO turistaDAO;

	@Override
	public void guardarTurista(Turista unTurista) {
		// TODO Auto-generated method stub
		turistaDAO.save(unTurista);
	}

	@Override
	public Turista crearTurista() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Turista> obtenerTodosTuristas() {
		// TODO Auto-generated method stub
		return null;
	}

}
