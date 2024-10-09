package com.unla.stockearte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.stockearte.repository.entity.ProductModel;

public interface ProductsRepository extends JpaRepository<ProductModel, Long> {

	ProductModel findByCode(String code);

	List<ProductModel> findByNameAndIsHabilitado(String name, boolean isHabilitado);

	List<ProductModel> findByTalleAndIsHabilitado(String size, boolean isHabilitado);
	
	List<ProductModel> findByColorAndIsHabilitado(String color, boolean isHabilitado);
	
	List<ProductModel> findByIsHabilitado(boolean isHabilitado);
	
}