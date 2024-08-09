package com.demo.mysql.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.mysql.entity.RolEntity;
import com.demo.mysql.entity.UsuarioEntity;
import com.demo.mysql.enums.EnumHttpStatus;
import com.demo.mysql.exception.BusinessException;
import com.demo.mysql.model.RolModel;
import com.demo.mysql.model.UsuarioModel;
import com.demo.mysql.repository.RolRepository;
import com.demo.mysql.service.RolService;

@Service
public class RolServiceImpl implements RolService {

	public RolServiceImpl(RolRepository rolRepo) {
		this.rolRepository = rolRepo;
	}
	
	private RolRepository rolRepository;
	
	@Override
	public List<RolModel> getRol() {
		List<RolEntity> rolEntity = rolRepository.findAll();
		if(rolEntity.isEmpty()) {
			return new ArrayList<RolModel>();
		}

		return rolEntity.stream().map(r->{
			RolModel rolModel = new RolModel(r);
			List<UsuarioModel> lUser = 
					r.getUsuarios()
					.stream()
					.map(user-> 
						{ return getUsuarioModel(user); })
					.toList();
			rolModel.setUsuarios(lUser);
			return rolModel;
		}).toList();
	}
	
	private UsuarioModel getUsuarioModel(UsuarioEntity user) {
		return new UsuarioModel(user);
	}

	@Override
	public RolModel getRol(int id) throws BusinessException {
		Optional<RolEntity> rolEntity = rolRepository.findById(id);
		if(rolEntity.isPresent()) {
			List<UsuarioModel> lUser = 
					rolEntity
					.get()
					.getUsuarios()
					.stream()
					.map(user-> 
						{ return getUsuarioModel(user); })
					.toList();
			RolModel rolModel = new RolModel(rolEntity.get());
			rolModel.setUsuarios(lUser);
			return rolModel;
		}
		
		throw new BusinessException(EnumHttpStatus.CLIENT_ERROR_BAD_REQUEST, "Rol no existente");
	}

	@Override
	public RolModel saveRol(RolModel rol) throws BusinessException {
		try {
			rol.setIdRol(0);
			RolEntity rolEntity = new RolEntity(rol);
			rolRepository.save(rolEntity);
			return new RolModel(rolEntity);	
		} catch (Exception e) {
			throw new BusinessException(EnumHttpStatus.CLIENT_ERROR_BAD_REQUEST, "Inconveniente al guardar rol");
		}
	}

	@Override
	public boolean updateRol(RolModel rol) throws BusinessException {
		Optional<RolEntity> rolEntity = rolRepository.findById(rol.getIdRol());
		if(rolEntity.isPresent()) {
			rol.setFecActualizacion(new Date());
			rol.setFecCreacion(rolEntity.get().getFecCreacion());
			RolEntity rolActEntity = new RolEntity(rol);
			rolRepository.save(rolActEntity);
			
			return true;
		}
		
		throw new BusinessException(EnumHttpStatus.CLIENT_ERROR_BAD_REQUEST, "Rol no existente");
	}

	@Override
	public boolean deleteRol(int id) throws BusinessException {
		Optional<RolEntity> rolEntity = rolRepository.findById(id);
		if(rolEntity.isPresent()) {
			rolRepository.delete(rolEntity.get());
			return true;
		}
		
		throw new BusinessException(EnumHttpStatus.CLIENT_ERROR_BAD_REQUEST, "Rol no existente");
	}

}
