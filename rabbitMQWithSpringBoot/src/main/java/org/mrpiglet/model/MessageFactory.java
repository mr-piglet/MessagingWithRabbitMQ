package org.mrpiglet.model;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class MessageFactory {
	
	public static final String COLOR = "COLOR";
	public static final String NUMBER = "NUMBER";
	
	public static final Random rand = new Random();
	public Message getMessage(String messageType) { 
		switch (messageType) {
			case NUMBER: return new LuckyNumber(new Integer(rand.nextInt(37)).toString());
			case COLOR: return (rand.nextInt(2)==0 
									? new LuckyColor("red") 
											: new LuckyColor("black"));
			default: return new LuckyNumber("Do not bet, there has been an issue!");
		}
	}
}
