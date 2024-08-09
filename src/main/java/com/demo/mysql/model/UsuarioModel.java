package com.demo.mysql.model;

import java.io.Serializable;

import com.demo.mysql.entity.UsuarioEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class UsuarioModel.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioModel extends AuditoriaModel implements Serializable  {

	/**
	 * Instantiates a new usuario model.
	 *
	 * @param userEntity the user entity
	 */
	public UsuarioModel(UsuarioEntity userEntity) {
		this.setIdUsuario(userEntity.getIdUsuario());
		this.setIdRol(userEntity.getRolEntity().getIdRol());
		this.setCorreo(userEntity.getCorreo());
		this.setNombre(userEntity.getNombre());
		this.setApellidoPaterno(userEntity.getApellidoPaterno());
		this.setFecNacimiento(userEntity.getFecNacimiento().toString());
		this.setUsuario(userEntity.getUsuario());
		this.setFecCreacion(userEntity.getFecCreacion());
		this.setFecActualizacion(userEntity.getFecActualizacion());
	}
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id usuario. */
	private int idUsuario;
	
	/** The id rol. */
	private int idRol;
	
	/** The correo. */
	private String correo;
	
	/** The nombre. */
	private String nombre;
	
	/** The apellido paterno. */
	private String apellidoPaterno;
	
	/** The fec nacimiento. */
	private String fecNacimiento;
	
	/** The rol. */
	private RolModel rol;
	
}
