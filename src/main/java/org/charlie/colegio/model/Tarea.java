package org.charlie.colegio.model;

import java.util.Date;

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
@Table(name = "tarea")
public class Tarea {
	private int id;
	private Materia materia;
	private Bimestre bimestre;
	private Tipo tipo;
	private String description;
	private String lugar;
	private Integer punteoMaximo;
	private Date fechaEntrega;
	private Nota nota;
}
