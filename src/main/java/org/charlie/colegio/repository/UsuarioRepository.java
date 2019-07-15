package org.charlie.colegio.repository;

import org.charlie.colegio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Usuario findByUsuarioNombre(String usuarioNombre);
	Usuario findByCorreoElectronico(String correoElectronico);
}
