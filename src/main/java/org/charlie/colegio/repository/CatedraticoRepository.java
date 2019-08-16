package org.charlie.colegio.repository;

import java.util.List;

import org.charlie.colegio.model.Catedratico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("catedraticoRepository")
public interface CatedraticoRepository extends JpaRepository<Catedratico, Long>{
	List<Catedratico> findAllByOrderByNombreAsc();
	Catedratico findByNombre(String nombre);
	
}
