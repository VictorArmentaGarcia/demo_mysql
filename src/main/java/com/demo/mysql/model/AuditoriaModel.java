package com.demo.mysql.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class AuditoriaModel.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditoriaModel {

	/** The fec creacion. */
	private Date fecCreacion;
	
	/** The fec actualizacion. */
	private Date fecActualizacion;
	
	/** The usuario. */
	private String usuario;
}
