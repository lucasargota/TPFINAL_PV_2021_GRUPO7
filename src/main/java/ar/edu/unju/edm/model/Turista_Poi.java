package ar.edu.unju.edm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table (name ="TURISTAS_POIS") 
public class Turista_Poi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idTurista_Poi;
	
	@Column
	private int valoracion;
	
	@Column
	private int comentario;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Turista otroTurista;
	
	@ManyToOne
	@JoinColumn(name = "codigoPoi")
	private Poi otroPoi;
	
	public Turista_Poi() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdTurista_Poi() {
		return idTurista_Poi;
	}

	public void setIdTurista_Poi(Integer idTurista_Poi) {
		this.idTurista_Poi = idTurista_Poi;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public int getComentario() {
		return comentario;
	}

	public void setComentario(int comentario) {
		this.comentario = comentario;
	}
	
	
}
