package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Ruta;
import pe.edu.upc.repository.RutaRepository;
import pe.edu.upc.service.IRutaService;

@Service
public class RutaServiceImpl implements IRutaService{
	
	@Autowired
	private RutaRepository rp;
	
	@Override
	public void insert(Ruta ru) {
		
		rp.save(ru);
		
	}

	@Override
	public List<Ruta> list() {
		// TODO Auto-generated method stub
		return rp.findAll();
	}

	@Override
	public void delete(int id) {
		rp.deleteById(id);
		
	}

}
