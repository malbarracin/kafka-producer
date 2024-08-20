package io.kafka.producer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

/**
 * Modelo de datos para representar un mensaje en el sistema.
 * <p>
 * Esta clase es utilizada para almacenar y recuperar mensajes desde MongoDB.
 * Cada mensaje tiene un identificador único, un contenido, y un estado.
 * </p>
 */
@Getter
@Setter
@Document(collection = "messages")
public class Message {

    /**
     * Identificador único del mensaje.
     * <p>
     * Este campo se utiliza como clave primaria en la base de datos MongoDB.
     * </p>
     */
    @Id
    private String id;

    /**
     * Contenido del mensaje.
     * <p>
     * Este campo almacena el texto o la información que el mensaje contiene.
     * </p>
     */
    private String content;
    
    /**
     * Estado del mensaje.
     * <p>
     * Este campo representa el estado actual del mensaje, como "inicial", "procesado", etc.
     * </p>
     */
    private String status;

}
