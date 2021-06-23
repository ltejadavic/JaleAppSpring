package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Viaje;

public interface IViajeService {
	
	public void insert(Viaje vi);
	List<Viaje>list();
	public void delete(int id);
	
}
