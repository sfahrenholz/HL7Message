package com.sefah.hl7.message.datatypes;

import com.sefah.hl7.message.components.HL7Repetition;

public class Datatype {
	protected HL7Repetition repetitionValue;

	public Datatype(HL7Repetition datatype) {
		this.repetitionValue = datatype;
	}

	@Override
	public String toString() {
		return repetitionValue.getHL7RepetitionValue();
	}
}
