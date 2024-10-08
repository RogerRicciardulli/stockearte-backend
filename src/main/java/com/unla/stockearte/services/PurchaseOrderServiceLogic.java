package com.unla.stockearte.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.protobuf.Timestamp;
import com.unla.stockearte.CreatePurchaseOrderResponse;
import com.unla.stockearte.DeletePurchaseOrderResponse;
import com.unla.stockearte.EditPurchaseOrderResponse;
import com.unla.stockearte.GetPurchaseOrderByIdResponse;
import com.unla.stockearte.OrderDetail;
import com.unla.stockearte.PurchaseOrder;
import com.unla.stockearte.kafka.KafkaProducerService;
import com.unla.stockearte.kafka.KafkaTopicService;
import com.unla.stockearte.repository.entity.OrderDetailsModel;
import com.unla.stockearte.repository.OrderDetailsRepository;
import com.unla.stockearte.repository.PurchaseOrderRepository;
import com.unla.stockearte.repository.entity.PurchaseOrderModel;
import com.unla.stockearte.repository.model.PurchaseOrderKafka;

@Service
public class PurchaseOrderServiceLogic {

	private static final Logger log = LoggerFactory.getLogger(PurchaseOrderServiceLogic.class);
	
	@Autowired
	KafkaProducerService kafkaService;
	
	@Autowired
	KafkaTopicService kafkaTopicService;

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
		
		String nameTopic = Long.toString(idTienda) +"-solicitudes";
		
		kafkaTopicService.createTopic(nameTopic, 1, 1);

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
		Optional<PurchaseOrderModel> purchase = purchaseRepository.findById((long) id);
		if (purchase.isPresent()) {
			List<PurchaseOrderModel> list = new ArrayList<>();
			list.add(purchase.get());
			response.addAllPurchaseOrders(generateList(list));
		}
		return response.build();
	}

	public List<PurchaseOrder> generateList(List<PurchaseOrderModel> list) {
		/*
		 * List<OrderDetail> listOrderResponse = new ArrayList<OrderDetail>(); for
		 * (OrderDetailsModel order: list.get(1).getOrderDetails()) { OrderDetail detail
		 * = OrderDetail.newBuilder() .setCantidad(order.getCantidad())
		 * .setCodigo(order.getCodigo()) .setColor(order.getColor())
		 * .setTalle(order.getTalle()) .build(); listOrderResponse.add(detail); }
		 */

		List<PurchaseOrder> purchaseMiddList = new ArrayList<>();
		for (PurchaseOrderModel purchase : list) {
			PurchaseOrder purchase2 = PurchaseOrder.newBuilder().setEstado(purchase.getState()).setId(purchase.getId())
					.setObservaciones(purchase.getObservations()).setOrdenDespacho(purchase.getOrderDispatch()).build();
			// .setOrders(3, listOrderResponse)
			// .setFechaSolicitud(null)
			// .setIdTienda(purchase.getIdTienda())
			// .setFechaRecepcion(purchase.getReception())
			purchaseMiddList.add(purchase2);
		}
		return purchaseMiddList;
	}

	public static LocalDateTime convertToLocalDateTime(Timestamp timestamp) {
		Instant instant = Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos());
		return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
	}
}
