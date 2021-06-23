package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Users;

public interface IUserService {
	public void insert(Users users);

	List<Users> list();
}
