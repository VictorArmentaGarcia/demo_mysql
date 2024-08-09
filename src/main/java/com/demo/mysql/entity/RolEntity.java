package com.demo.mysql.entity;

import java.util.Date;
import java.util.List;

import com.demo.mysql.model.RolModel;
import com.demo.mysql.utils.ObjectUtils;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class RolEntity.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ROL")
public class RolEntity {

	/**
	 * Instantiates a new rol entity.
	 *
	 * @param rolModel the rol model
	 */
	public RolEntity(RolModel rolModel) {
		this.setIdRol(rolModel.getIdRol());
		this.setRol(rolModel.getRol());
		this.setUsuario(rolModel.getUsuario());

		if(!ObjectUtils.validaObject(rolModel.getFecCreacion())) {
			this.setFecCreacion(new Date());
		}else {
			this.setFecCreacion(rolModel.getFecCreacion());
		}
		
		if(!ObjectUtils.validaObject(rolModel.getFecActualizacion())) {
			this.setFecActualizacion(new Date());
		}else {
			this.setFecActualizacion(rolModel.getFecActualizacion());	
		}
		
	}
	
	/** The id rol. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int idRol;
	
	/** The rol. */
	@Column(name = "ROL", nullable = false, length = 30)
	private String rol;
		
	/** The fec creacion. */
	@Column(name = "FECHA_CREACION", nullable = true)
	private Date fecCreacion;
	
	/** The fec actualizacion. */
	@Column(name = "FECHA_ACTUALIZACION", nullable = true)
	private Date fecActualizacion;
	
	/** The usuario. */
	@Column(name = "USUARIO", nullable = true, length = 50)
	private String usuario;
	
    /** The usuarios. */
    @OneToMany(mappedBy = "rolEntity",cascade = CascadeType.REMOVE)
    private List<UsuarioEntity> usuarios;
}
