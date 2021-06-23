package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer>{
	

}
