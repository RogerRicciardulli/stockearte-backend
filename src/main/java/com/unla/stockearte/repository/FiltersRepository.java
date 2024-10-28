package com.unla.stockearte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.stockearte.repository.entity.FiltersModel;


public interface FiltersRepository extends JpaRepository<FiltersModel, Long>{
	
	List<FiltersModel> findByHabilitadoTrue();

}
