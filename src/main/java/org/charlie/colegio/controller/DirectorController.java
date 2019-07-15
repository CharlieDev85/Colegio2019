package org.charlie.colegio.controller;

import org.charlie.colegio.model.Usuario;
import org.charlie.colegio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DirectorController {

	@Autowired
	private UsuarioService usuarioService;	
	
	@GetMapping(value="/director/index")
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
		modelAndView.addObject("director", director);
		modelAndView.setViewName("director/grados");
        return modelAndView;
    }
	
	public Usuario getUsuarioFromAuth() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String correoElectronico = auth.getName();
		Usuario usuario = usuarioService.encontrarUsuarioPorCorreoElectronico(correoElectronico);
		return usuario;
	}

}
