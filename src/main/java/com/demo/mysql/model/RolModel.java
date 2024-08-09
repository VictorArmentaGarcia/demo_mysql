package com.demo.mysql.model;

import java.io.Serializable;
import java.util.List;

import com.demo.mysql.entity.RolEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class RolModel.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolModel extends AuditoriaModel implements Serializable {

	/**
	 * Instantiates a new rol model.
	 *
	 * @param rolEntity the rol entity
	 */
	public RolModel(RolEntity rolEntity) {
		this.setIdRol(rolEntity.getIdRol());
		this.setRol(rolEntity.getRol());
		this.setUsuario(rolEntity.getUsuario());
		this.setFecCreacion(rolEntity.getFecCreacion());
		this.setFecActualizacion(rolEntity.getFecActualizacion());
	}
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id rol. */
	private int idRol;
	
	/** The rol. */
	private String rol;
	
	/** The usuarios. */
	private List<UsuarioModel> usuarios;
	
}
