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
            System.out.println(jsonValue);
            kafkaTemplate.send("orden-de-compras-3", jsonValue);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}