package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Viaje;

@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Integer>{

}
