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
import javax.validation.constraints.Size;

@Entity
@Table(name = "Vehiculo")
public class Vehiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVehiculo;

	@NotEmpty(message = "Ingrese numero de placa")
	@Size(min = 6, max = 6)
	@Column(name = "placaVehiculo", nullable = false, length = 50)
	private String placaVehiculo;

	@NotEmpty(message = "Ingrese estado de revision tecnica")
	@Column(name = "revisionVehiculo", nullable = false, length = 50)
	private String revisionVehiculo;

	@NotEmpty(message = "Ingrese marca del vehiculo")
	@Column(name = "marcaVehiculo", nullable = false, length = 50)
	private String marcaVehiculo;

	@ManyToOne
	@JoinColumn(name = "idConductor", nullable = false)
	private Conductor conductor;

	public Vehiculo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehiculo(int idVehiculo, String placaVehiculo, String revisionVehiculo, String marcaVehiculo,
			Conductor conductor) {
		super();
		this.idVehiculo = idVehiculo;
		this.placaVehiculo = placaVehiculo;
		this.revisionVehiculo = revisionVehiculo;
		this.marcaVehiculo = marcaVehiculo;
		this.conductor = conductor;
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getPlacaVehiculo() {
		return placaVehiculo;
	}

	public void setPlacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
	}

	public String getRevisionVehiculo() {
		return revisionVehiculo;
	}

	public void setRevisionVehiculo(String revisionVehiculo) {
		this.revisionVehiculo = revisionVehiculo;
	}

	public String getMarcaVehiculo() {
		return marcaVehiculo;
	}

	public void setMarcaVehiculo(String marcaVehiculo) {
		this.marcaVehiculo = marcaVehiculo;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

}
