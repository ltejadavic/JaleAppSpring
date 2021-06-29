package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
	
}
