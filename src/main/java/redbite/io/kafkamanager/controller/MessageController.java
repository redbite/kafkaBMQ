package redbite.io.kafkamanager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import redbite.io.kafkamanager.kafka.KafkaConsumer;
import redbite.io.kafkamanager.kafka.KafkaProducer;
import redbite.io.kafkamanager.payload.User;

@RestController
public class MessageController {
	private KafkaProducer kafkaProducer;
	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
	

	public MessageController(KafkaProducer kafkaProducer) {
		super();
		this.kafkaProducer = kafkaProducer;
	}
	
//	localhost:8080/publish?message=testingPublish
//	@GetMapping("/publish")
//	public ResponseEntity<String> publish(@RequestParam("message") String message){
//		kafkaProducer.sendMessage(message);
//		return ResponseEntity.ok("Message sent to the topic");
//	}
	
	@PostMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody User user){
		logger.info("user in input: {}",user.toString());
		kafkaProducer.sendMessage(user);
		return ResponseEntity.ok("Json message sent");
	}
}
