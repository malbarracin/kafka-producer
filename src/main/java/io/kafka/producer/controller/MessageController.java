package io.kafka.producer.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.kafka.producer.model.Message;
import io.kafka.producer.service.MessageProducerService;
import lombok.RequiredArgsConstructor;

/**
 * Controlador REST para manejar las solicitudes relacionadas con el envío de mensajes a Kafka.
 * <p>
 * Este controlador expone un endpoint para recibir mensajes a través de una solicitud HTTP POST 
 * y los envía a un topic de Kafka utilizando el {@link MessageProducerService}.
 * </p>
 */
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MessageController {

    private final MessageProducerService producerService;

    /**
     * Endpoint para enviar un mensaje a Kafka.
     * <p>
     * Este método recibe un mensaje en formato JSON a través de una solicitud HTTP POST, 
     * lo procesa y lo envía al topic configurado en Kafka.
     * </p>
     *
     * @param message el objeto {@link Message} recibido en el cuerpo de la solicitud.
     * @return un {@link ResponseEntity} que contiene el mensaje recibido y un estado HTTP 200 OK.
     */
    @PostMapping(value = "/send", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Message> sendMessage(@RequestBody Message message) {
        producerService.processAndSendMessage(message);
        return ResponseEntity.ok(message);
    }
}
