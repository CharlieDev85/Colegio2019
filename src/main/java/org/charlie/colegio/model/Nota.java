package org.charlie.colegio.model;

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
@Table(name = "nota")
public class Nota {
	private Alumno alumno;
	private Tarea tarea;
	private Integer notaObtenida;
	private String observaciones;
}
