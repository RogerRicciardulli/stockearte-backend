package com.unla.stockearte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.stockearte.repository.entity.OrderDetailsModel;

public interface OrderDetailsRepository extends JpaRepository<OrderDetailsModel, Long>{
	
	//List<OrderDetails> findAll();

}
