package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Calificacion;
import pe.edu.upc.repository.CalificacionRepository;
import pe.edu.upc.service.ICalificacionService;

@Service
public class CalificacionServiceImpl implements ICalificacionService{

	@Autowired
	private CalificacionRepository cR;
	
	@Override
	public void insert(Calificacion cali) {
		// TODO Auto-generated method stub
		cR.save(cali);
	}

	@Override
	public List<Calificacion> list() {
		// TODO Auto-generated method stub
		return cR.findAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		cR.deleteById(id);
	}

	@Override
	public List<String[]> calificacionmayor() {
		// TODO Auto-generated method stub
		return cR.calificacionmayor();
	}

}
