package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.StateViaje;
import pe.edu.upc.repository.StateViajeRepository;
import pe.edu.upc.service.IStateViajeService;

@Service
public class StateViajeServiceImpl implements IStateViajeService{
	@Autowired
	private StateViajeRepository svR;
	
	
	@Override
	public void insert(StateViaje sv) {
		svR.save(sv);
		
	}

	@Override
	public List<StateViaje> list() {
		// TODO Auto-generated method stub
		return svR.findAll();
	}

	@Override
	public void delete(int id) {
		svR.deleteById(id);
		
	}

}
