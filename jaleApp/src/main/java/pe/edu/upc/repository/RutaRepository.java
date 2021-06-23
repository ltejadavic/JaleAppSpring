package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Ruta;

@Repository
public interface RutaRepository extends JpaRepository<Ruta, Integer>{

}
