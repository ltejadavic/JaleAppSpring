package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name="Marca")
public class Marca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMarca;
	
	@NotEmpty(message = "Ingrese la marca del auto")
	@Column(name = "nameMarca", nullable = false, length = 50)
	private String nameMarca;
	
	@NotEmpty(message = "Ingrese Modelo")
	@Column(name = "nameModelo", nullable = false, length = 50)
	private String nameModelo;
	
	@NotNull(message = "Ingrese Año del Vehículo")
	@Positive
	@Min(1900)
	@Max(2100)
	@Column(name = "yearAuto", nullable = false)
	private int yearAuto;

	public Marca(int idMarca, @NotEmpty(message = "Ingrese la marca del auto") String nameMarca,
			@NotEmpty(message = "Ingrese Modelo") String nameModelo,
			@Digits(integer = 4, fraction = 0) @Size(min = 4, max = 4) int yearAuto) {
		super();
		this.idMarca = idMarca;
		this.nameMarca = nameMarca;
		this.nameModelo = nameModelo;
		this.yearAuto = yearAuto;
	}

	public Marca() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}

	public String getNameMarca() {
		return nameMarca;
	}

	public void setNameMarca(String nameMarca) {
		this.nameMarca = nameMarca;
	}

	public String getNameModelo() {
		return nameModelo;
	}

	public void setNameModelo(String nameModelo) {
		this.nameModelo = nameModelo;
	}

	public int getYearAuto() {
		return yearAuto;
	}

	public void setYearAuto(int yearAuto) {
		this.yearAuto = yearAuto;
	}

	
}
