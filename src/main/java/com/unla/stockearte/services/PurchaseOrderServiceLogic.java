package com.unla.stockearte.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.protobuf.Timestamp;
import com.unla.stockearte.CreatePurchaseOrderResponse;
import com.unla.stockearte.DeletePurchaseOrderResponse;
import com.unla.stockearte.EditPurchaseOrderResponse;
import com.unla.stockearte.GetPurchaseOrderByIdResponse;
import com.unla.stockearte.OrderDetail;
import com.unla.stockearte.PurchaseOrder;
import com.unla.stockearte.kafka.KafkaListenerService;
import com.unla.stockearte.kafka.KafkaProducerService;
import com.unla.stockearte.kafka.KafkaTopicService;
import com.unla.stockearte.repository.entity.DispatchOrder;
import com.unla.stockearte.repository.entity.OrderDetailsModel;
import com.unla.stockearte.repository.OrderDetailsRepository;
import com.unla.stockearte.repository.PurchaseOrderRepository;
import com.unla.stockearte.repository.entity.PurchaseOrderModel;
import com.unla.stockearte.repository.entity.StoreModel;
import com.unla.stockearte.repository.entity.UserModel;
import com.unla.stockearte.repository.model.PurchaseOrderKafka;

@Service
public class PurchaseOrderServiceLogic {

	private static final Logger log = LoggerFactory.getLogger(PurchaseOrderServiceLogic.class);
	
	@Autowired
	KafkaProducerService kafkaService;
	
	@Autowired
	KafkaTopicService kafkaTopicService;
	
	@Autowired
	KafkaListenerService kafkaListenerService;

	@Autowired
	private PurchaseOrderRepository purchaseRepository;

	@Autowired
	private OrderDetailsRepository orderRepository;

	public CreatePurchaseOrderResponse savePurchaseOrder(long idTienda, List<OrderDetail> orders, String observaciones, String ordenDespacho) {
		List<OrderDetailsModel> detailsList = new ArrayList<OrderDetailsModel>();
		for (OrderDetail detail : orders) {
			OrderDetailsModel detailModel = new OrderDetailsModel();
			detailModel.setCantidad(detail.getCantidad());
			detailModel.setCodigo(detail.getCodigo());
			detailModel.setColor(detail.getColor());
			detailModel.setTalle(detail.getTalle());
			detailsList.add(detailModel);
			orderRepository.save(detailModel);
		}
		PurchaseOrderModel purchaseOrder = new PurchaseOrderModel();
		purchaseOrder.setIdTienda(idTienda);
		purchaseOrder.setOrderDetails(detailsList);
		purchaseOrder.setState("SOLICITADA");
		purchaseOrder.setRequest(LocalDateTime.now());
		purchaseOrder.setObservations(observaciones);
		purchaseOrder.setOrderDispatch(ordenDespacho);
		purchaseOrder.setHabilitado(true);
		
		PurchaseOrderModel model = purchaseRepository.save(purchaseOrder);
		
		PurchaseOrderKafka order = new PurchaseOrderKafka();
		order.setFechaSolicitud(purchaseOrder.getRequest());
		order.setIdOrden(model.getId());
		order.setIdTienda(idTienda);
		order.setList(detailsList);
		kafkaService.sendPurchaseOrder(order);
		String nameTopic = Long.toString(idTienda) +"_solicitudes";
		String nameTopicDispatch = Long.toString(idTienda) +"-despacho";
		
		kafkaTopicService.createTopic(nameTopic, 1, 1);
		
		
		kafkaListenerService.iniciarConsumo(nameTopicDispatch);
		
		//updateStateOrderByDispatch();

		CreatePurchaseOrderResponse.Builder response = CreatePurchaseOrderResponse.newBuilder();
		response.setSuccess(true);
		return response.build();
	}
	
	public EditPurchaseOrderResponse editPurchaseOrder(int idTienda, long idOrdenDeCompra, String estado,
			Timestamp fechaDespacho, String observaciones, String ordenDespacho) {
		Optional<PurchaseOrderModel> purchaseOrder = purchaseRepository.findById(idOrdenDeCompra);
		EditPurchaseOrderResponse.Builder response = EditPurchaseOrderResponse.newBuilder();
		response.setSuccess(false);

		if (purchaseOrder.isPresent()) {
			purchaseOrder.get().setIdTienda((long) idTienda);
			purchaseOrder.get().setState(estado);
			purchaseOrder.get().setObservations(observaciones);
			purchaseOrder.get().setOrderDispatch(ordenDespacho);
			purchaseOrder.get().setReception(convertToLocalDateTime(fechaDespacho));
			purchaseRepository.save(purchaseOrder.get());
			response.setSuccess(true);
		}

		return response.build();
	}

