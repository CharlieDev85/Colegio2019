package org.charlie.colegio.model;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
	private int id;
	
	@Column(name = "usuario_nombre")
	@NotEmpty(message = "*Escriba un nombre de Usuario")
	@Length(min = 5, message = "*Usuario debe tener al menos 5 caracteres")
	private String usuarioNombre;
	
	@Column(name = "correo_electronico")
	@NotEmpty(message = "*Escriba un nombre correo electrónico")
	@Email(message = "*Escriba un correo electrónico válido")
	private String correoElectronico;
	
	@Column(name = "contrasena")
	@NotEmpty(message = "*Escriba una contraseña")
	@Length(min = 5, message = "*Contraseña debe tener al menos 5 caracteres")
	private String contrasena;
	
	@Transient
	@NotEmpty(message = "*Este campo no debe estar vacío")
	private String confirmarContrasena;

	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="rol_id")
	private Rol rol;
	
	@OneToOne(mappedBy = "usuario")
	private Catedratico catedratico;
	
	@OneToOne(mappedBy = "usuario")
	private Encargado encargado;
}
