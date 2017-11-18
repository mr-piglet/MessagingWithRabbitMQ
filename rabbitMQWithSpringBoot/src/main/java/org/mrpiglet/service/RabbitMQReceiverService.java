package org.mrpiglet.service;

import org.mrpiglet.model.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQReceiverService {
	
	private Message lastReceivedMessage;
			
	@RabbitListener(queues="${mrpiglet.rabbitmq.queue}")
	public void recievedMessage(Message message) {
		setLastReceivedMessage(message);
		System.out.println("Received: " + message.getMessage());
	}

	public Message getLastReceivedMessage() {
		return lastReceivedMessage;
	}

	public void setLastReceivedMessage(Message lastReceivedMessage) {
		this.lastReceivedMessage = lastReceivedMessage;
	}
	
	
}