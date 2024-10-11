package com.unla.stockearte.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.stockearte.GetStockResponse;
import com.unla.stockearte.GetStocksResponse;
import com.unla.stockearte.StockResponse;
import com.unla.stockearte.StockSummary;
import com.unla.stockearte.repository.ProductsRepository;
import com.unla.stockearte.repository.StockRepository;
import com.unla.stockearte.repository.StoresRepository;
import com.unla.stockearte.repository.entity.ProductModel;
import com.unla.stockearte.repository.entity.StockModel;
import com.unla.stockearte.repository.entity.StoreModel;

@Service
public class StocksServiceLogic {

	private static final Logger log = LoggerFactory.getLogger(StocksServiceLogic.class);
    @Autowired
    private StockRepository repository;
    @Autowired
    private StoresRepository storesRepository;
    @Autowired
    private ProductsRepository productsRepository;
    
	public StockResponse saveStock(int storeId, int productId, int quantity) {
		StockResponse.Builder response = StockResponse.newBuilder();
		try {
			Optional<StoreModel> storeModel = storesRepository.findById((long)storeId);
			Optional<ProductModel> productModel = productsRepository.findById((long)productId);
			if(storeModel.isPresent() && productModel.isPresent()) {
				StockModel stockModel = new StockModel(storeModel.get(), productModel.get(), quantity);
				repository.save(stockModel);
				response.setSuccess(true);
			} else {
				response.setSuccess(false);
			}
		} catch (Exception e) {
			log.error("[StocksServiceLogic.saveStock] Unexpected error.", e);
			response.setSuccess(false);
		}
		return response.build();
	}
	public StockResponse editStock(int id, int storeId, int productId, int quantity) {
		StockResponse.Builder response = StockResponse.newBuilder();
		try {
			Optional<StockModel> stockModel = repository.findById((long)id);
			Optional<StoreModel> storeModel = storesRepository.findById((long)storeId);
			Optional<ProductModel> productModel = productsRepository.findById((long)productId);
			if(stockModel.isPresent() && storeModel.isPresent() && productModel.isPresent()) {
				StockModel stockModelModified = stockModel.get();
				stockModelModified.setStore(storeModel.get());
				stockModelModified.setProduct(productModel.get());
				stockModelModified.setQuantity(quantity);
				repository.save(stockModelModified);
				response.setSuccess(true);
			} else {
				response.setSuccess(false);
			}
		} catch (Exception e) {
			log.error("[StoresServiceLogic.editStock] Unexpected error.", e);
			response.setSuccess(false);
		}
		return response.build(); 
	}
	public GetStocksResponse getStocks() {
		GetStocksResponse.Builder response = GetStocksResponse.newBuilder();
		try {
			List<StockModel> stocks = repository.findAll();
			for(StockModel stock : stocks) {
			    StockSummary stockSummary = StockSummary.newBuilder()
			            .setId(stock.getId().intValue())
			            .setStoreId((int)stock.getStore().getId())
			            .setProductId(stock.getProduct().getId().intValue())
			            .setQuantity(stock.getQuantity())
			            .build();
			    response.addStocks(stockSummary);
			}
		} catch (Exception e) {
			log.error("[StocksServiceLogic.getStocks] Unexpected error.", e);
		}
		return response.build(); 
	}
	public GetStockResponse getStock(int id) {
		GetStockResponse.Builder response = GetStockResponse.newBuilder();
		try {
			Optional<StockModel> stockModel = repository.findById((long)id);
			if(stockModel.isPresent()) {
				StockModel stock = stockModel.get();
			    StockSummary stockSummary = StockSummary.newBuilder()
			            .setId(stock.getId().intValue())
			            .setStoreId((int)stock.getStore().getId())
			            .setProductId(stock.getProduct().getId().intValue())
			            .setQuantity(stock.getQuantity())
			            .build();
				response.setStock(stockSummary);
			}
		} catch (Exception e) {
			log.error("[StocksServiceLogic.getStock] Unexpected error.", e);
		}
		return response.build(); 
	}
	
}