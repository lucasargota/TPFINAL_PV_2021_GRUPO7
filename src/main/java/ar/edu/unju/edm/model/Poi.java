package ar.edu.unju.edm.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table (name ="POIS") 
@Component
public class Poi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer codigoPoi;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	@Column
	private String etiqueta;
	@Column
	private String sitioWeb;
	@Column
	private String calle;
	@Column
	private int numeroCasa;
	@Column
	private String barrio;
	@Column
	private String localidad;
	@Column
	private int localizacionLatitud;
	@Column
	private int localizacionLongitud;
	@Column
	private byte[] fotografia;
	@Column(name = "imagen", columnDefinition = "LONGBLOB")
	private String imagen;
	
	@Column
	private byte[] fotografia2;
	@Column(name = "imagen2", columnDefinition = "LONGBLOB")
	private String imagen2;
	
	@Column
	private byte[] fotografia3;
	@Column(name = "imagen3", columnDefinition = "LONGBLOB")
	private String imagen3;
	
	
	@Column 
	private double valFinal = 0;
	
		@ManyToOne
	@JoinColumn(name = "idTurista")
	private Turista turistaAutor;
		
		@OneToMany(mappedBy= "otroPoi", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
		private List<Turista_Poi> turistaVal;
		
		
		
		
		
		
		
		
	
	
	public List<Turista_Poi> getTuristaVal() {
			return turistaVal;
		}

		public void setTuristaVal(List<Turista_Poi> turistaVal) {
			this.turistaVal = turistaVal;
		}

	public double getValFinal() {
		return valFinal;
	}

	public void setValFinal(double valFinal) {
		this.valFinal = valFinal;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public Poi() {
		// TODO Auto-generated constructor stub
	}

	



	

	

	public Poi(Integer codigoPoi, String nombre, String descripcion, String etiqueta, String sitioWeb, String calle,
			int numeroCasa, String barrio, String localidad, int localizacionLatitud, int localizacionLongitud,
			byte[] fotografia, String imagen, byte[] fotografia2, String imagen2, byte[] fotografia3, String imagen3,
			Turista turistaAutor) {
		super();
		this.codigoPoi = codigoPoi;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.etiqueta = etiqueta;
		this.sitioWeb = sitioWeb;
		this.calle = calle;
		this.numeroCasa = numeroCasa;
		this.barrio = barrio;
		this.localidad = localidad;
		this.localizacionLatitud = localizacionLatitud;
		this.localizacionLongitud = localizacionLongitud;
		this.fotografia = fotografia;
		this.imagen = imagen;
		this.fotografia2 = fotografia2;
		this.imagen2 = imagen2;
		this.fotografia3 = fotografia3;
		this.imagen3 = imagen3;
		this.turistaAutor = turistaAutor;
	}

	public byte[] getFotografia() {
		return fotografia;
	}

	public void setFotografia(byte[] fotografia) {
		this.fotografia = fotografia;
	}	
	
	public Integer getCodigoPoi() {
		return codigoPoi;
	}



	public void setCodigoPoi(Integer codigoPoi) {
		this.codigoPoi = codigoPoi;
	}

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getEtiqueta() {
		return etiqueta;
	}



	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}



	public String getSitioWeb() {
		return sitioWeb;
	}



	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}



	public String getCalle() {
		return calle;
	}



	public void setCalle(String calle) {
		this.calle = calle;
	}



	public int getNumeroCasa() {
		return numeroCasa;
	}



	public void setNumeroCasa(int numeroCasa) {
		this.numeroCasa = numeroCasa;
	}



	public String getBarrio() {
		return barrio;
	}



	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}



	public String getLocalidad() {
		return localidad;
	}



	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}



	public int getLocalizacionLatitud() {
		return localizacionLatitud;
	}



	public void setLocalizacionLatitud(int localizacionLatitud) {
		this.localizacionLatitud = localizacionLatitud;
	}



	public int getLocalizacionLongitud() {
		return localizacionLongitud;
	}



	public byte[] getFotografia2() {
		return fotografia2;
	}

	public void setFotografia2(byte[] fotografia2) {
		this.fotografia2 = fotografia2;
	}

	public String getImagen2() {
		return imagen2;
	}

	public void setImagen2(String imagen2) {
		this.imagen2 = imagen2;
	}

	public byte[] getFotografia3() {
		return fotografia3;
	}

	public void setFotografia3(byte[] fotografia3) {
		this.fotografia3 = fotografia3;
	}

	public String getImagen3() {
		return imagen3;
	}

	public void setImagen3(String imagen3) {
		this.imagen3 = imagen3;
	}

	public void setLocalizacionLongitud(int localizacionLongitud) {
		this.localizacionLongitud = localizacionLongitud;
	}

	public Turista getTuristaAutor() {
		return turistaAutor;
	}

	public void setTuristaAutor(Turista turistaAutor) {
		this.turistaAutor = turistaAutor;
	}

}