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
@Table(name = "bimestre")
public class Bimestre {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bimestre_id")
	private int id;
	
	@Column(name = "bimestre_numero")
	private Integer numero;
	
	@Column(name = "bimestre_nombre")
	private String bimestre;
	
	@OneToMany(mappedBy = "bimestre", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	List<Tarea> tareas;
}
