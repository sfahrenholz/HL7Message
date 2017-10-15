package com.sefah.hl7.exception;

public enum HL7MessageErrorCode {
	HL7_MESSAGE_ENCODING(				"HL7_00010", "The received Message is not in MAC encoding (<CR> line breaks). Message can not be parsed!!"),
	HL7_MESSAGE_INVALD_MSH2(			"HL7_00011", "HL7 Message contains invalid encoding value. Expected in MSH.2 5 characters but was '{0}'"),
	HL7_MESSAGE_ERROR_FIND_SEGMENT(		"HL7_00012", "Could not find constructor for segment '{0}'"),
	HL7_MESSAGE_ERROR_SEGMENT(			"HL7_00013", "Error on get Hl7Segment '{0}'"),
	HL7_MESSAGE_ERROR_IVALID_DATETIME(	"HL7_00014", "Invalid DateTime format '{0}'"),
	HL7_MESSAGE_ERROR_PARSE_DATETIME(	"HL7_00015", "Could not parse date time '{0}'");

	private final String code;
	private final String description;

	private HL7MessageErrorCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public String getCode() {
		return code; 
	}

	@Override
	public String toString() {
		return code + ": " + description;
	}
}