package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Calificacion")
public class Calificacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCalificacion;
	@Column(name = "calificacion", nullable = false)
	private int calificacion;
	@Column(name = "descripcion", nullable = false, length = 50)
	private String descripcion;
	@ManyToOne
	@JoinColumn(name="idViaje",nullable=false)
	private Viaje idViaje;

	public Calificacion() {
		super();
	}
	
	public Calificacion(int idCalificacion, int calificacion, String descripcion, Viaje idViaje) {
		super();
		this.idCalificacion = idCalificacion;
		this.calificacion = calificacion;
		this.descripcion = descripcion;
		this.idViaje = idViaje;
	}

	public int getIdCalificacion() {
		return idCalificacion;
	}

	public void setIdCalificacion(int idCalificacion) {
		this.idCalificacion = idCalificacion;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Viaje getIdViaje() {
		return idViaje;
	}

	public void setIdViaje(Viaje idViaje) {
		this.idViaje = idViaje;
	}


	
	
	
}
