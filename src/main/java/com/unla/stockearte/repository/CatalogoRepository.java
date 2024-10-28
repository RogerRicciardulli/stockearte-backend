package com.unla.stockearte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.stockearte.repository.entity.CatalogoModel;

public interface CatalogoRepository extends JpaRepository<CatalogoModel, Long> {

}
