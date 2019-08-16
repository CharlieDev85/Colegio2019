package org.charlie.colegio.service;

import java.util.List;

import org.charlie.colegio.model.Grado;
import org.charlie.colegio.repository.GradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("gradoService")
public class GradoService {
	
	@Autowired
	private GradoRepository gradoRepository;
	
	public List<Grado> todos(){
		return gradoRepository.findAll();
	}
	
}
