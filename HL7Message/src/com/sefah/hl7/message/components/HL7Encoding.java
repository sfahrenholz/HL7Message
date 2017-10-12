package com.sefah.hl7.message.components;

import com.sefah.hl7.exception.HL7EncodingException;
import com.sefah.hl7.exception.HL7MessageErrorCode;

public class HL7Encoding {
	private static final String LINE_SEPERATOR_CR = "\r";

	private final String fieldSeperator;
	private final String componentSeperator;
	private final String repetitionSeperator;
	private final String escapeCharacter;
	private final String subcomponentSeperator;

	public HL7Encoding() {
		// Default |^~\&
		fieldSeperator = "|";
		componentSeperator = "^";
		repetitionSeperator = "~";
		subcomponentSeperator = "&";
		escapeCharacter = "\\";
	}

	public HL7Encoding(final String substring) throws HL7EncodingException {
		if (substring == null || substring.length() != 5) {
			throw new HL7EncodingException(HL7MessageErrorCode.HL7_MESSAGE_INVALD_MSH2,substring != null ? (substring.length()) : "<NULL>");
		}

		fieldSeperator = substring.substring(0, 1);
		componentSeperator = substring.substring(1, 2);
		repetitionSeperator = substring.substring(2, 3);
		escapeCharacter = substring.substring(3, 4);
		subcomponentSeperator = substring.substring(4, 5);
	}

	public String getLineSeperator() {
		return LINE_SEPERATOR_CR;
	}

	public String getFieldSeperator() {
		return fieldSeperator;
	}

	public String getComponentSeperator() {
		return componentSeperator;
	}

	public String getRepetitionSeperator() {
		return repetitionSeperator;
	}

	public String getEscapeCharacter() {
		return escapeCharacter;
	}

	public String getSubcomponentSeperator() {
		return subcomponentSeperator;
	}

	public boolean isSeperator(final String value) {
		return fieldSeperator.equals(value) || componentSeperator.equals(value) || repetitionSeperator.equals(value)
				|| subcomponentSeperator.equals(value);
	}

	public String getMSH2Field() {
		final StringBuilder sb = new StringBuilder();
		sb.append(fieldSeperator);
		sb.append(componentSeperator);
		sb.append(repetitionSeperator);
		sb.append(escapeCharacter);
		sb.append(subcomponentSeperator);
		return sb.toString();
	}

	@Override
	public String toString() {
		return "Seperators [fieldSeperator=" + fieldSeperator + ", componentSeperator=" + componentSeperator
				+ ", repetitionSeperator=" + repetitionSeperator + ", escapeCharacter=" + escapeCharacter
				+ ", subcomponentSeperator=" + subcomponentSeperator + "]";
	}
}
