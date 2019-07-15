package org.charlie.colegio.service;

import org.charlie.colegio.model.Rol;
import org.charlie.colegio.model.Usuario;
import org.charlie.colegio.repository.RolRepository;
import org.charlie.colegio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("usuarioService")
public class UsuarioService {
	private UsuarioRepository usuarioRepository;
	private RolRepository rolRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
    public UsuarioService(UsuarioRepository usuarioRepository,
                       RolRepository rolRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
	
	public Usuario guardarUsuarioDirector(Usuario usuario) {
        usuario.setContrasena(bCryptPasswordEncoder.encode(usuario.getContrasena()));
        Rol rol = rolRepository.findByRol("director");
        usuario.setRol(rol);
        return usuarioRepository.save(usuario);
    }
	
	public Usuario encontrarUsuarioPorNombre(String usuarioNombre) {
		return usuarioRepository.findByUsuarioNombre(usuarioNombre);
	}
	
	public Usuario encontrarUsuarioPorCorreoElectronico(String correoElectronico) {
		return usuarioRepository.findByCorreoElectronico(correoElectronico);
	}
}
