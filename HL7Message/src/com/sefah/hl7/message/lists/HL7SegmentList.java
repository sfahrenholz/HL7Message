package com.sefah.hl7.message.lists;

import java.util.ArrayList;

import com.sefah.hl7.message.components.HL7Segment;

public class HL7SegmentList extends ArrayList<HL7Segment> {

	private static final long serialVersionUID = 8474514906356110249L;

	public HL7Segment getSegmentByType(String string) {
		for (HL7Segment segment : this) {
			if (segment.getSegmentType().equals(string)) {
				return segment;
			}
		}

		return null;
	}
	
	public HL7Segment getSegmentByType(String string, int segNumber) {
		for (HL7Segment segment : this) {
			if (segment.getSegmentType().equals(string) 
					&& segment.getHL7FieldAsInteger(1) == segNumber) {
				return segment;
			}
		}

		return null;
	}
}
