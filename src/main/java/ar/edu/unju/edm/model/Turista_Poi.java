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
	private Integer idTP;
	
	@Column
	//@Max
	//@Min
	private double valoracion;
	
	@Column
	private String comentario;
	
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Turista turistaAutor;
	
	@ManyToOne
	@JoinColumn(name = "codigoPoi")
	private Poi otroPoi;
	
	public Turista_Poi() {
		// TODO Auto-generated constructor stub
	}

	

	

	public double getValoracion() {
		return valoracion;
	}





	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
	}





	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	

	public Poi getOtroPoi() {
		return otroPoi;
	}

	public void setOtroPoi(Poi otroPoi) {
		this.otroPoi = otroPoi;
	}



	public Integer getIdTP() {
		return idTP;
	}



	public void setIdTP(Integer idTP) {
		this.idTP = idTP;
	}



	public Turista getTuristaAutor() {
		return turistaAutor;
	}



	public void setTuristaAutor(Turista turistaAutor) {
		this.turistaAutor = turistaAutor;
	}



	


	public Turista_Poi(Integer idTP, int valoracion, String comentario, Turista turistaAutor, Poi otroPoi) {
		super();
		this.idTP = idTP;
		this.valoracion = valoracion;
		this.comentario = comentario;
		this.turistaAutor = turistaAutor;
		this.otroPoi = otroPoi;
	}

	



	

	
	

}

	
	
	

