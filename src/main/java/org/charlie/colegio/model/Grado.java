package org.charlie.colegio.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "grado")
public class Grado {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "grado_id")
	private int id;
	
	@Column(name = "grado_nombre")
	private String grado;
	
	@OneToMany(mappedBy = "grado", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private List<Alumno> alumnos;
	
	@OneToMany(mappedBy = "grado", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private List<Materia> materias;
}
