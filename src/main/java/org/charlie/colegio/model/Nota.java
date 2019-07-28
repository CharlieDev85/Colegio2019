package org.charlie.colegio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "alumno_id")	
	private Alumno alumno;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tarea_id")
	private Tarea tarea;
	
	@Column(name = "nota_obtenida")
	private Integer notaObtenida;
	
	@Column(name = "observaciones")
	private String observaciones;
}
