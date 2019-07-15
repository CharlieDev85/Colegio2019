package org.charlie.colegio.model;

import java.util.List;

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
@Table(name = "bimestre")
public class Bimestre {
	private int id;
	private Integer numero;
	private String bimestre;
	List<Tarea> tareas;
}
