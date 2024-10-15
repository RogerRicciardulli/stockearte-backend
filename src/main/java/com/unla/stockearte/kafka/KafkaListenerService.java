package com.unla.stockearte.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.util.Collections;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

@Service
public class KafkaListenerService {
	
	 private KafkaConsumer<String, String> kafkaConsumer;
	  private String nombreTopico = "prueba-topic"; // Tópico por defecto

	    @Autowired
	    public KafkaListenerService(KafkaConsumer<String, String> kafkaConsumer) {
	        this.kafkaConsumer = kafkaConsumer;
	    }

	    public void setNombreTopico(String nombreTopico) {
	        this.nombreTopico = nombreTopico;
	        kafkaConsumer.subscribe(Collections.singletonList(nombreTopico));
	    }

	    @PostConstruct
	    public void iniciarConsumo() {
	        kafkaConsumer.subscribe(Collections.singletonList(nombreTopico));

	        new Thread(() -> {
	            while (true) {
	                ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(100));
	                records.forEach(record -> {
	                    System.out.println("Mensaje recibido: " + record.value());
	                });
	            }
	        }).start();
	    }

	    @PreDestroy
	    public void cerrarConsumidor() {
	        if (kafkaConsumer != null) {
	            kafkaConsumer.close();
	        }
	    }

}
