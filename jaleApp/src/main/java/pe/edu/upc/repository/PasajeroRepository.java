package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Pasajero;

@Repository
public interface PasajeroRepository extends JpaRepository<Pasajero, Integer> {

	List<Pasajero> findBynamePasajeroLikeIgnoreCase(String name);

	@Query("select c from Pasajero c where upper(c.namePasajero) like %:name% or lower(c.namePasajero) like %:name%")
	List<Pasajero> findByname(String name);

}
