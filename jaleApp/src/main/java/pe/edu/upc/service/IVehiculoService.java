package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Vehiculo;

public interface IVehiculoService {
	public void insert(Vehiculo v);

	List<Vehiculo> list();

	public void delete(int id);
	public List<String[]>vehiculoyear();
}
