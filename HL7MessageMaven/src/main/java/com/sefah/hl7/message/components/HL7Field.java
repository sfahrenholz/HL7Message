package com.sefah.hl7.message.components;

import com.sefah.hl7.message.lists.HL7RepetitionList;

public class HL7Field {

	private String hl7FieldValue;
	private HL7RepetitionList hl7Repetitions;

	public HL7Field(String hl7Field) {
		hl7Repetitions = new HL7RepetitionList();
		hl7FieldValue = hl7Field;
	}

	public HL7Field(String hl7Field, HL7Encoding encoding) {
		hl7Repetitions = new HL7RepetitionList();
		hl7FieldValue = hl7Field;
		parseHL7Repetitions(hl7Field, encoding);
	}

	private void parseHL7Repetitions(String hl7Field, HL7Encoding encoding) {
		if (hl7Field.contains(encoding.getRepetitionSeperator())) {
			String[] split = hl7Field.split(encoding.getEscapeCharacter() +encoding.getRepetitionSeperator());
			
			for (String string : split) {
				hl7Repetitions.add(new HL7Repetition(string, encoding));
			}
		} else {
			// Wenn es vielzahl an Repetitions gibt, ist es die einzige
			hl7Repetitions.add(new HL7Repetition(hl7Field, encoding));
		}
	}

	public String getValue() {
		return hl7FieldValue;
	}
	
	public String getHL7RepetitionValue(int repetitionIndex) {
		HL7Repetition hl7Repetition = getHL7Repetition(repetitionIndex);
		if(hl7Repetition != null) {
			return hl7Repetition.getHL7RepetitionValue();
		}
		
		return "";
	}
	
	public HL7Repetition getHL7Repetition(int repetitionIndex) {
		if (hasHL7Repetition(repetitionIndex)) {
			return hl7Repetitions.get(repetitionIndex);
		}
		
		return null;
	}

	public int getHL7RepetitionCount() {
		return hl7Repetitions.size();
	}
	
	public boolean hasHL7Repetition(int repetitionIndex) {
		return repetitionIndex >= 0 && repetitionIndex < hl7Repetitions.size();
	}

	public HL7RepetitionList getAllHL7Repetitions() {
		return hl7Repetitions;
	}

}
