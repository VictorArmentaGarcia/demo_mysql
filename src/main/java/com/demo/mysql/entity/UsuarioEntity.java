package com.demo.mysql.entity;

import java.util.Date;

import com.demo.mysql.enums.EnumHttpStatus;
import com.demo.mysql.exception.BusinessException;
import com.demo.mysql.model.UsuarioModel;
import com.demo.mysql.utils.Constantes;
import com.demo.mysql.utils.DateUtils;
import com.demo.mysql.utils.ObjectUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class UsuarioEntity.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USUARIO")
public class UsuarioEntity {

	/**
	 * Instantiates a new usuario entity.
	 *
	 * @param userModel the user model
	 * @throws Exception 
	 */
	public UsuarioEntity(UsuarioModel userModel) throws Exception {
		this.setIdUsuario(userModel.getIdUsuario());
		this.setCorreo(userModel.getCorreo());
		this.setNombre(userModel.getNombre());
		this.setApellidoPaterno(userModel.getApellidoPaterno());
		try {
			this.setFecNacimiento(DateUtils.parserFromString(userModel.getFecNacimiento(), Constantes.PATTERN_DDMMYYYY_MS));
		} catch (BusinessException e) {
			throw new BusinessException(EnumHttpStatus.CLIENT_ERROR_BAD_REQUEST, "Inconveniente al convertir fecha");
		}
		this.setUsuario(userModel.getUsuario());
		
		if(!ObjectUtils.validaObject(userModel.getFecCreacion())) {
			this.setFecCreacion(new Date());
		}else {
			this.setFecCreacion(userModel.getFecCreacion());
		}
		
		if(!ObjectUtils.validaObject(userModel.getFecActualizacion())) {
			this.setFecActualizacion(new Date());
		}else {
			this.setFecActualizacion(userModel.getFecActualizacion());	
		}
	}
	
	/** The id usuario. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int idUsuario;
	
	/** The correo. */
	@Column(name = "CORREO", nullable = false, length = 50)
	private String correo;
	
	/** The nombre. */
	@Column(name = "NOMBRE", nullable = false, length = 50)
	private String nombre;
	
	/** The apellido paterno. */
	@Column(name = "APELIIDO_PATERNO", nullable = false, length = 50)
	private String apellidoPaterno;
	
	/** The fec nacimiento. */
	@Column(name = "FECHA_NACIMIENTO", nullable = false)
	private Date fecNacimiento;
	
	/** The fec creacion. */
	@Column(name = "FECHA_CREACION", nullable = true)
	private Date fecCreacion;
	
	/** The fec actualizacion. */
	@Column(name = "FECHA_ACTUALIZACION", nullable = true)
	private Date fecActualizacion;
	
	/** The usuario. */
	@Column(name = "USUARIO", nullable = true, length = 50)
	private String usuario;
	
    /** The rol entity. */
    @ManyToOne
    @JoinColumn(name = "id_rol")
    private RolEntity rolEntity;
}
