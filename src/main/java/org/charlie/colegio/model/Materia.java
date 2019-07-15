package org.charlie.colegio.model;

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
@Table(name = "materia")
public class Materia {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "materia_id")
	private int id;
	
	@Column(name = "materia_nombre")
	private String materia;
	
	
	private Grado grado;
	
	@ManyToOne
    @JoinColumn(name="id", nullable=false)
	private Catedratico catedratico;
}
