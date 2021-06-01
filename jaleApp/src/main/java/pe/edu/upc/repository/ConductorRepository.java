package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Conductor;

@Repository
public interface ConductorRepository extends JpaRepository<Conductor, Integer> {

}
