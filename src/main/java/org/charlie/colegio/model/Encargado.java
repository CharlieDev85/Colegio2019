package org.charlie.colegio.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "encargado")
public class Encargado {
	private int id;
	private String nombre;
	private Usuario usuario;
	private List<Alumno> alumnos;
}
