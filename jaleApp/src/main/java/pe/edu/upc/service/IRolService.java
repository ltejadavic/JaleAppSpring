package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entities.Role;

public interface IRolService {
	public void insert(Role role);

	List<Role> list();
	
	Optional<Role>listarid(Long idrol);

}
