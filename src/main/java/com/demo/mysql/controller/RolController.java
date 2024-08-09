package com.demo.mysql.controller;

import com.demo.mysql.exception.BusinessException;
import com.demo.mysql.model.RolModel;

/**
 * The Interface RolController.
 */
public interface RolController {

	/**
	 * Gets the roles.
	 *
	 * @return the roles
	 */
	Object getRoles();
	
	/**
	 * Gets the rol.
	 *
	 * @param id the id
	 * @return the rol
	 * @throws BusinessException the business exception
	 */
	Object getRol(int id) throws BusinessException;
	
	/**
	 * Save rol.
	 *
	 * @param rol the rol
	 * @return the rol model
	 */
	Object saveRol(RolModel rol);
	
	/**
	 * Update rol.
	 *
	 * @param rol the rol
	 * @return the object
	 */
	Object updateRol(RolModel rol);
	
	/**
	 * Delete rol.
	 *
	 * @param idRol the id rol
	 * @return the object
	 */
	Object deleteRol(int idRol);
	
}
