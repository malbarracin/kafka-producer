package io.kafka.producer.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import io.kafka.producer.model.Message;
import io.kafka.producer.repository.MessageRepository;
import lombok.RequiredArgsConstructor;

/**
 * Servicio para procesar y enviar mensajes a Kafka.
 * <p>
 * Este servicio se encarga de manejar la lógica de negocio relacionada con el envío de mensajes
 * a Kafka, así como de gestionar el estado de los mensajes en MongoDB.
 * </p>
 */
@Service
@RequiredArgsConstructor
public class MessageProducerService {

    private static final String TOPIC = "test_topic";
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final MessageRepository messageRepository;

    /**
     * Procesa y envía un mensaje a Kafka.
     * <p>
     * Este método guarda el estado inicial del mensaje en MongoDB, luego envía el contenido
     * del mensaje al topic configurado en Kafka.
     * </p>
     *
     * @param message el objeto {@link Message} que contiene los datos del mensaje a procesar y enviar.
     */
    public void processAndSendMessage(Message message) {

        // Guardar el estado inicial en la base de datos
        message.setStatus("inicial");
        messageRepository.save(message);

        // Enviar el mensaje a Kafka
        kafkaTemplate.send(TOPIC, message.getContent());
    }
}
