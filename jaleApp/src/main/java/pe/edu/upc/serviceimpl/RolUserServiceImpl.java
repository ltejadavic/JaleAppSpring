package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.upc.entities.RolUser;
import pe.edu.upc.repository.RolUserRepository;
import pe.edu.upc.service.IRolUserService;

public class RolUserServiceImpl implements IRolUserService{
	@Autowired
	private RolUserRepository rup;
	
	
	@Override
	public void insert(RolUser ru) {
		rup.save(ru);
		
	}

	@Override
	public List<RolUser> list() {
		// TODO Auto-generated method stub
		return rup.findAll();
	}

	@Override
	public void delete(int id) {
		rup.deleteById(id);
		
	}

}
