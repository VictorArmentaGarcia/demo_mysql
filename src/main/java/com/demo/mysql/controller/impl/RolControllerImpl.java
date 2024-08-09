package com.demo.mysql.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.mysql.controller.RolController;
import com.demo.mysql.exception.BusinessException;
import com.demo.mysql.model.RolModel;
import com.demo.mysql.service.RolService;

/**
 * The Class RolControllerImpl.
 */
@RestController
@RequestMapping("/msrol/v1")
@CrossOrigin(origins = "*", allowedHeaders="*")
public class RolControllerImpl implements RolController {

	/**
	 * Instantiates a new rol controller impl.
	 *
	 * @param rolServ the rol serv
	 */
	public RolControllerImpl(RolService rolServ) {
		this.rolService = rolServ;
	}
	
	/** The rol service. */
	private RolService rolService;

	/**
	 * Gets the roles.
	 *
	 * @return the roles
	 */
	@Override
	@GetMapping(value = "/rol", produces = { "application/json" })
	public Object getRoles() {
		return rolService.getRol();
	}

	/**
	 * Gets the rol.
	 *
	 * @param id the id
	 * @return the rol
	 */
	@Override
	@GetMapping(value = "/rol/{id}", produces = { "application/json" })
	public Object getRol(@PathVariable int id) {
		try {
			return rolService.getRol(id);
		} catch (BusinessException be) {
			return getBusines(be);
		}
	}

	/**
	 * Save rol.
	 *
	 * @param rol the rol
	 * @return the rol model
	 */
	@Override
	@PostMapping(value = "/rol" ,produces = { "application/json" } )
	public Object saveRol(@RequestBody RolModel rol) {
		try {
			return rolService.saveRol(rol);	
		} catch (BusinessException be) {
			return getBusines(be);
		}
	}

	/**
	 * Update rol.
	 *
	 * @param rol the rol
	 * @return the object
	 */
	@Override
	@PostMapping(value = "/rol/update" ,produces = { "application/json" } )
	public Object updateRol(@RequestBody RolModel rol) {
		try {
			return rolService.updateRol(rol);
		} catch (BusinessException be) {
			return getBusines(be);
		}
	}

	/**
	 * Delete rol.
	 *
	 * @param idRol the id rol
	 * @return the object
	 */
	@Override
	@DeleteMapping(value = "/rol/{idRol}", produces = { "application/json" })
	public Object deleteRol(@PathVariable int idRol) {
		try {
			return rolService.deleteRol(idRol);
		} catch (BusinessException be) {
			return getBusines(be);
		}
	}

	private Object getBusines(BusinessException be) {
		int numberHTTPDesired = Integer.parseInt(be.getErrorResponse().getCode());
		return new ResponseEntity<>(be.getErrorResponse(), HttpStatus.valueOf(numberHTTPDesired));
	}
	
}
