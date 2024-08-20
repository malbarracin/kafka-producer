package io.kafka.producer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

/**
 * Configuración del productor de Kafka.
 * <p>
 * Esta clase configura las propiedades del productor de Kafka, 
 * incluyendo el servidor de arranque (bootstrap), los serializadores 
 * de clave y valor, y la creación de una instancia de {@link KafkaTemplate} 
 * para enviar mensajes a Kafka.
 * </p>
 */
@Configuration
public class KafkaProducerConfig {

    /**
     * Crea una instancia de {@link ProducerFactory} que será usada para crear productores de Kafka.
     * <p>
     * Este método configura las propiedades necesarias para el productor, 
     * como el servidor de arranque de Kafka y los serializadores de clave y valor.
     * </p>
     *
     * @return una instancia de {@link ProducerFactory} con la configuración especificada.
     */
    @Bean
    ProducerFactory<String, String> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    /**
     * Crea una instancia de {@link KafkaTemplate} para enviar mensajes a Kafka.
     * <p>
     * Este método utiliza la fábrica de productores configurada en {@link #producerFactory()} 
     * para crear y devolver una instancia de {@link KafkaTemplate}.
     * </p>
     *
     * @return una instancia de {@link KafkaTemplate} para enviar mensajes de tipo clave-valor.
     */
    @Bean
    KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}
