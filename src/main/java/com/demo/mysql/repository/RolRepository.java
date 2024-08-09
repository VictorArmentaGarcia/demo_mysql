package com.demo.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.mysql.entity.RolEntity;

/**
 * The Interface RolRepository.
 */
@Repository
public interface RolRepository extends JpaRepository<RolEntity, Integer> {

}
