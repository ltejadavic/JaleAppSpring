package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="StateViaje")
public class StateViaje {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idState;
	@NotEmpty(message = "Ingrese la descripcion del estado de vaije")
	@Column(name = "Dstate", nullable = false, length = 50)
	private String Dstate;
	
	
	
	
	public int getIdState() {
		return idState;
	}
	public void setIdState(int idState) {
		this.idState = idState;
	}
	public String getDstate() {
		return Dstate;
	}
	public void setDstate(String dstate) {
		Dstate = dstate;
	}
	
	public StateViaje() {
		super();
	}
	
	public StateViaje(int idState, @NotEmpty(message = "Ingrese la descripcion del estado de vaije") String dstate) {
		super();
		this.idState = idState;
		Dstate = dstate;
	}
	

}
