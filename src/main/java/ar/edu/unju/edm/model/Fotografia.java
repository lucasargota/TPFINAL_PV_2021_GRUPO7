package ar.edu.unju.edm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table (name ="FOTOGRAFIAS") 
public class Fotografia {
	
	@Column
	private int idFoto;
	
	@Column
	private String linkFoto;
	
	@ManyToOne
	@JoinColumn(name = "codigoPoi")
	private Poi otroPoi;
	
	public Fotografia() {
		// TODO Auto-generated constructor stub
	}

	public int getIdFoto() {
		return idFoto;
	}

	public void setIdFoto(int idFoto) {
		this.idFoto = idFoto;
	}

	public String getLinkFoto() {
		return linkFoto;
	}

	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}
	
	
}
