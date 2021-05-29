package ar.edu.unju.edm.service;



import java.util.List;

 
import ar.edu.unju.edm.model.Turista;

public interface ITuristaService {
	public void guardarTurista(Turista unTurista);
	public Turista crearTurista();
	public List<Turista> obtenerTodosTuristas();

}
