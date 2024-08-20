package io.kafka.producer.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import io.kafka.producer.model.Message;
import io.kafka.producer.repository.MessageRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessageProducerService {

	private static final String TOPIC = "test_topic";
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final MessageRepository messageRepository;

    public void processAndSendMessage(Message message) {
    	
        // Guardar el estado inicial en la base de datos
        message.setStatus("inicial");
        messageRepository.save(message);

        // Enviar el mensaje a Kafka
        kafkaTemplate.send(TOPIC, message.getContent());
    }
}
