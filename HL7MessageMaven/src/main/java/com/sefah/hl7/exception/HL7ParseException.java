package com.sefah.hl7.exception;

public class HL7ParseException extends HL7MessageException {

	private static final long serialVersionUID = 5696369989848236841L;

	public HL7ParseException(HL7MessageErrorCode code) {
		super(code);
	}

	public HL7ParseException(HL7MessageErrorCode code, Object ... string) {
		super(code, string);
	}

}
