package com.unla.stockearte.kafka;

import java.time.Duration;
import java.util.Collections;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unla.stockearte.repository.entity.DispatchOrder;
import com.unla.stockearte.repository.entity.ProductModel;
import com.unla.stockearte.services.PurchaseOrderServiceLogic;

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
	
	private KafkaConfig kafkaConfig;

	@Autowired
	public KafkaListenerService(KafkaConsumer<String, String> kafkaConsumer, KafkaConfig kafkaConfig) {
		this.kafkaConsumer = kafkaConsumer;
		this.kafkaConfig = kafkaConfig;
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
	
    public String iniciarNovedades(String topicName) {
        KafkaConsumer<String, String> newConsumer = new KafkaConsumer<>(kafkaConfig.consumerConfigs());
        newConsumer.subscribe(Collections.singletonList(topicName));
        boolean flag = true;
        String jsonInput = null;

        while (flag) {
            ConsumerRecords<String, String> records = newConsumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("Producto recibido: " + record.value());

                try {
                    ProductModel product = objectMapper.readValue(record.value(), ProductModel.class);
                    System.out.println("Producto ID: " + product.getId());
                    jsonInput = record.value();
                    

                    flag = false;
                } catch (Exception e) {
                    System.err.println("Error al deserializar el mensaje: " + e.getMessage());
                    e.printStackTrace(); 
                }
            }
        }
        newConsumer.close();
        return jsonInput;
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
