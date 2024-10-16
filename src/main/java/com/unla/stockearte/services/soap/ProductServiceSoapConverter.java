package com.unla.stockearte.services.soap;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.stockearte.repository.PurchaseOrderRepository;
import com.unla.stockearte.repository.entity.OrderDetailsModel;
import com.unla.stockearte.repository.entity.PurchaseOrderModel;
import com.unla.stockearte.soap.GetPurchaseOrdersRequest;
import com.unla.stockearte.soap.GetPurchaseOrdersResponse;
import com.unla.stockearte.soap.OrderDetail;
import com.unla.stockearte.soap.PurchaseOrder;

@Service
public class ProductServiceSoapConverter {
	
	private static final Logger log = LoggerFactory.getLogger(ProductServiceSoapConverter.class);
	@Autowired
	private PurchaseOrderRepository purchaseRepository;
	
    public GetPurchaseOrdersResponse getProductOrders(GetPurchaseOrdersRequest request) {
        GetPurchaseOrdersResponse response = new GetPurchaseOrdersResponse();
		try {
			if(request.getId() == 0) {
				response = purchaseOrderToPurchaseOrderModel(purchaseRepository.findAll());
			} else {
		        List<PurchaseOrderModel> orders = purchaseRepository.findAll();
		        List<PurchaseOrderModel> filteredOrders = new ArrayList<>();
		        for (PurchaseOrderModel order : orders) {
		            boolean matches = true;
		            if (!request.getCodigoProducto().isEmpty()) {
		                matches &= order.getOrderDetails().stream()
		                        .anyMatch(detail -> detail.getCodigo().equals(request.getCodigoProducto()));
		            }
		            if (request.getFechaDesde() != null && order.getRequest() != null) {
		                matches &= order.getRequest().isAfter(request.getFechaDesde().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
		            }
		            if (request.getFechaHasta() != null && order.getRequest() != null) {
		                matches &= order.getRequest().isBefore(request.getFechaHasta().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
		            }
		            if (!request.getEstado().isEmpty()) {
		                matches &= order.getState().equals(request.getEstado());
		            }
		            if (request.getTienda() != 0) {
		                matches &= order.getIdTienda().equals(request.getTienda().longValue());
		            }
		            if (matches && !filteredOrders.contains(order)) {
		                filteredOrders.add(order);
		            }
		        }
		        response = purchaseOrderToPurchaseOrderModel(filteredOrders);
			}
		} catch (Exception e) {
			log.error("[ProductServiceSoapConverter.getProductOrders] Unexpected error.", e);
		}
		return response;
    }
    private GetPurchaseOrdersResponse purchaseOrderToPurchaseOrderModel(List<PurchaseOrderModel> listToCast) {
    	GetPurchaseOrdersResponse response = new GetPurchaseOrdersResponse();
		List<PurchaseOrder> list = new ArrayList<PurchaseOrder>();
		try {
			for(PurchaseOrderModel currentPurchase : listToCast) {
				List<OrderDetail> listOrderDetail = new ArrayList<>();
				List<OrderDetailsModel> orders = currentPurchase.getOrderDetails();
				for(OrderDetailsModel order : orders) {
					OrderDetail newOrderDetail = new OrderDetail();
					newOrderDetail.setCodigo(order.getCodigo());
					newOrderDetail.setTalle(order.getTalle());
					newOrderDetail.setCantidad(order.getCantidad());
					newOrderDetail.setColor(order.getColor());
					listOrderDetail.add(newOrderDetail);
				}
				PurchaseOrder newPurchase = new PurchaseOrder();
				newPurchase.setEstado(currentPurchase.getState());
				newPurchase.setId(currentPurchase.getId().intValue());
				newPurchase.setIdTienda(currentPurchase.getIdTienda().intValue());
				newPurchase.setObservaciones(currentPurchase.getObservations());
				newPurchase.setOrdenDespacho(currentPurchase.getOrderDispatch());
				newPurchase.setOrders(listOrderDetail);
				if (currentPurchase.getRequest() != null) {
					newPurchase.setFechaSolicitud(convertToXMLGregorianCalendar(currentPurchase.getRequest()));
				}
				if (currentPurchase.getReception() != null) {
					newPurchase.setFechaRecepcion(convertToXMLGregorianCalendar(currentPurchase.getReception()));
				}
				list.add(newPurchase);
			}
			response.setPurchaseOrders(list);
		} catch (Exception e) {
			log.error("[ProductServiceSoapConverter.purchaseOrderToPurchaseOrderModel] Unexpected error.", e);
		}
		return response;
    }
	public XMLGregorianCalendar convertToXMLGregorianCalendar(LocalDateTime timestamp) {
        GregorianCalendar gregorianCalendar = GregorianCalendar.from(timestamp.atZone(ZoneId.systemDefault()));
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
}
