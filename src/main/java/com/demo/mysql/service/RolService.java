package com.demo.mysql.service;

import java.util.List;

import com.demo.mysql.exception.BusinessException;
import com.demo.mysql.model.RolModel;

/**
 * The Interface RolService.
 */
public interface RolService {

	/**
	 * Gets the rol.
	 *
	 * @return the rol
	 */
	List<RolModel> getRol();
	
	/**
	 * Gets the rol.
	 *
	 * @param id the id
	 * @return the rol
	 * @throws BusinessException the business exception
	 */
	RolModel getRol(int id) throws BusinessException;
	
	/**
	 * Save rol.
	 *
	 * @param rol the rol
	 * @return the rol model
	 * @throws BusinessException 
	 */
	RolModel saveRol(RolModel rol) throws BusinessException;
	
	/**
	 * Update rol.
	 *
	 * @param rol the rol
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 */
	boolean updateRol(RolModel rol) throws BusinessException;
	
	/**
	 * Delete rol.
	 *
	 * @param id the id
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 */
	boolean deleteRol(int id) throws BusinessException;
	
}