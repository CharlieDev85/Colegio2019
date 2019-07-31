package org.charlie.colegio.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="id", insertable = false, updatable = false)
	private Grado grado;
	
	@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="id", insertable = false, updatable = false)
	private Catedratico catedratico;
	
	@OneToMany(mappedBy = "materia", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private List<Tarea> tareas;
	
}
