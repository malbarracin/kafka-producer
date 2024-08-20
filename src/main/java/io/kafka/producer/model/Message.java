package io.kafka.producer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "messages")
public class Message {

	@Id
    private String id;
	
    private String content;
    
    private String status;

}
