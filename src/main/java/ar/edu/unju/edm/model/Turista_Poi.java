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
	private int valoracion;
	
	@Column
	private String comentario;
	
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Turista otroTurista;
	
	@ManyToOne
	@JoinColumn(name = "codigoPoi")
	private Poi otroPoi;
	
	public Turista_Poi() {
		// TODO Auto-generated constructor stub
	}

	

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Turista getOtroTurista() {
		return otroTurista;
	}

	public void setOtroTurista(Turista otroTurista) {
		this.otroTurista = otroTurista;
	}

	public Poi getOtroPoi() {
		return otroPoi;
	}

	public void setOtroPoi(Poi otroPoi) {
		this.otroPoi = otroPoi;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
		result = prime * result + ((idTP == null) ? 0 : idTP.hashCode());
		result = prime * result + ((otroPoi == null) ? 0 : otroPoi.hashCode());
		result = prime * result + ((otroTurista == null) ? 0 : otroTurista.hashCode());
		result = prime * result + valoracion;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turista_Poi other = (Turista_Poi) obj;
		if (comentario == null) {
			if (other.comentario != null)
				return false;
		} else if (!comentario.equals(other.comentario))
			return false;
		if (idTP == null) {
			if (other.idTP != null)
				return false;
		} else if (!idTP.equals(other.idTP))
			return false;
		if (otroPoi == null) {
			if (other.otroPoi != null)
				return false;
		} else if (!otroPoi.equals(other.otroPoi))
			return false;
		if (otroTurista == null) {
			if (other.otroTurista != null)
				return false;
		} else if (!otroTurista.equals(other.otroTurista))
			return false;
		if (valoracion != other.valoracion)
			return false;
		return true;
	}

	public Turista_Poi(Integer idTP, int valoracion, String comentario, Turista otroTurista, Poi otroPoi) {
		super();
		this.idTP = idTP;
		this.valoracion = valoracion;
		this.comentario = comentario;
		this.otroTurista = otroTurista;
		this.otroPoi = otroPoi;
	}

	public Integer getIdTP() {
		return idTP;
	}

	public void setIdTP(Integer idTP) {
		this.idTP = idTP;
	}


	
	

}

	
	
	

