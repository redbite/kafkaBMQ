package redbite.io.kafkamanager.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import redbite.io.kafkamanager.payload.User;

@Service
public class KafkaProducer {
	private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
	
	//related to application properties Serialization/Deserialization key-value
	private KafkaTemplate<String, User> kafkaTemplate;
	
	public KafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
		this.kafkaTemplate=kafkaTemplate;
	}
	
//	public void sendMessage(String message) {
//		LOGGER.info(String.format("Message sent: {}", message));
//		kafkaTemplate.send("SJTopic", message);
//	}
	
	public void sendMessage(User user) {
		logger.info(String.format("Payload sent: {}", user.toString()));
		//In KafkaJson the header indicates the Topic to which send the messages
		Message<User> message = MessageBuilder.withPayload(user)
				.setHeader(KafkaHeaders.TOPIC,"SJTopic") 
				.build();
//		kafkaTemplate.send("SJTopic", message); //already specified the Topic with the Header
		kafkaTemplate.send(message);
	}
}
