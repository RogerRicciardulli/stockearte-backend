package com.unla.stockearte.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.stockearte.GetStoresResponse;
import com.unla.stockearte.StoreResponse;
import com.unla.stockearte.StoreSummary;
import com.unla.stockearte.repository.StoresRepository;
import com.unla.stockearte.repository.entity.StoreModel;

@Service
public class StoresServiceLogic {

	private static final Logger log = LoggerFactory.getLogger(StoresServiceLogic.class);
    @Autowired
    private StoresRepository repository;
    
	public StoreResponse saveStore(String code, String address, String city, 
			String province, boolean enabled) {
		StoreResponse.Builder response = StoreResponse.newBuilder();
		try {
			StoreModel storeModel = new StoreModel(code, address, city, province, enabled);
			repository.save(storeModel);
			response.setSuccess(true);
		} catch (Exception e) {
			log.error("[StoresServiceLogic.saveStore] Unexpected error.", e);
			response.setSuccess(false);
		}
		return response.build();
	}
	public StoreResponse editStore(int storeId, String code, String address, String city, 
			String province, String enabled) {
		StoreResponse.Builder response = StoreResponse.newBuilder();
		try {
			boolean result = false;
			Optional<StoreModel> storeModel = repository.findById((long)storeId);
			if(storeModel.isPresent()) {
				StoreModel storeModelModified = storeModel.get();
				storeModelModified.setCode(!code.isEmpty() ? code : storeModelModified.getCode());
				storeModelModified.setAddress(!address.isEmpty() ? address : storeModelModified.getAddress());
				storeModelModified.setCity(!city.isEmpty() ? city : storeModelModified.getCity());
				storeModelModified.setProvince(!province.isEmpty() ? province : storeModelModified.getProvince());
				storeModelModified.setEnabled(!enabled.isEmpty() ? Boolean.valueOf(enabled) : storeModelModified.isEnabled());
				repository.save(storeModelModified);
				result = true;
			}
			response.setSuccess(result);
		} catch (Exception e) {
			log.error("[StoresServiceLogic.editStore] Unexpected error.", e);
			response.setSuccess(false);
		}
		return response.build(); 
	}
	public GetStoresResponse getStores(String code, String enabled) {
		GetStoresResponse.Builder response = GetStoresResponse.newBuilder();
		try {
			List<StoreModel> stores = new ArrayList<StoreModel>();
			if(!code.isEmpty() && !enabled.isEmpty()) {
				StoreModel store = repository.findByCodeAndEnabled(code, Boolean.valueOf(enabled));
				if(store != null)
					stores.add(store);
			}
			else if(!code.isEmpty()) {
				StoreModel store = repository.findByCode(code);
				if(store != null)
					stores.add(store);
			}
			else if(!enabled.isEmpty()){
				stores = repository.findByEnabled(Boolean.valueOf(enabled));
			} 
			else {
				stores = repository.findAll();
			}
			for(StoreModel store : stores) {
			    StoreSummary storeSummary = StoreSummary.newBuilder()
			            .setCode(store.getCode())
			            .setEnabled(store.isEnabled())
			            .build();
			    response.addStores(storeSummary);
			}
		} catch (Exception e) {
			log.error("[StoresServiceLogic.getStores] Unexpected error.", e);
		}
		return response.build(); 
	}
	
}