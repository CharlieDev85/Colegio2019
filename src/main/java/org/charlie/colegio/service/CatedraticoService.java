package org.charlie.colegio.service;

import java.util.List;

import org.charlie.colegio.model.Catedratico;
import org.charlie.colegio.model.Rol;
import org.charlie.colegio.repository.CatedraticoRepository;
import org.charlie.colegio.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("catedraticoService")
public class CatedraticoService {
	@Autowired
	private CatedraticoRepository catedraticoRepository;
	@Autowired
	private RolRepository rolRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public List<Catedratico> todos(){
		return catedraticoRepository.findAllByOrderByNombreAsc();
	}
	public Catedratico guardarCatedratico(Catedratico catedratico) {
		Rol rol = rolRepository.findByRol("catedratico");
		catedratico.getUsuario().setRol(rol);
		String encodedPass = bCryptPasswordEncoder.encode(catedratico.getUsuario().getContrasena());
		catedratico.getUsuario().setContrasena(encodedPass);
		return catedraticoRepository.save(catedratico);
	}
	public Catedratico encontrarPorNombre(String nombre) {
		return catedraticoRepository.findByNombre(nombre);
	}
}
