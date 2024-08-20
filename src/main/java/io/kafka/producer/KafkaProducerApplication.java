package io.kafka.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * La clase principal de la aplicación Kafka Producer.
 * <p>
 * Esta clase configura y lanza la aplicación Spring Boot.
 * </p>
 */
@SpringBootApplication
public class KafkaProducerApplication {

    /**
     * El método principal que se ejecuta al iniciar la aplicación.
     *
     * @param args argumentos de línea de comandos (opcional).
     */
    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }
}
