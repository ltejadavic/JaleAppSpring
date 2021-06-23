package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pe.edu.upc.entities.Viaje;
import pe.edu.upc.repository.ViajeRepository;

import pe.edu.upc.service.IViajeService;

@Service
public class ViajeServiceImpl implements IViajeService{

	@Autowired
	private ViajeRepository vR;

	@Override
	public void insert(Viaje vi) {
		vR.save(vi);
		
	}

	@Override
	public List<Viaje> list() {
		// TODO Auto-generated method stub
		return vR.findAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		vR.deleteById(id);
	}
	
	

}
