package com.demo.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.mysql.entity.UsuarioEntity;

/**
 * The Interface UsuarioRepository.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity,  Integer> {

}
