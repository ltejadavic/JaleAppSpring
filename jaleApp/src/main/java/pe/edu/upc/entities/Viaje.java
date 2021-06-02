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
@Table(name = "Viaje")
public class Viaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idViaje;
	
	@NotEmpty(message = "Ingrese el Nombre del viaje")
	@Column(name = "nameViaje", nullable = false, length = 50)
	private String nameViaje;
	
	@NotNull(message = "Ingrese el costo de su viaje")
	@Column(name = "priceViaje", nullable = false)
	private int priceViaje;
	@NotNull(message = "Ingrese Estado de viaje")
	@ManyToOne
	@JoinColumn(name="idState",nullable=false)
	private StateViaje state;


	public Viaje() {
		super();
	}

	

	public Viaje(int idViaje,String nameViaje,int priceViaje, StateViaje state) {
		super();
		this.idViaje = idViaje;
		this.nameViaje = nameViaje;
		this.priceViaje = priceViaje;
		this.state = state;
	}



	public int getIdViaje() {
		return idViaje;
	}


	public void setIdViaje(int idViaje) {
		this.idViaje = idViaje;
	}


	public String getNameViaje() {
		return nameViaje;
	}


	public void setNameViaje(String nameViaje) {
		this.nameViaje = nameViaje;
	}


	public int getPriceViaje() {
		return priceViaje;
	}


	public void setPriceViaje(int priceViaje) {
		this.priceViaje = priceViaje;
	}


	public StateViaje getState() {
		return state;
	}


	public void setState(StateViaje state) {
		this.state = state;
	}

	
	
}
