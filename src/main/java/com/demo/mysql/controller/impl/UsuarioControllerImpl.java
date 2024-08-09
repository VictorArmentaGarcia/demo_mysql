package com.demo.mysql.controller.impl;

import java.util.List;

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

import com.demo.mysql.controller.UsuarioController;
import com.demo.mysql.exception.BusinessException;
import com.demo.mysql.model.UsuarioModel;
import com.demo.mysql.service.UsuarioService;

/**
 * The Class UsuarioControllerImpl.
 */
@RestController
@RequestMapping("/msusuario/v1")
@CrossOrigin(origins = "*", allowedHeaders="*")
public class UsuarioControllerImpl implements UsuarioController {

	/**
	 * Instantiates a new usuario controller impl.
	 *
	 * @param usuarioService the usuario service
	 */
	public UsuarioControllerImpl(UsuarioService usuarioService) {
		userService = usuarioService;
	}
	
	/** The user service. */
	private UsuarioService userService;

	/**
	 * Gets the usuarios.
	 *
	 * @return the usuarios
	 */
	@Override
	@GetMapping(value = "/usuario", produces = { "application/json" })
	public List<UsuarioModel> getUsuarios() {
		return userService.getUsuario();
	}

	/**
	 * Gets the usuario.
	 *
	 * @param idUsuario the id usuario
	 * @return the usuario
	 */
	@Override
	@GetMapping(value = "/usuario/{idUsuario}", produces = { "application/json" })
	public Object getUsuario(@PathVariable int idUsuario) {
		return userService.getUsuario(idUsuario);
	}

	/**
	 * Save usuario.
	 *
	 * @param usuario the usuario
	 * @return the usuario model
	 */
	@Override
	@PostMapping(value = "/usuario", produces = { "application/json" })
	public Object saveUsuario(@RequestBody UsuarioModel usuario) {
		try {
			return userService.saveUsuario(usuario);	
		} catch (BusinessException be) {
			return getBusines(be);
		}
	}

	/**
	 * Update usuario.
	 *
	 * @param usuario the usuario
	 * @return the object
	 */
	@Override
	@PostMapping(value = "/usuario/update", produces = { "application/json" })
	public Object updateUsuario(@RequestBody UsuarioModel usuario) {
		try {
			return userService.updateUsuario(usuario);	
		} catch (BusinessException be) {
			return getBusines(be);
		}
	}

	/**
	 * Delete usuario.
	 *
	 * @param idUsuario the id usuario
	 * @return the object
	 */
	@Override
	@DeleteMapping(value = "/usuario/{idUsuario}", produces = { "application/json" })
	public Object deleteUsuario(@PathVariable int idUsuario) {
		return userService.deleteUsuario(idUsuario);
	}
	
	private Object getBusines(BusinessException be) {
		int numberHTTPDesired = Integer.parseInt(be.getErrorResponse().getCode());
		return new ResponseEntity<>(be.getErrorResponse(), HttpStatus.valueOf(numberHTTPDesired));
	}

}
