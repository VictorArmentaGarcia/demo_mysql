package com.demo.mysql.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.demo.mysql.entity.RolEntity;
import com.demo.mysql.entity.UsuarioEntity;
import com.demo.mysql.enums.EnumHttpStatus;
import com.demo.mysql.exception.BusinessException;
import com.demo.mysql.model.RolModel;
import com.demo.mysql.model.UsuarioModel;
import com.demo.mysql.repository.RolRepository;
import com.demo.mysql.repository.UsuarioRepository;
import com.demo.mysql.service.UsuarioService;

/**
 * The Class UsuarioServiceImpl.
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

	/**
	 * Instantiates a new usuario service impl.
	 *
	 * @param userRp the user rp
	 * @param rolRepository the rol repository
	 */
	public UsuarioServiceImpl(UsuarioRepository userRp, RolRepository rolRepository){
		this.userRepo = userRp;
		this.rolRepo = rolRepository;
	}
	
	/** The user repo. */
	private UsuarioRepository userRepo;
	
	/** The rol repo. */
	private RolRepository rolRepo;
	
	/**
	 * Gets the usuario.
	 *
	 * @return the usuario
	 */
	@Override
	public List<UsuarioModel> getUsuario() {
		List<UsuarioEntity> usuarios = userRepo.findAll();
		if(usuarios.isEmpty()) {
			return new ArrayList<UsuarioModel>();
		}
		
		return usuarios
				.stream()
				.map(user -> {
						UsuarioModel userM = new UsuarioModel(user);
						userM.setRol(new RolModel(user.getRolEntity()));
						return userM;
						})
				.toList();
	}

	/**
	 * Gets the usuario.
	 *
	 * @param id the id
	 * @return the usuario
	 */
	@Override
	public UsuarioModel getUsuario(int id) {
		var user = userRepo.findById(id);
		if(user.isPresent()) {
			UsuarioModel userModel = new UsuarioModel(user.get());
			userModel.setRol(new RolModel(user.get().getRolEntity()));
			return userModel;
		}
		
		return null;
	}

	/**
	 * Save usuario.
	 *
	 * @param user the user
	 * @return the usuario model
	 * @throws BusinessException the business exception
	 */
	@Override
	public UsuarioModel saveUsuario(@Validated UsuarioModel user) throws BusinessException {
		Optional<RolEntity> rolEntity = rolRepo.findById(user.getIdRol());
		if(!rolEntity.isPresent()) {
			throw new BusinessException(EnumHttpStatus.CLIENT_ERROR_BAD_REQUEST, "Rol no existente");
		}
		
		try {
			user.setIdUsuario(0);
			UsuarioEntity userEntity = new UsuarioEntity(user);
			userEntity.setRolEntity(rolEntity.get());
			userRepo.save(userEntity);
			user = new UsuarioModel(userEntity);
			user.setRol(new RolModel(rolEntity.get()));
			return user;	
		} catch (Exception e) {
			throw new BusinessException(EnumHttpStatus.CLIENT_ERROR_BAD_REQUEST, "Falla al guardar o mapear datos de modelo o objeto de negocio");

		}
		
	}

	/**
	 * Update usuario.
	 *
	 * @param user the user
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 */
	@Override
	public boolean updateUsuario(UsuarioModel user) throws BusinessException {
		Optional<RolEntity> rolEntity = rolRepo.findById(user.getIdRol());
		if(!rolEntity.isPresent()) {
			return false;
		}
		
		Optional<UsuarioEntity> userEntity = userRepo.findById(user.getIdUsuario());
		if(!userEntity.isPresent()) {
			return false;
		}

		try {
			user.setFecActualizacion(new Date());
			user.setFecCreacion(userEntity.get().getFecCreacion());
			UsuarioEntity usuarioEntity = new UsuarioEntity(user);
			usuarioEntity.setRolEntity(rolEntity.get());
			userRepo.save(usuarioEntity);
			return true;	
		} catch (Exception e) {
			throw new BusinessException(EnumHttpStatus.CLIENT_ERROR_BAD_REQUEST, "Falla al guardar o mapear datos de modelo o objeto de negocio");
		}
	}

	/**
	 * Delete usuario.
	 *
	 * @param idUsuario the id usuario
	 * @return true, if successful
	 */
	@Override
	public boolean deleteUsuario(int idUsuario) {
		Optional<UsuarioEntity> userEntity = userRepo.findById(idUsuario);
		if(!userEntity.isPresent()) {
			return false;
		}
		
		userRepo.delete(userEntity.get());
		return true;
	}

}
