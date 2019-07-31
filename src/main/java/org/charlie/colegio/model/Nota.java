package org.charlie.colegio.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
@Table(name = "nota")
@IdClass(NotaId.class)
public class Nota {
	
	@Id
	@Column(name = "alumno_id")	
	private Integer alumnoId;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="alumno_id", insertable = false, updatable = false)
	private Alumno alumno;
	
	@Id
	@Column(name = "tarea_id")
	private Integer tareaId;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="tarea_id", insertable = false, updatable = false)
	private Tarea tarea;
	
	@Column(name = "nota_obtenida")
	private Integer notaObtenida;
	
	@Column(name = "observaciones")
	private String observaciones;
}
