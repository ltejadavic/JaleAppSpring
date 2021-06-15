package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Ruta;

public interface IRutaService {
	
	public void insert(Ruta ru);
	
	List<Ruta>list();
	
	public void delete(int id);
}
