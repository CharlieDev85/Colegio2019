package org.charlie.colegio.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "catedratico")
public class Catedratico {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catedratico_id")
	private int id;
	
	@Column(name = "catedratico_nombre")
	private String nombre;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "catedratico")
	private List<Materia> materias;
}
