package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Optional<Conductor> listarid(int idConductor) {
		// TODO Auto-generated method stub
		return cR.findById(idConductor);
	}

	@Override
	public List<Conductor> findBynameConductorLikeIgnoreCase(String name) {
		// TODO Auto-generated method stub
		return cR.findBynameConductorLikeIgnoreCase(name);
	}

	@Override
	public List<Conductor> findByname(String name) {
		// TODO Auto-generated method stub
		return cR.findByname(name);
	}

}
