package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entities.Users;

public interface IUserService {
	public void insert(Users users);

	List<Users> list();
	
	Optional<Users> listarid(Long iduser);
	
	
}
