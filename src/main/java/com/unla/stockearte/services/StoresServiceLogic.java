package com.unla.stockearte.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.stockearte.GetStoreResponse;
import com.unla.stockearte.GetStoresResponse;
import com.unla.stockearte.StoreResponse;
import com.unla.stockearte.StoreSummary;
import com.unla.stockearte.repository.ProductsRepository;
import com.unla.stockearte.repository.StockRepository;
import com.unla.stockearte.repository.StoresRepository;
import com.unla.stockearte.repository.UsersRepository;
import com.unla.stockearte.repository.entity.ProductModel;
import com.unla.stockearte.repository.entity.StockModel;
import com.unla.stockearte.repository.entity.StoreModel;
import com.unla.stockearte.repository.entity.UserModel;

@Service
public class StoresServiceLogic {

	private static final Logger log = LoggerFactory.getLogger(StoresServiceLogic.class);
    @Autowired
    private StoresRepository repository;
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private UsersServiceLogic usersServiceLogic;
    @Autowired
    private StocksServiceLogic stocksServiceLogic;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private ProductsRepository productRepository;
    
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
            String province, boolean enabled, List<Integer> productsId, List<Integer> usersId) {
		StoreResponse.Builder response = StoreResponse.newBuilder();
		try {
			boolean result = false;
			Optional<StoreModel> storeModel = repository.findById((long) storeId);
			if (storeModel.isPresent()) {
				StoreModel storeModelModified = storeModel.get();
				storeModelModified.setCode(!code.isEmpty() ? code : storeModelModified.getCode());
				storeModelModified.setAddress(!address.isEmpty() ? address : storeModelModified.getAddress());
				storeModelModified.setCity(!city.isEmpty() ? city : storeModelModified.getCity());
				storeModelModified.setProvince(!province.isEmpty() ? province : storeModelModified.getProvince());
				storeModelModified.setProducts(!productsId.isEmpty() ? getProducts(productsId) : storeModelModified.getProducts());
				storeModelModified.setEnabled(storeModelModified.isEnabled() != enabled ? enabled : storeModelModified.isEnabled());
				updateStoreProductsAndStock(storeModelModified, productsId);
				setUsers(usersId, storeId);
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

	private void updateStoreProductsAndStock(StoreModel storeModel, List<Integer> newProductIds) {
		List<StockModel> existingStocks = stockRepository.findByStoreId(storeModel.getId());
		List<Long> existingProductIds = existingStocks.stream()
			.map(stock -> stock.getProduct().getId())
			.collect(Collectors.toList());
		for (Integer productId : newProductIds) {
			if (!existingProductIds.contains(productId.longValue())) {
			ProductModel product = productRepository.findById(productId.longValue()).orElse(null);
				if (product != null) {
				stocksServiceLogic.saveStock((int) storeModel.getId(), productId, 0);
				}
			}
		}
		for (StockModel stock : existingStocks) {
			if (!newProductIds.contains(stock.getProduct().getId().intValue())) {
			stockRepository.delete(stock);
			}
		}
	}

	public List<ProductModel> getProducts(List<Integer> productsId) {
		List<ProductModel> products = new ArrayList<ProductModel>();
		for(int id : productsId) {
			Optional<ProductModel> productModel = productsRepository.findById((long)id);
			if(productModel.isPresent())
				products.add(productModel.get());
		}
		return products; 
	}
	public void setUsers(List<Integer> usersId, int storeId) {
		for(int id : usersId) {
			usersServiceLogic.editUser("CambioInterno", "", "", "", true, storeId, id);
		}
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
			            .setStoreId((int)store.getId())
			            .setCode(store.getCode())
			            .setAddress(store.getAddress())
			            .setCity(store.getCity())
			            .setProvince(store.getProvince())
			            .setEnabled(store.isEnabled())
			            .build();
			    response.addStores(storeSummary);
			}
		} catch (Exception e) {
			log.error("[StoresServiceLogic.getStores] Unexpected error.", e);
		}
		return response.build(); 
	}
	public GetStoreResponse getStore(int storeId) {
		GetStoreResponse.Builder response = GetStoreResponse.newBuilder();
		try {
			Optional<StoreModel> storeModel = repository.findById((long)storeId);
			if(storeModel.isPresent()) {
				StoreModel store = storeModel.get();	
			    StoreSummary.Builder storeSummaryBuilder = StoreSummary.newBuilder()
			            .setStoreId((int)store.getId())
			            .setCode(store.getCode())
			            .setAddress(store.getAddress())
			            .setCity(store.getCity())
			            .setProvince(store.getProvince())
			            .setEnabled(store.isEnabled());
			    for(ProductModel product : store.getProducts()) {
			        storeSummaryBuilder.addProductsId(product.getId().intValue());
			    }
			    List<UserModel> users = usersRepository.findByStore(store);
			    for(UserModel user : users) {
			        storeSummaryBuilder.addUsersId(user.getId().intValue());
			    }
			    StoreSummary storeSummary = storeSummaryBuilder.build();
				response.setStore(storeSummary);
			}
		} catch (Exception e) {
			log.error("[StoresServiceLogic.getStore] Unexpected error.", e);
		}
		return response.build(); 
	}
	
}