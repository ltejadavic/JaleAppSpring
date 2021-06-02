package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.StateViaje;

@Repository
public interface StateViajeRepository extends JpaRepository<StateViaje, Integer>{

}
