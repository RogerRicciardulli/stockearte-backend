package com.unla.stockearte.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unla.stockearte.repository.model.PurchaseOrderKafka;

@Service
public class KafkaProducerService {

	private final KafkaTemplate<String, String> kafkaTemplate; 
    private final ObjectMapper objectMapper;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;  
        this.objectMapper = objectMapper;    
    }

    public void sendPurchaseOrder(PurchaseOrderKafka purchaseOrder) {
        try {
            String jsonValue = objectMapper.writeValueAsString(purchaseOrder);
            //System.out.println(jsonValue);
            kafkaTemplate.send("orden-de-compra", jsonValue);
            kafkaTemplate.destroy();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    
    public void sendDespacho(String despacho, String fecha) {
        try {
        	String prueba = despacho.concat("  ").concat(fecha);
            String jsonValue = objectMapper.writeValueAsString(prueba);
            System.out.println(jsonValue);
            kafkaTemplate.send("recepcion", jsonValue);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    
}
