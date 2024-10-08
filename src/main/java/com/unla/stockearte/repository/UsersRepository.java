package com.unla.stockearte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.stockearte.repository.entity.StoreModel;
import com.unla.stockearte.repository.entity.UserModel;

public interface UsersRepository extends JpaRepository<UserModel, Long> {

	UserModel findByUsername(String username);

	List<UserModel> findByStore(StoreModel store);
	
	List<UserModel> findByStoreId(long storeId);
	
	UserModel findByUsernameAndStore(String username, StoreModel store);

}