package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Marca;

public interface IMarcaService {
	public void insert(Marca m);
	
	List<Marca> list();
	
	public void delete (int id);
}
