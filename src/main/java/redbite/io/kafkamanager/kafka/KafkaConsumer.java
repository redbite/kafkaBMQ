package redbite.io.kafkamanager.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import redbite.io.kafkamanager.payload.User;

@Service
public class KafkaConsumer {
	
	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
	
//	@KafkaListener(topics="SJTopic", groupId="GroupTest")
//	public void consume(String message) {
//		logger.info("Message received {}",message);
//	}
//	
	
	@KafkaListener(topics = "SJTopic", groupId = "GroupTest")
	public void consume(User user) {
		logger.info("Message received: {}", user.toString());
	}
}
