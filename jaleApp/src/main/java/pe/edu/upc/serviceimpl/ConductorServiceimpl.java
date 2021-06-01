package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Conductor;
import pe.edu.upc.repository.ConductorRepository;
import pe.edu.upc.service.IConductorService;

@Service
public class ConductorServiceimpl implements IConductorService {
	@Autowired
	private ConductorRepository cR;

	@Override
	public void insert(Conductor con) {
		cR.save(con);

	}

	@Override
	public List<Conductor> list() {
		return cR.findAll();
	}

	@Override
	public void delete(int id) {
		cR.deleteById(id);

	}

}
