package org.charlie.colegio.model;

import java.util.Set;

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
@Table(name = "alumno")
public class Alumno {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "alumno_id")
	private int id;
	
	@Column(name = "alumno_nombre")
	private String nombre;

	@ManyToOne
    @JoinColumn(name="id", insertable = false, updatable = false)
	private Encargado encargado;

	@ManyToOne
    @JoinColumn(name="id", insertable = false, updatable = false)
	private Grado grado;
	
	@OneToMany(mappedBy = "alumno", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private Set<Nota> notas;
}
