package com.unla.stockearte.servicesimpl;

import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.unla.stockearte.CreateProductResponse;
import com.unla.stockearte.DeleteProductRequest;
import com.unla.stockearte.DeleteProductResponse;
import com.unla.stockearte.EditProductResponse;
import com.unla.stockearte.FilterProductRequest;
import com.unla.stockearte.FilterProductResponse;
import com.unla.stockearte.GetDetailProductRequest;
import com.unla.stockearte.GetDetailProductResponse;
import com.unla.stockearte.Product;
import com.unla.stockearte.ProductServiceGrpc.ProductServiceImplBase;
import com.unla.stockearte.services.ProductServiceLogic;

import io.grpc.stub.StreamObserver;

@GRpcService
public class ProductService extends ProductServiceImplBase{
	
	private static final Logger log = LoggerFactory.getLogger(ProductService.class);
    @Autowired
    private ProductServiceLogic productServiceLogic;
    
    @Override
    public void createProduct(Product request, StreamObserver<CreateProductResponse> responseObserver) {
    	CreateProductResponse response = productServiceLogic.saveProduct(request.getNombre(), request.getTalle(), request.getFoto(), request.getColor(), 
				request.getStock(), request.getIdTiendaList());
    	log.info("[ProductService.createProduct] response = {}", response);
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
    
    @Override
    public void editProduct(Product request, StreamObserver<EditProductResponse> responseObserver) {
    	EditProductResponse response = productServiceLogic.editProduct(request.getId(), request.getNombre(), request.getTalle(), request.getFoto(), request.getColor(), 
				request.getStock(), request.getIdTiendaList());
    	log.info("[ProductService.editProduct] response = {}", response);
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
    
    @Override
    public void deleteProduct(DeleteProductRequest request, StreamObserver<DeleteProductResponse> responseObserver) {
    	DeleteProductResponse response = productServiceLogic.deleteProduct(request.getId());
    	log.info("[ProductService.deleteProduct] response = {}", response);
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
    
    @Override
    public void filterProduct(FilterProductRequest request, StreamObserver<FilterProductResponse> responseObserver) {
    	FilterProductResponse response = productServiceLogic.getListByFilterProduct(request.getColor(), request.getNombre(), request.getTalle(), request.getHabilitado());
    	log.info("[ProductService.filterProduct] response = {}", response);
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
    
    @Override
    public void getDetailProduct(GetDetailProductRequest request, StreamObserver<GetDetailProductResponse> responseObserver) {
    	GetDetailProductResponse response = productServiceLogic.getDetailProduct(request.getId());
    	log.info("[ProductService.createStore] response = {}", response);
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

}