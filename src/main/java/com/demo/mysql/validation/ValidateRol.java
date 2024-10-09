package com.demo.mysql.validation;

import com.demo.mysql.exception.BusinessException;
import com.demo.mysql.model.RolModel;

public interface ValidateRol {

	void ValidaRolSave(final RolModel rol) throws BusinessException;
	

}
