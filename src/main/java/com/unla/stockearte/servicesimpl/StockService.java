package com.unla.stockearte.servicesimpl;

import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.unla.stockearte.CreateStockRequest;
import com.unla.stockearte.EditStockRequest;
import com.unla.stockearte.GetStockRequest;
import com.unla.stockearte.GetStockResponse;
import com.unla.stockearte.GetStocksRequest;
import com.unla.stockearte.GetStocksResponse;
import com.unla.stockearte.StockResponse;
import com.unla.stockearte.StockServiceGrpc.StockServiceImplBase;
import com.unla.stockearte.services.StocksServiceLogic;

import io.grpc.stub.StreamObserver;

@GRpcService
public class StockService extends StockServiceImplBase{
	
	private static final Logger log = LoggerFactory.getLogger(StockService.class);
    @Autowired
    private StocksServiceLogic stockServiceLogic;
    
    @Override
    public void createStock(CreateStockRequest request, StreamObserver<StockResponse> responseObserver) {
    	StockResponse response = stockServiceLogic.saveStock(request.getStoreId(), request.getProductId(), request.getQuantity());
    	log.info("[StockService.createStock] response = {}", response);
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
    
    @Override
    public void editStock(EditStockRequest request, StreamObserver<StockResponse> responseObserver) {
    	StockResponse response = stockServiceLogic.editStock(request.getId(), request.getStoreId(), request.getProductId(), request.getQuantity());
    	log.info("[StockService.editStock] response = {}", response);
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

    @Override
    public void getStock(GetStockRequest request, StreamObserver<GetStockResponse> responseObserver) {
    	GetStockResponse response = stockServiceLogic.getStock(request.getId());
    	log.info("[StockService.getStock] response = {}", response);
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

    @Override
    public void getStocks(GetStocksRequest request, StreamObserver<GetStocksResponse> responseObserver) {
    	GetStocksResponse response = stockServiceLogic.getStocks();
    	log.info("[StockService.getStocks] response = {}", response);
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
}
