package io.kafka.producer.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import io.kafka.producer.model.Message;

public interface MessageRepository extends MongoRepository<Message, String> {
}