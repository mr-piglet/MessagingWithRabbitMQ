package org.mrpiglet.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mrpiglet.model.Message;
import org.mrpiglet.model.MessageFactory;
import org.mrpiglet.service.RabbitMQSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class RabbitMQWebControllerTest {
		
	@Autowired 
	private RabbitMQSenderService sender;
	
	@Autowired
	private MessageFactory factory;
	
	@LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    /** Rest request check. */
    @Test
    public void testRest() throws Exception {
    	//For random port - this starts server:
        assertThat(this.restTemplate.getForObject(
        		"http://localhost:" + port + "/mrpiglet-rabbitmq/produceNumber",
                String.class)).contains("Bet on the number");
    	
    }
	
    /** Configuration check. */
	@Test
    public void contextLoads() throws Exception {
    }

	/** Test sender service.*/
	@Test	
	public void testSenderService() {	
		Message sentMessage = factory.getMessage("NUMBER");
		
		assertTrue(sender.send(sentMessage));
	}
	
	/* Receiver service is implemented fully via RabbitMQ, 
	 * so here we test sender service only. */

}
