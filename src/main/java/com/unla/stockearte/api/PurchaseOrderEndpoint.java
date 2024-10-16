package com.unla.stockearte.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.unla.stockearte.services.soap.ProductServiceSoapConverter;
import com.unla.stockearte.soap.GetPurchaseOrdersRequest;
import com.unla.stockearte.soap.GetPurchaseOrdersResponse;

@Endpoint
public class PurchaseOrderEndpoint {
	
	private static final Logger log = LoggerFactory.getLogger(PurchaseOrderEndpoint.class);
	@Autowired
	private ProductServiceSoapConverter productServiceSoapConverter;

    private static final String NAMESPACE_URI = "http://stockearte-backend.com/";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetPurchaseOrdersRequest")
    @ResponsePayload
    public GetPurchaseOrdersResponse getPurchaseOrders(@RequestPayload GetPurchaseOrdersRequest request) {
    	log.info("[PurchaseOrderEndpoint.getPurchaseOrders] id = {}, codigoDeProducto = {}, estado = {}, "
    			+ "fechaDesde = {}, FechaHasta = {}, Tienda = {} ", 
    			request.getId(), request.getCodigoProducto(), request.getEstado(), 
    			request.getFechaDesde(), request.getFechaHasta(), request.getTienda());
        GetPurchaseOrdersResponse response = productServiceSoapConverter.getProductOrders(request);
    	log.info("[PurchaseOrderEndpoint.getPurchaseOrders] response = {}", response);
        return response;
    }
}
