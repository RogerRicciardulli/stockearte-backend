package com.unla.stockearte.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unla.stockearte.repository.entity.DispatchOrder;
import com.unla.stockearte.services.PurchaseOrderServiceLogic;

import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.ExecutorService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

@Service
public class KafkaListenerService implements Runnable{

	/*
	 * entonces desde stockearte tengo que ver el topic codTienda/despacho y con el
	 * id de orden de compra actualizo en la bd el estado a aceptada
	 */
	private KafkaConsumer<String, String> kafkaConsumer;
	private volatile boolean flag = true; 
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	PurchaseOrderServiceLogic purchaseOrderServiceLogic;

	@Autowired
	public KafkaListenerService(KafkaConsumer<String, String> kafkaConsumer) {
		this.kafkaConsumer = kafkaConsumer;
	}
	
	public KafkaListenerService() {
		super();
	}

	/*public void setNombreTopico(String nombreTopico) {
		this.nombreTopico = nombreTopico;
		//kafkaConsumer.subscribe(Collections.singletonList(nombreTopico));
	}
*/
	//@PostConstruct
	

	public void iniciarConsumo(String topicName) {
		kafkaConsumer.subscribe(Collections.singletonList(topicName));
		flag = true;
			while (flag) {
				ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(100));
				records.forEach(record -> {
					System.out.println("Mensaje recibido: " + record.value());

					try {
						DispatchOrder order = objectMapper.readValue(record.value(), DispatchOrder.class);
						System.out.println("ID ORDEN" + order.getIdOrden());
						System.out.println("ID ORDEN" + order.getIdDespacho());
						purchaseOrderServiceLogic.updateStateOrder(order);
						flag = false;
					} catch (Exception e) {
						System.err.println("Error al deserializar el mensaje: " + e.getMessage());
						e.printStackTrace(); 
					}

				});
			}
	}

	//@PreDestroy
	public void cerrarConsumidor() {
		if (kafkaConsumer != null) {
			kafkaConsumer.close();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
