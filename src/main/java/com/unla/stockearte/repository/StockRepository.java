package com.unla.stockearte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.stockearte.repository.entity.StockModel;

public interface StockRepository extends JpaRepository<StockModel, Long> {

	List<StockModel> findByProductId(Long productId);

	List<StockModel> findByStoreId(Long storeId);
	
	StockModel findByProductIdAndStoreId(Long productId, Long storeId);

}