	public DeletePurchaseOrderResponse deletePurchaseOrder(int id) {
		Optional<PurchaseOrderModel> orderPurchase = purchaseRepository.findById((long) id);
		DeletePurchaseOrderResponse.Builder response = DeletePurchaseOrderResponse.newBuilder();
		if (orderPurchase.isPresent()) {
			orderPurchase.get().setHabilitado(false);
			purchaseRepository.save(orderPurchase.get());
			response.setSuccess(true);
			return response.build();
		}
		response.setSuccess(false);
		return response.build();
	}

	public GetPurchaseOrderByIdResponse getById(int id) {
		GetPurchaseOrderByIdResponse.Builder response = GetPurchaseOrderByIdResponse.newBuilder();
		try {
			if(id == 0) {
				response.addAllPurchaseOrders(purchaseOrderModelToPurchaseOrder(purchaseRepository.findAll()));
			} else {
				List<PurchaseOrderModel> orders = new ArrayList<PurchaseOrderModel>();
				orders.add(purchaseRepository.findById((long)id).get());
				response.addAllPurchaseOrders(purchaseOrderModelToPurchaseOrder(orders));
			}
		} catch (Exception e) {
			log.error("[PurchaseOrderServiceLogic.getById] Unexpected error.", e);
		}
		return response.build();
	}

	public List<PurchaseOrder> purchaseOrderModelToPurchaseOrder(List<PurchaseOrderModel> purchases) {
		List<PurchaseOrder> list = new ArrayList<>();
		try {
			for(PurchaseOrderModel currentPurchase : purchases) {
				List<OrderDetail> listOrderDetail = new ArrayList<>();
				List<OrderDetailsModel> orders = currentPurchase.getOrderDetails();
				for(OrderDetailsModel order : orders) {
					OrderDetail newOrderDetail = OrderDetail.newBuilder()
							.setCodigo(order.getCodigo()).setCantidad(order.getCantidad()).setColor(order.getColor()).setTalle(order.getTalle())
							.build();
					listOrderDetail.add(newOrderDetail);
				}
				PurchaseOrder.Builder newPurchaseBuilder = PurchaseOrder.newBuilder()
					    .setEstado(currentPurchase.getState())
					    .setId(currentPurchase.getId())
					    .setIdTienda(currentPurchase.getIdTienda().intValue())
					    .setObservaciones(currentPurchase.getObservations())
					    .setOrdenDespacho(currentPurchase.getOrderDispatch())
					    .addAllOrders(listOrderDetail);
					if (currentPurchase.getRequest() != null) {
					    newPurchaseBuilder.setFechaSolicitud(convertToTimestamp(currentPurchase.getRequest()));
					}
					if (currentPurchase.getReception() != null) {
					    newPurchaseBuilder.setFechaRecepcion(convertToTimestamp(currentPurchase.getReception()));
					}
					PurchaseOrder newPurchase = newPurchaseBuilder.build();
				list.add(newPurchase);
			}
		} catch (Exception e) {
			log.error("[PurchaseOrderServiceLogic.purchaseOrderModelToPurchaseOrder] Unexpected error.", e);
		}
		return list;
	}
	
	@Transactional
	  public void updateStateOrder(DispatchOrder dispatchOrder) {
		  PurchaseOrderModel orden = purchaseRepository.getById(dispatchOrder.getIdOrden());
		  orden.setReception(LocalDateTime.now());
		  orden.setState("RECIBIDA");
		  purchaseRepository.save(orden);
		  kafkaService.sendDespacho(orden.getOrderDispatch(), LocalDateTime.now().toString());
		  
	   }

	public LocalDateTime convertToLocalDateTime(Timestamp timestamp) {
		Instant instant = Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos());
		return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
	}

	public com.google.protobuf.Timestamp convertToTimestamp(LocalDateTime localDateTime) {
        Instant instant = localDateTime.toInstant(ZoneOffset.UTC);
        return Timestamp.newBuilder()
                        .setSeconds(instant.getEpochSecond())
                        .setNanos(instant.getNano())
                        .build();	
        }
}