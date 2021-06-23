package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Marca;
import pe.edu.upc.repository.MarcaRepository;
import pe.edu.upc.service.IMarcaService;

@Service
public class MarcaServiceimpl implements IMarcaService {
	@Autowired
	private MarcaRepository mR;

	@Override
	public void insert(Marca m) {
		mR.save(m);
		
	}

	@Override
	public List<Marca> list() {
		// TODO Auto-generated method stub
		return mR.findAll();
	}

	@Override
	public void delete(int id) {
		mR.deleteById(id);
		
	}

}
