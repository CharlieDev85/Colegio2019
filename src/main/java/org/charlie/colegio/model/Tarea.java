package org.charlie.colegio.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tarea_id")
	private int id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="id")
	private Materia materia;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="id")
	private Bimestre bimestre;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="id")
	private Tipo tipo;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "lugar")
	private String lugar;
	
	@Column(name = "punteo_maximo")
	private Integer punteoMaximo;
	
	@Column(name = "fecha_entrega")
	private Date fechaEntrega;
	
	private Nota nota;
}
