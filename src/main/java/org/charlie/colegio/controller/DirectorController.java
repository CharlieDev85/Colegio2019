package org.charlie.colegio.controller;

import java.util.List;

import javax.validation.Valid;

import org.charlie.colegio.model.Catedratico;
import org.charlie.colegio.model.Grado;
import org.charlie.colegio.model.Usuario;
import org.charlie.colegio.service.CatedraticoService;
import org.charlie.colegio.service.GradoService;
import org.charlie.colegio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DirectorController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private GradoService gradoService;
	@Autowired
	private CatedraticoService catedraticoService;
	

	@GetMapping(value= {"/director/index", "/director"})
	public ModelAndView directorIndex(){
		ModelAndView modelAndView = new ModelAndView();
		Usuario director = getUsuarioFromAuth();
		modelAndView.addObject("director", director);
		modelAndView.setViewName("director/index3");
		return modelAndView;
	}

	@GetMapping(value="/director/grados")
	public ModelAndView directorGrados(){
		ModelAndView modelAndView = new ModelAndView();
		Usuario director = getUsuarioFromAuth();
		List<Grado> grados = gradoService.todos();
		modelAndView.addObject("director", director);
		modelAndView.addObject("grados", grados);
		modelAndView.setViewName("director/grados");
		return modelAndView;
	}

	@GetMapping(value="/director/catedraticos")
	public ModelAndView directorCatedraticos() {
		ModelAndView modelAndView = new ModelAndView();
		Usuario director = getUsuarioFromAuth();
		List<Catedratico> catedraticos = catedraticoService.todos();
		modelAndView.addObject("director", director);
		modelAndView.addObject("catedraticos", catedraticos);
		modelAndView.setViewName("director/catedraticos");
		return modelAndView;
	}

	@GetMapping(value="/director/catedraticos/form")
	public ModelAndView directorCatedraticosForm() {
		ModelAndView modelAndView = new ModelAndView();
		Usuario director = getUsuarioFromAuth();
		Catedratico catedratico = new Catedratico();
		modelAndView.addObject("director", director);
		modelAndView.addObject("catedratico", catedratico);
		modelAndView.setViewName("director/catedraticosForm");
		return modelAndView;
	}

	@PostMapping(value="/director/catedraticos/form")
	public  ModelAndView directorCatedraticosFormPost(@Valid Catedratico catedratico, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		Catedratico catedraticoExistentePorNombre = catedraticoService.encontrarPorNombre(catedratico.getNombre());
		Usuario usuarioExistentePorUsuario = usuarioService.encontrarUsuarioPorNombre(catedratico.getUsuario().getUsuarioNombre());
		Usuario usuarioExistentePorCorreoElectronico = usuarioService.encontrarUsuarioPorCorreoElectronico(catedratico.getUsuario().getCorreoElectronico());
		if(catedraticoExistentePorNombre != null) {
			bindingResult.rejectValue("nombre", "error.catedratico", "Nombre de catedratico ya existe");
		}
		if(usuarioExistentePorUsuario != null) {
			bindingResult.rejectValue("usuario.usuarioNombre", "error.catedratico", "Nombre de usuario ya existe");
		}
		if(usuarioExistentePorCorreoElectronico != null) {
			bindingResult.rejectValue("usuario.correoElectronico", "error.catedratico", "Correo Electronico ya existe");
		}		
		if(!catedratico.getUsuario().getContrasena().equals(catedratico.getUsuario().getConfirmarContrasena())) {
			bindingResult.rejectValue("usuario.confirmarContrasena", "error.catedratico", "*Contraseña no coincide");
		}		
		if(bindingResult.hasErrors()) {
			Usuario director = getUsuarioFromAuth();
			modelAndView.addObject("director", director);
			modelAndView.setViewName("director/catedraticosForm");
		} else {
			catedraticoService.guardarCatedratico(catedratico);
			modelAndView.setViewName("redirect:/director/catedraticos");
		}
		return modelAndView;
	}

	public Usuario getUsuarioFromAuth() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String correoElectronico = auth.getName();
		Usuario usuario = usuarioService.encontrarUsuarioPorCorreoElectronico(correoElectronico);
		return usuario;
	}

}
