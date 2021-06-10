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
	public byte[] getFotografia() {
		return fotografia;
	}

	public void setFotografia(byte[] fotografia) {
		this.fotografia = fotografia;
	}

	@Column
	private String localidad;
	@Column
	private int localizacionLatitud;
	@Column
	private int localizacionLongitud;
	@Column
	private byte[] fotografia;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Turista otroTurista;

	public Poi() {
		// TODO Auto-generated constructor stub
	}

	public Poi(Integer codigoPoi, String nombre, String descripcion, String etiqueta, String sitioWeb, String calle,
			int numeroCasa, String barrio, String localidad, int localizacionLatitud, int localizacionLongitud) {
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



	public void setLocalizacionLongitud(int localizacionLongitud) {
		this.localizacionLongitud = localizacionLongitud;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barrio == null) ? 0 : barrio.hashCode());
		result = prime * result + ((calle == null) ? 0 : calle.hashCode());
		result = prime * result + ((codigoPoi == null) ? 0 : codigoPoi.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((etiqueta == null) ? 0 : etiqueta.hashCode());
		result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
		result = prime * result + localizacionLatitud;
		result = prime * result + localizacionLongitud;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + numeroCasa;
		result = prime * result + ((sitioWeb == null) ? 0 : sitioWeb.hashCode());
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
		Poi other = (Poi) obj;
		if (barrio == null) {
			if (other.barrio != null)
				return false;
		} else if (!barrio.equals(other.barrio))
			return false;
		if (calle == null) {
			if (other.calle != null)
				return false;
		} else if (!calle.equals(other.calle))
			return false;
		if (codigoPoi == null) {
			if (other.codigoPoi != null)
				return false;
		} else if (!codigoPoi.equals(other.codigoPoi))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (etiqueta == null) {
			if (other.etiqueta != null)
				return false;
		} else if (!etiqueta.equals(other.etiqueta))
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		if (localizacionLatitud != other.localizacionLatitud)
			return false;
		if (localizacionLongitud != other.localizacionLongitud)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numeroCasa != other.numeroCasa)
			return false;
		if (sitioWeb == null) {
			if (other.sitioWeb != null)
				return false;
		} else if (!sitioWeb.equals(other.sitioWeb))
			return false;
		return true;
	}

}