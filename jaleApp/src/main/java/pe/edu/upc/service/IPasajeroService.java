package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Pasajero;

public interface IPasajeroService {
	public void insert(Pasajero pas);

	List<Pasajero> list();

	public void delete(int id);

}
