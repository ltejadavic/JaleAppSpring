package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Calificacion;

@Repository
public interface CalificacionRepository extends JpaRepository<Calificacion, Integer>{
	
	@Query( value="select vi.name_viaje,ca.calificacion, co.name_conductor, pa.name_pasajero from calificacion ca join viaje vi on vi.id_viaje=ca.id_viaje join reservacion re on re.id=vi.id join conductor co on co.id_conductor=re.id_conductor join ruta ru on ru.cruta=re.cruta join pasajero pa on pa.id_pasajero=ru.id_pasajero order by 2 desc limit 2",
			nativeQuery = true )
	public List<String[]>calificacionmayor();

}
