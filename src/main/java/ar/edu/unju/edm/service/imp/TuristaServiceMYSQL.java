package ar.edu.unju.edm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Turista;
import ar.edu.unju.edm.repository.ITuristaDAO;
import ar.edu.unju.edm.service.ITuristaService;

@Service
@Qualifier("implementacion2mysql")
public class TuristaServiceMYSQL implements ITuristaService{
	@Autowired
	Turista unTurista;
	@Autowired 
	ITuristaDAO turistaDAO;

	@Override
	public void guardarTurista(Turista unTurista) {
		// TODO Auto-generated method stub
		String pw = unTurista.getPassword();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		unTurista.setPassword(bCryptPasswordEncoder.encode(pw));
		turistaDAO.save(unTurista);
	}

	@Override
	public Turista crearTurista() {
		// TODO Auto-generated method stub
		return unTurista;
	}

	@Override
	public List<Turista> obtenerTodosTuristas() {
		// TODO Auto-generated method stub
		return (List<Turista>) turistaDAO.findAll();
	}

	@Override
	public Turista encontrarUnTurista(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return turistaDAO.findById(id).orElseThrow(()->new Exception("El Turista NO existe"));

	}

	@Override
	public void modificarTurista(Turista unTuristaModificado) throws Exception {
		// TODO Auto-generated method stub
		Turista turistaAModificar = turistaDAO.findById(unTuristaModificado.getId()).orElseThrow(()->new Exception("El Turista no fue encontrado"));
		 
		cambiarTurista(unTuristaModificado, turistaAModificar);
		turistaDAO.save(turistaAModificar);
		
	}
	private void cambiarTurista(Turista desde, Turista hacia) {
		hacia.setApellido(desde.getApellido());
		hacia.setEmail(desde.getEmail());
		hacia.setLocalizacionLatitud(desde.getLocalizacionLatitud());
		hacia.setLocalizacionLongitud(desde.getLocalizacionLongitud());
		hacia.setNombre(desde.getNombre());
		hacia.setPais(desde.getPais());
		hacia.setPassword(desde.getPassword());
		hacia.setPuntos(desde.getPuntos());
		
		}
	
	

	@Override
	public void eliminarTurista(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Turista turistaEliminar = turistaDAO.findById(id).orElseThrow(()->new Exception("El turista no fue encontrado"));
		turistaDAO.delete(turistaEliminar);
	}

	@Override
	public Turista encontrarPorEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		
		return turistaDAO.findByEmail(email).orElseThrow(()->new Exception("El turista no fue encontrado"));
	}

}
