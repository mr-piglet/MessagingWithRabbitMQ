package org.mrpiglet;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Purpose of this app is to generate numbers and colors to bet on roulette.
 * 
 * Prerequisites for testing: installed Erlang and installed&running RabbitMQ.
 * 
 * Start project as Java Application, main class is SpringBootHelloWorldApplication.java.
 * 
 * When server receives request such as http://localhost:8080/mrpiglet-rabbitmq/produceNumber,
 * message factory generates lucky number and sends to queue.
 * 
 * App also listens to the same queue, so it will print to the console any new message 
 * from the queue.
 * 
 * For betting on the colors, request should be formed as 
 * http://server:port/mrpiglet-rabbitmq/produceColor.
 * 
 * It is possible to change queue and RabbitMQ related properties in application.proeprties.
 * Similarly, new queues with appropriate routing keys can be added.
 * 
 * It is possible to add new types of messages by implementing Message interface.
 * 
 * Tests are in org.mrpiglet.test package.
 * 
 * @author 0xABCD
 *
 */
@SpringBootApplication
public class MainClass {

	public static void main(String[] args) {

		SpringApplication.run(
				new Object[] { MainClass.class }, args);
	}
}