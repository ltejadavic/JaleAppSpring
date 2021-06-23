package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entities.Conductor;

public interface IConductorService {
	public void insert(Conductor con);

	List<Conductor> list();

	public void delete(int id);
	
	Optional<Conductor>listarid(int idConductor);
	
	List<Conductor>findBynameConductorLikeIgnoreCase(String name);
	
	List<Conductor>findByname(String name);
	
}
