package com.unla.stockearte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.stockearte.repository.entity.StoreModel;

public interface StoresRepository extends JpaRepository<StoreModel, Long> {

	StoreModel findByCode(String code);
	
	List<StoreModel> findByEnabled(boolean enabled);

	StoreModel findByCodeAndEnabled(String code, boolean enabled);

}