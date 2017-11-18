package org.mrpiglet.controller;

import org.mrpiglet.model.Message;
import org.mrpiglet.model.MessageFactory;
import org.mrpiglet.service.RabbitMQSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/mrpiglet-rabbitmq/")
public class RabbitMQWebController {
	
	public static final String COLOR = "COLOR";
	public static final String NUMBER = "NUMBER";

	@Autowired
	private RabbitMQSenderService rabbitMQSenderService;
	
	@Autowired
	private MessageFactory messageFactory;
	
	@GetMapping(value = "/produceNumber")
	public String produceNumber() {
		return sendMessage(NUMBER);
	}
	
	@GetMapping(value = "/produceColor")
	public String produceColor() {		
		return sendMessage(COLOR);
	}
	
	private String sendMessage(final String messageType) {
		Message ln = messageFactory.getMessage(messageType);		
	    rabbitMQSenderService.send(ln);	
		return ln.getMessage();
	}

}
