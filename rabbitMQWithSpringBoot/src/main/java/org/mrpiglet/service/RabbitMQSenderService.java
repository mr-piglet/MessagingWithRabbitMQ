package org.mrpiglet.service;

import org.mrpiglet.model.Message;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



@Service
public class RabbitMQSenderService {
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${mrpiglet.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${mrpiglet.rabbitmq.routingkey}")
	private String routingkey;	
	
	public boolean send(Message message) {
		rabbitTemplate.convertAndSend(exchange, routingkey, message);
		System.out.println("Send msg = " + message);
		return true;
	    
	}
}