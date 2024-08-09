package com.demo.mysql.controller;

import java.util.List;

import com.demo.mysql.model.UsuarioModel;

/**
 * The Interface UsuarioController.
 */
public interface UsuarioController {

	/**
	 * Gets the usuarios.
	 *
	 * @return the usuarios
	 */
	List<UsuarioModel> getUsuarios();
	
	/**
	 * Gets the usuario.
	 *
	 * @param idUsuario the id usuario
	 * @return the usuario
	 */
	Object getUsuario(int idUsuario);
	
	/**
	 * Save usuario.
	 *
	 * @param usuario the usuario
	 * @return the usuario model
	 */
	Object saveUsuario(UsuarioModel usuario);
	

	/**
	 * Update usuario.
	 *
	 * @param usuario the usuario
	 * @return the object
	 */
	Object updateUsuario(UsuarioModel usuario);
	

	/**
	 * Delete usuario.
	 *
	 * @param idUsuario the id usuario
	 * @return the object
	 */
	Object deleteUsuario(int idUsuario);
}
