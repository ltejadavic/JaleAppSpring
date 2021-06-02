package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.StateViaje;


public interface IStateViajeService {
	public void insert(StateViaje sv );

	List<StateViaje> list();

	public void delete(int id);
}
