package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "Ruta")
public class Ruta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Cruta;
	
	@NotEmpty(message = "Ingrese Ruta de inicio")
	@Column(name = "Druta", nullable = false, length = 50)
	private String Druta;
	@NotEmpty(message = "Ingrese Ruta de finalizacion")
	@Column(name = "Fruta", nullable = false, length = 50)
	private String Fruta;
	
	@NotNull(message = "Ingrese la distancia estimado")
	@Column(name = "distance", nullable = false)
	private int distance;
	
	@NotNull(message = "Ingrese Tiempo estimado")
	@Column(name = "time", nullable = false)
	private int time;
	
	@ManyToOne
	@JoinColumn(name = "idPasajero", nullable = false)
	private Pasajero pass;
	
	@NotNull(message = "Ingrese Costo estimado")
	@Column(name = "costo", nullable = false)
	private int costo;

	public Ruta() {
		super();
	}
	
	
	public Ruta(int cruta,String druta,String fruta,int distance,int time, Pasajero pass,int costo) {
		super();
		Cruta = cruta;
		Druta = druta;
		Fruta = fruta;
		this.time = time;
		this.distance = distance;
		this.pass = pass;
		this.costo = costo;
	}


	public int getCruta() {
		return Cruta;
	}


	public void setCruta(int cruta) {
		Cruta = cruta;
	}


	public String getDruta() {
		return Druta;
	}


	public void setDruta(String druta) {
		Druta = druta;
	}


	public String getFruta() {
		return Fruta;
	}


	public void setFruta(String fruta) {
		Fruta = fruta;
	}


	public int getTime() {
		return time;
	}


	public void setTime(int time) {
		this.time = time;
	}
	public int getDistance() {
		return distance;
	}


	public void setDistance(int distance) {
		this.distance = distance;
	}


	public Pasajero getPass() {
		return pass;
	}


	public void setPass(Pasajero pass) {
		this.pass = pass;
	}


	public int getCosto() {
		return costo;
	}


	public void setCosto(int costo) {
		this.costo = costo;
	}
	
	
	
	
	
	
	
	
}
