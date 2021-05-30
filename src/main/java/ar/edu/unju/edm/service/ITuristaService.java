package ar.edu.unju.edm.service;



import java.util.List;

import ar.edu.unju.edm.model.Turista;

public interface ITuristaService {
	public void guardarTurista(Turista unTurista);
	public Turista crearTurista();
	public List<Turista> obtenerTodosTuristas();
	
	
	//public Turista encontrarUnTurista(int dni) throws Exception;
	public Turista encontrarUnTurista(int id) throws Exception;
	//public Optional<Cliente> encontrarUnCliente(int dni);
	public void modificarTurista(Turista unTurista) throws Exception;
	public void eliminarTurista(int id) throws Exception;

}
