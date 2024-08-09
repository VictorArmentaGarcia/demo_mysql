package com.demo.mysql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class RespGral.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespGral {

	/** The respuesta. */
	private boolean respuesta;
	
	/** The descripcion. */
	private String descripcion;
	
	/** The objeto. */
	private Object objeto;
	
}
