package com.sefah.hl7.message.segment;

import com.sefah.hl7.exception.HL7ParseException;
import com.sefah.hl7.message.HL7DateTime;
import com.sefah.hl7.message.components.HL7Encoding;
import com.sefah.hl7.message.components.HL7Segment;

/**
 * Represents the MSHSegment of an HL7 Message. This class will be used
 * automatically on parsing the message.
 * 
 * @author Sebastian Fahrenholz
 *
 */
public class MSHSegment extends HL7Segment {

	public MSHSegment(String segment, HL7Encoding seperators) throws HL7ParseException {
		super(segment, seperators);
	}

	public String getEncodingCharacters() {
		return this.getHL7Field(1).getValue();
	}

	public String getSendingApplication() {
		return this.getHL7Value(2, 1);
	}

	public String getSendingFacility() {
		return this.getHL7Value(3, 1);
	}

	public String getReceivingApplication() {
		return this.getHL7Value(4, 1);
	}

	public String getReceivingFacility() {
		return this.getHL7Value(5, 1);
	}

	public HL7DateTime getDateTimeOfMessage() throws HL7ParseException {
		return this.getHL7FieldAsHL7Date(6);
	}

	public String getSecurity() {
		return this.getHL7Field(7).getValue();
	}

	public String getMessageType() {
		return this.getHL7Field(8).getValue();
	}

	public String getMessageControlId() {
		return this.getHL7Field(9).getValue();
	}

	public String getProcessingId() {
		return this.getHL7Field(10).getValue();
	}

	public String getVersionId() {
		return this.getHL7Field(11).getValue();
	}

	public Integer getSequenceNumber() {
		return this.getHL7FieldAsInteger(12);
	}

	public String getContinuationPointer() {
		return this.getHL7Field(13).getValue();
	}

	public String getAcceptAcknowledgmentType() {
		return this.getHL7Field(14).getValue();
	}

	public String getApplicationAcknowledgmentType() {
		return this.getHL7Field(15).getValue();
	}

	public String getCountryCode() {
		return this.getHL7Field(16).getValue();
	}

	public String getCharacterSet() {
		return this.getHL7Field(17).getValue();
	}

	public String getPrincipalLanguageOfMessage() {
		return this.getHL7Field(18).getValue();
	}
}
