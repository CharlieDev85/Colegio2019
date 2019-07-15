package org.charlie.colegio.repository;

import java.util.List;

import org.charlie.colegio.model.Grado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("gradoRepository")
public interface GradoRepository extends JpaRepository<Grado, Long>{
	List<Grado> findAllByOrderByIdAsc();
}
