package com.sefah.hl7.message.segment;

import com.sefah.hl7.exception.HL7ParseException;
import com.sefah.hl7.message.HL7DateTime;
import com.sefah.hl7.message.components.HL7Encoding;
import com.sefah.hl7.message.components.HL7Segment;
import com.sefah.hl7.message.datatypes.CE;
import com.sefah.hl7.message.datatypes.lists.XCNArrayList;

public class OBXSegment extends HL7Segment {
	public OBXSegment(String segment, HL7Encoding encoding) throws HL7ParseException {
		super(segment, encoding);
	}

	public int getSetId() {
		return this.getHL7FieldAsInteger(1);
	}

	public String getValueType() {
		return this.getHL7FieldAsString(2);
	}

	public String getObservationIdentifier() {
		return this.getHL7FieldAsString(3);
	}
	public CE getObservationIdentifierAsCE() {
		return new CE(this.getHL7Field(3).getHL7Repetition(0));
	}

	public String getObservationSubID() {
		return this.getHL7FieldAsString(4);
	}

	public String getObservationValue() {
		return this.getHL7FieldAsString(5);
	}

	public CE getUnits() {
		return new CE(this.getHL7Field(6).getHL7Repetition(0));
	}

	public String getReferencesRange() {
		return this.getHL7FieldAsString(7);
	}

	public String getAbnormalFlags() {
		return this.getHL7FieldAsString(8);
	}

	public String getProbability() {
		return this.getHL7FieldAsString(9);
	}

	public String getNatureOfAbnormalTest() {
		return this.getHL7FieldAsString(10);
	}

	public String getObservationResultStatus() {
		return this.getHL7FieldAsString(11);
	}

	public HL7DateTime getDateLastObsNormalValues() throws HL7ParseException {
		return this.getHL7FieldAsHL7Date(12);
	}

	public String getUserDefinedAccessChecks() {
		return this.getHL7FieldAsString(13);
	}

	public HL7DateTime getDateTimeOfTheObservation() throws HL7ParseException {
		return this.getHL7FieldAsHL7Date(14);
	}

	public CE getProducersID() {
		return new CE(this.getHL7Field(15).getHL7Repetition(0));
	}

	public XCNArrayList getResponsibleObserver() {
		return new XCNArrayList(this.getHL7Field(16));
	}

	public CE getObservationMethod() {
		return new CE(this.getHL7Field(17).getHL7Repetition(0));
	}
}
