package com.demo.mysql.service;

import java.util.List;

import com.demo.mysql.exception.BusinessException;
import com.demo.mysql.model.UsuarioModel;

public interface UsuarioService {

	List<UsuarioModel> getUsuario();
	
	UsuarioModel getUsuario(int id);
	
	UsuarioModel saveUsuario(UsuarioModel user) throws BusinessException;
	
	boolean updateUsuario(UsuarioModel user) throws BusinessException;
	
	boolean deleteUsuario(int idUsuario);
	
}
