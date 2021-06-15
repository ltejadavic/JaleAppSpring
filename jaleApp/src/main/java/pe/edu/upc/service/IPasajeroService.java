package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;


import pe.edu.upc.entities.Pasajero;

public interface IPasajeroService {
	public void insert(Pasajero pas);

	List<Pasajero> list();

	public void delete(int id);

	Optional<Pasajero> listarid(int idPasajero);

	List<Pasajero> findBynamePasajeroLikeIgnoreCase(String name);

	List<Pasajero> findByname(String name);

}
