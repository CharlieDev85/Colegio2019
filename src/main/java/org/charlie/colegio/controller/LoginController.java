package org.charlie.colegio.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.charlie.colegio.model.Usuario;
import org.charlie.colegio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(value={"/", "/login"})
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
	
	@GetMapping(value="/registration/director")
    public ModelAndView registerDirector(){
        ModelAndView modelAndView = new ModelAndView();
        Usuario usuario = new Usuario();
        modelAndView.addObject("usuario", usuario);
        modelAndView.setViewName("register-director");
        return modelAndView;
    }
	
	
	
	@PostMapping(value="/registration/director")
	public ModelAndView createDirector(@Valid Usuario usuario, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		Usuario nombreUsuarioYaExistente = usuarioService.encontrarUsuarioPorNombre(usuario.getUsuarioNombre());
		Usuario correoElectronicoYaExistente = usuarioService.encontrarUsuarioPorCorreoElectronico(usuario.getCorreoElectronico());
		if(nombreUsuarioYaExistente != null) {
			bindingResult.rejectValue("usuarioNombre", "error.usuario", "Nombre de director ya existe");
		}		
		if(!usuario.getContrasena().equals(usuario.getConfirmarContrasena())) {
			bindingResult.rejectValue("confirmarContrasena", "error.usuario", "*Contraseña no coincide");
		}		
		if(correoElectronicoYaExistente != null) {
			bindingResult.rejectValue("correoElectronico", "error.usuario", "Correo Electronico ya existe");
		}		
		if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register-director");
        } else {
        		usuarioService.guardarUsuarioDirector(usuario);
  			  	modelAndView.addObject("mensajeExitoso", "Director registrado exitosamente");
  			  	modelAndView.addObject("usuario", new Usuario());
  			  	modelAndView.setViewName("register-director");			  
        }
		return modelAndView;
	}
	
	@GetMapping(value="/default")
    public String defaultAfterLogin(){
		String redirect = "redirect:/";
		Collection<? extends GrantedAuthority> authorities;
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	authorities = auth.getAuthorities();
    	String myRole = authorities.toArray()[0].toString();
    	String director = "director";
    	if(myRole.equals(director)) {
    		redirect = redirect + "director/index";
    	}
    	return redirect;
    }
	
	public Usuario getUsuarioFromAuth() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String correoElectronico = auth.getName();
		Usuario usuario = usuarioService.encontrarUsuarioPorCorreoElectronico(correoElectronico);
		return usuario;
	}

}
