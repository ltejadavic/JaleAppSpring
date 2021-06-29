package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Reservacion;

@Repository
public interface ReservaRepository extends JpaRepository<Reservacion, Integer>{
	
	@Query( value="SELECT ru.fruta ,count(re.Cruta) from Reservacion re join Ruta ru on ru.Cruta=re.Cruta group by ru.fruta order by 2 desc limit 2",
			nativeQuery = true )
	public List<String[]>rutasmayor();
	
	@Query( value="select co.name_conductor,count(co.id_conductor) from Conductor co join Reservacion re on co.id_conductor=re.id_conductor group by co.id_conductor order by 2 desc limit 2",
			nativeQuery = true )
	public List<String[]>conductormayor();
	
	

}
