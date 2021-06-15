package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Pasajero;
import pe.edu.upc.repository.PasajeroRepository;
import pe.edu.upc.service.IPasajeroService;

@Service
public class PasajeroServiceimpl implements IPasajeroService {
	@Autowired
	private PasajeroRepository pR;

	@Override
	public void insert(Pasajero pas) {
		pR.save(pas);

	}

	@Override
	public List<Pasajero> list() {
		return pR.findAll();
	}

	@Override
	public void delete(int id) {
		pR.deleteById(id);

	}

}
