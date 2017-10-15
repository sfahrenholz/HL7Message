package com.sefah.hl7.message.datatypes;

import com.sefah.hl7.message.components.HL7Repetition;

public class JCC extends Datatype {
	public JCC(HL7Repetition datatype) {
		super(datatype);
	}

	public String getJobCode() {
		return repetitionValue.getHL7ComponentValue(0);
	}

	public String getJobClass() {
		return repetitionValue.getHL7ComponentValue(1);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getJobCode());
		builder.append(", ");
		builder.append(getJobClass());
		return builder.toString();
	}
}
