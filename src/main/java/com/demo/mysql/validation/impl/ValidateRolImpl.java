package com.demo.mysql.validation.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.demo.mysql.enums.EnumHttpStatus;
import com.demo.mysql.exception.BusinessException;
import com.demo.mysql.model.RolModel;
import com.demo.mysql.validation.ValidateRol;

@Component
public class ValidateRolImpl implements ValidateRol {
	
	@Override
	public void ValidaRolSave(final RolModel rol) throws BusinessException {
		if(rol == null) {
			throw new BusinessException(EnumHttpStatus.CLIENT_ERROR_BAD_REQUEST, "Campo solo de letras mayusculas");
		}
		
		Pattern validaLetra = Pattern.compile("[A-Z].*");
		Matcher rolMatch=validaLetra.matcher(rol.getRol());
		if(!rolMatch.matches()) {
			throw new BusinessException(EnumHttpStatus.CLIENT_ERROR_BAD_REQUEST, "Campo solo de letras mayusculas");
		}
		
	}
	
	
}
