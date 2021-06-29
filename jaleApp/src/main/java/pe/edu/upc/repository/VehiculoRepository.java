package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Vehiculo;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {
	
	@Query( value="SELECT C.dni, C.name_conductor, V.placa_vehiculo, M.name_marca, M.name_modelo, M.year_auto from Vehiculo V join Conductor C on V.id_conductor = C.id_conductor join Marca M on V.id_marca = M.id_marca order by 6 desc limit 4",
			nativeQuery = true )
	public List<String[]>vehiculoyear();

}
