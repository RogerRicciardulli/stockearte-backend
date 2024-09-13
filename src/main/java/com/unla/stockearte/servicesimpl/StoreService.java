package com.unla.stockearte.servicesimpl;

import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.unla.stockearte.CreateStoreRequest;
import com.unla.stockearte.EditStoreRequest;
import com.unla.stockearte.GetStoresRequest;
import com.unla.stockearte.GetStoresResponse;
import com.unla.stockearte.StoreResponse;
import com.unla.stockearte.StoreServiceGrpc.StoreServiceImplBase;
import com.unla.stockearte.services.StoresServiceLogic;

import io.grpc.stub.StreamObserver;

@GRpcService
public class StoreService extends StoreServiceImplBase {
	
    private static final Logger log = LoggerFactory.getLogger(StoreService.class);
    @Autowired
    private StoresServiceLogic storesServiceLogic;
    
	@Override
	public void createStore(CreateStoreRequest request, StreamObserver<StoreResponse> responseObserver) {
    	log.info("[UserService.createStore] code = {}, address = {}, city = {}, province = {},"
    			+ "enabled = {}", request.getCode(), request.getAddress(), request.getCity(), 
				request.getProvince(), request.getEnabled());
    	StoreResponse response = storesServiceLogic.saveStore(request.getCode(), request.getAddress(), request.getCity(), 
				request.getProvince(), request.getEnabled());
    	log.info("[StoreService.createStore] response = {}", response);
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
	@Override
	public void editStore(EditStoreRequest request, StreamObserver<StoreResponse> responseObserver) {
    	log.info("[StoreService.editStore] storeId = {}, code = {}, address = {}, city = {}, province = {},"
    			+ "enabled = {}", request.getStoreId(), request.getCode(), request.getAddress(), request.getCity(), 
				request.getProvince(), request.getEnabled());
    	StoreResponse response = storesServiceLogic.editStore(request.getStoreId(), request.getCode(), request.getAddress(), 
    			request.getCity(), request.getProvince(), request.getEnabled());
    	log.info("[StoreService.editStore] response = {}", response);
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
	@Override
	public void getStores(GetStoresRequest request, StreamObserver<GetStoresResponse> responseObserver) {
    	log.info("[StoreService.getStores] code = {}, enabled = {}", request.getCode(), request.getEnabled());
    	GetStoresResponse response = storesServiceLogic.getStores(request.getCode(), request.getEnabled());
    	log.info("[StoreService.getStores] response = {}", response);
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
}