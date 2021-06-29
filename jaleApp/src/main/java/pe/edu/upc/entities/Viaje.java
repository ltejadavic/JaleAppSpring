package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Viaje")
public class Viaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idViaje;
	
	@NotEmpty(message = "Ingrese el Nombre del viaje")
	@Column(name = "nameViaje", nullable = false, length = 50)
	private String nameViaje;
	

	@NotNull(message = "Ingrese Estado de viaje")
	@ManyToOne
	@JoinColumn(name="idState",nullable=false)
	private StateViaje state;
	
	@NotNull(message = "Ingrese reservacion")
	@ManyToOne
	@JoinColumn(name="id",nullable=false)
	private Reservacion reservacion;


	public Viaje() {
		super();
	}


	
	
	
	public Viaje(int idViaje,String nameViaje,StateViaje state,Reservacion reservacion) {
		super();
		this.idViaje = idViaje;
		this.nameViaje = nameViaje;
		
		this.state = state;
		this.reservacion = reservacion;
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


	


	public StateViaje getState() {
		return state;
	}


	public void setState(StateViaje state) {
		this.state = state;
	}


	public Reservacion getReservacion() {
		return reservacion;
	}


	public void setReservacion(Reservacion reservacion) {
		this.reservacion = reservacion;
	}

	

	

	
	
}
