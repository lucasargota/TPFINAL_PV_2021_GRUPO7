package ar.edu.unju.edm.service;

import java.util.List;

import ar.edu.unju.edm.model.Turista;

public interface ITuristaService {
	public void guardarTurista(Turista unTurista);
	public Turista crearTurista();
	public List<Turista> obtenerTodosTuristas();
	public Turista encontrarUnTurista(Integer id) throws Exception;
	public void modificarTurista(Turista unTurista) throws Exception;
	public void eliminarTurista(Integer id) throws Exception;
	public Turista encontrarPorEmail(String email)  throws Exception; 

}
