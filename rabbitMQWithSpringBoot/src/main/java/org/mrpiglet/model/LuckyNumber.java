package org.mrpiglet.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = LuckyNumber.class)
public class LuckyNumber implements Message {	
	
	private String luckyNumber;	
	
	public LuckyNumber() {
		super();
	}

	public LuckyNumber(String i) {
		super();	
		this.luckyNumber = i;
	}

	@Override
	public String getMessage() {
		return "Bet on the number " + luckyNumber + "!";
	}

	@Override
	public String toString() {
		return "LuckyNumber [luckyNumber=" + luckyNumber + "]";
	}



	public String getLuckyNumber() {
		return luckyNumber;
	}

	public void setLuckyNumber(String luckyNumber) {
		this.luckyNumber = luckyNumber;
	}
	
	
		
}
