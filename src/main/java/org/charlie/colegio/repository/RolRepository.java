package org.charlie.colegio.repository;

import org.charlie.colegio.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long>{
	Rol findByRol(String rol);
}
