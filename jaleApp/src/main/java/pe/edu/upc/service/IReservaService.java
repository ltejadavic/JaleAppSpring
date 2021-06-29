package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Reservacion;

public interface IReservaService {

	public void insert(Reservacion re);
	
	List<Reservacion> list();
	
	public void delete(int id);
	
	public List<String[]>rutasmayor();
	
	public List<String[]>conductormayor();
	
	
}
