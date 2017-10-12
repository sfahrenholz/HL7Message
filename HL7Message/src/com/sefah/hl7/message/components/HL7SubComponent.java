package com.sefah.hl7.message.components;

public class HL7SubComponent  {
	
	private String subComponentValue;

	public HL7SubComponent(String segment) {
		subComponentValue = segment;
	}

	public String getSubComponentValue() {
		return subComponentValue;
	}
}
