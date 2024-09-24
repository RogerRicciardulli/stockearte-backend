package com.unla.stockearte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.stockearte.repository.entity.ProductModel;

public interface ProductsRepository extends JpaRepository<ProductModel, Long> {

	ProductModel findByCode(String code);

	List<ProductModel> findByName(String name);

	List<ProductModel> findByTalle(String size);
	
	List<ProductModel> findByColor(String color);
	
}