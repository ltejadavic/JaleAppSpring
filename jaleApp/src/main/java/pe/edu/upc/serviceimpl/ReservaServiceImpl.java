package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Reservacion;
import pe.edu.upc.repository.ReservaRepository;
import pe.edu.upc.service.IReservaService;
@Service
public class ReservaServiceImpl implements IReservaService{
	@Autowired
	ReservaRepository reR;
	
	
	@Override
	public void insert(Reservacion re) {
		reR.save(re);
		
	}

	@Override
	public List<Reservacion> list() {
		// TODO Auto-generated method stub
		return reR.findAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		reR.findById(id);
	}

	@Override
	public List<String[]> rutasmayor() {
		// TODO Auto-generated method stub
		return reR.rutasmayor();
	}

	@Override
	public List<String[]> conductormayor() {
		// TODO Auto-generated method stub
		return reR.conductormayor();
	}
	
	

}
