package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Conductor;

@Repository
public interface ConductorRepository extends JpaRepository<Conductor, Integer> {

	
	List<Conductor>findBynameConductorLikeIgnoreCase(String name);
	
	@Query("select c from Conductor c where upper(c.nameConductor) like %:name% or lower(c.nameConductor) like %:name%")
	List<Conductor>findByname(String name);
	
}
