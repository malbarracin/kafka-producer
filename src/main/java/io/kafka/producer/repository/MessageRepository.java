package io.kafka.producer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import io.kafka.producer.model.Message;

/**
 * Repositorio para la entidad {@link Message}.
 * <p>
 * Esta interfaz extiende {@link MongoRepository} y proporciona métodos CRUD 
 * para manejar los mensajes almacenados en MongoDB. Cada mensaje se identifica 
 * de manera única por su ID de tipo {@link String}.
 * </p>
 */
public interface MessageRepository extends MongoRepository<Message, String> {
}
