package pe.edu.upc.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Reservacion")
public class Reservacion {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable = false, insertable=false)
    private int id;
	
	@NotNull(message = "Ingrese ruta")
	@ManyToOne
	@JoinColumn(name = "Cruta", nullable = false)
	private Ruta rut;
	
	@NotNull(message = "Ingrese conductor")
	@ManyToOne
	@JoinColumn(name = "idConductor", nullable = false)
	private Conductor con;
	
	@NotNull(message = "Ingrese fecha")
	@Future(message="La fecha	de creacion debe ser futura")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha",nullable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;

	
	public Reservacion() {
		super();
	}
	
	
	public Reservacion(int id,Ruta rut, Conductor con, Date fecha) {
		super();
		this.id=id;
		this.rut = rut;
		this.con = con;
		this.fecha = fecha;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public Ruta getRut() {
		return rut;
	}


	public void setRut(Ruta rut) {
		this.rut = rut;
	}


	public Conductor getCon() {
		return con;
	}


	public void setCon(Conductor con) {
		this.con = con;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	
}
