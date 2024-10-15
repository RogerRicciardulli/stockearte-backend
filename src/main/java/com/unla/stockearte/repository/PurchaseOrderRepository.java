package com.unla.stockearte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.stockearte.repository.entity.PurchaseOrderModel;


public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrderModel, Long>{

}
