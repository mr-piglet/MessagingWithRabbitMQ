package org.mrpiglet.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = LuckyColor.class)
public class LuckyColor implements Message {	
	
	private String luckyColor;	
	
	public LuckyColor() {
		super();
	}

	public LuckyColor(String i) {
		super();
		this.luckyColor = i;
	}

	@Override
	public String getMessage() {
		return "Bet on the color " + luckyColor +"!";
	}

	@Override
	public String toString() {
		return "LuckyColor [luckyColor=" + luckyColor + "]";
	}

	public String getLuckyNumber() {
		return luckyColor;
	}

	public void setLuckyNumber(String luckyColor) {
		this.luckyColor = luckyColor;
	}
	
	
		
}
