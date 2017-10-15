package com.sefah.hl7.message.datatypes;

import com.sefah.hl7.exception.HL7ParseException;
import com.sefah.hl7.message.HL7DateTime;
import com.sefah.hl7.message.components.HL7Repetition;

import java.time.LocalDateTime;

public class DLD extends Datatype {

	public DLD(HL7Repetition datatype) {
		super(datatype);
	}

	public String getDischargeLocation() {
		return repetitionValue.getHL7ComponentValue(0);
	}

	public String getEffectiveDate() {
		return repetitionValue.getHL7ComponentValue(1);
	}
	
	public LocalDateTime getEffectiveDateAsLocalDateTime() throws HL7ParseException {
		return new HL7DateTime(repetitionValue.getHL7ComponentValue(1)).getLocalDateTime();
	}
}