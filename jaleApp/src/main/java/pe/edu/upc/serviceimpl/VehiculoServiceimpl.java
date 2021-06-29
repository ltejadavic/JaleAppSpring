package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Vehiculo;
import pe.edu.upc.repository.VehiculoRepository;
import pe.edu.upc.service.IVehiculoService;

@Service
public class VehiculoServiceimpl implements IVehiculoService {
	@Autowired
	private VehiculoRepository vR;

	@Override
	public void insert(Vehiculo v) {
		vR.save(v);

	}

	@Override
	public List<Vehiculo> list() {

		return vR.findAll();
	}

	@Override
	public void delete(int id) {
		vR.deleteById(id);
	}

	@Override
	public List<String[]> vehiculoyear() {
		return vR.vehiculoyear();
	}

}
