package com.unla.stockearte.servicesimpl;

import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.unla.stockearte.CreatePurchaseOrderResponse;
import com.unla.stockearte.DeletePurchaseOrderRequest;
import com.unla.stockearte.DeletePurchaseOrderResponse;
import com.unla.stockearte.EditPurchaseOrderResponse;
import com.unla.stockearte.GetPurchaseOrderByIdRequest;
import com.unla.stockearte.GetPurchaseOrderByIdResponse;
import com.unla.stockearte.PurchaseOrder;
import com.unla.stockearte.PurchaseOrderServiceGrpc.PurchaseOrderServiceImplBase;
import com.unla.stockearte.services.PurchaseOrderServiceLogic;

import io.grpc.stub.StreamObserver;

@GRpcService
public class PurchaseOrderService extends PurchaseOrderServiceImplBase{
	
	private static final Logger log = LoggerFactory.getLogger(PurchaseOrderService.class);
    @Autowired
    private PurchaseOrderServiceLogic purchaseOrderServiceLogic;
    
    @Override
    public void createPurchaseOrder(PurchaseOrder request, StreamObserver<CreatePurchaseOrderResponse> responseObserver) {
    	CreatePurchaseOrderResponse response = purchaseOrderServiceLogic.savePurchaseOrder(request.getIdTienda(), request.getOrdersList(), request.getObservaciones(), request.getOrdenDespacho());
    	log.info("[PurchaseOrderService.createPurchaseOrder] response = {}", response);
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
    
    @Override
    public void editPurchaseOrder(PurchaseOrder request, StreamObserver<EditPurchaseOrderResponse> responseObserver) {
    	EditPurchaseOrderResponse response = purchaseOrderServiceLogic.editPurchaseOrder(request.getIdTienda(), request.getId(), request.getEstado(), request.getFechaRecepcion(), request.getObservaciones(), request.getOrdenDespacho());
    	log.info("[PurchaseOrderService.editPurchaseOrder] response = {}", response);
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
    
    @Override
    public void deletePurchaseOrder(DeletePurchaseOrderRequest request, StreamObserver<DeletePurchaseOrderResponse> responseObserver) {
    	DeletePurchaseOrderResponse response = purchaseOrderServiceLogic.deletePurchaseOrder(request.getId());
    	log.info("[PurchaseOrderService.deletePurchaseOrder] response = {}", response);
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
    
    @Override
    public void listPurchaseOrdersById(GetPurchaseOrderByIdRequest request, StreamObserver<GetPurchaseOrderByIdResponse> responseObserver) {
    	GetPurchaseOrderByIdResponse response = purchaseOrderServiceLogic.getById(request.getId());
    	log.info("[PurchaseOrderService.listPurchaseOrdersById] response = {}", response);
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

}