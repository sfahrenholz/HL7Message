package com.sefah.hl7.message.segment;

import com.sefah.hl7.exception.HL7ParseException;
import com.sefah.hl7.message.HL7DateTime;
import com.sefah.hl7.message.components.HL7Encoding;
import com.sefah.hl7.message.components.HL7Segment;
import com.sefah.hl7.message.datatypes.CE;
import com.sefah.hl7.message.datatypes.CX;
import com.sefah.hl7.message.datatypes.XPN;
import com.sefah.hl7.message.datatypes.lists.CXArrayList;

/**
 * Represents the PIDSegment of an HL7 Message. This class will be used
 * automatically on parsing the message.
 * 
 * @author Sebastian Fahrenholz
 *
 */
public class PIDSegment extends HL7Segment {

	public PIDSegment(String segment, HL7Encoding encoding) throws HL7ParseException {
		super(segment, encoding);
	}

	public Integer getSetId() {
		return this.getHL7FieldAsInteger(1);
	}

	public String getExternalPatientId() {
		return this.getHL7Field(2).getValue();
	}

	public CX getExternalPatientIdAsCX() {
		return new CX(this.getHL7Field(2).getHL7Repetition(0));
	}

	public String getInternalPatientId() {
		return this.getHL7Field(3).getValue();
	}
	
	public CXArrayList getInternalPatientIds() {
		return new CXArrayList(this.getHL7Field(3));
	}

	public String getAlternatePatientId() {
		return this.getHL7Field(4).getValue();
	}

	public String getPatientNames() {
		return this.getHL7Field(5).getValue();
	}

	public XPN getPatientNamesAsXPN() {
		return new XPN(this.getHL7Field(5).getHL7Repetition(0));
	}

	public String getMothersMaidenNames() {
		return this.getHL7Field(6).getValue();
	}

	public HL7DateTime getDateOfBirth() throws HL7ParseException {
		return this.getHL7FieldAsHL7Date(7);
	}

	public String getSex() {
		return this.getHL7Field(8).getValue();
	}

	public String getPatientAlias() {
		return this.getHL7Field(9).getValue();
	}

	public String getRace() {
		return this.getHL7Field(10).getValue();
	}

	public CE getRaceAsCE() {
		return new CE(this.getHL7Field(10).getHL7Repetition(0));
	}

	public String getAddresses() {
		return this.getHL7Field(11).getValue();
	}

	public String getCountryCode() {
		return this.getHL7Field(12).getValue();
	}

	public String getHomeTelephones() {
		return this.getHL7Field(13).getValue();
	}

	public String getBusinessTelephones() {
		return this.getHL7Field(14).getValue();
	}

	public String getPrimaryLanguage() {
		return this.getHL7Field(15).getValue();
	}

	public CE getPrimaryLanguageAsCE() {
		return new CE(this.getHL7Field(15).getHL7Repetition(0));
	}

	public String getMaritalStatus() {
		return this.getHL7Field(16).getValue();
	}

	public CE getMaritalStatusAsCE() {
		return new CE(this.getHL7Field(16).getHL7Repetition(0));
	}

	public String getReligion() {
		return this.getHL7Field(17).getValue();
	}

	public CE getReligionAsCE() {
		return new CE(this.getHL7Field(17).getHL7Repetition(0));
	}

	public String getPatientAccountNumber() {
		return this.getHL7Field(18).getValue();
	}

	public String getSsnNumber() {
		return this.getHL7Field(19).getValue();
	}

	public String getDriversLicenseNumber() {
		return this.getHL7Field(20).getValue();
	}

	public String getMothersIdentifiers() {
		return this.getHL7Field(21).getValue();
	}

	public String getEthnicGroups() {
		return this.getHL7Field(22).getValue();
	}

	public String getBirthPlace() {
		return this.getHL7Field(23).getValue();
	}

	public String getMultipleBirthIndicator() {
		return this.getHL7Field(24).getValue();
	}

	public String getBirthOrder() {
		return this.getHL7Field(25).getValue();
	}

	public String getCitizenship() {
		return this.getHL7Field(26).getValue();
	}

	public String getVeteransMilitaryStatus() {
		return this.getHL7Field(27).getValue();
	}

	public String getNationality() {
		return this.getHL7Field(28).getValue();
	}

	public CE getNationalityAsCE() {
		return new CE(this.getHL7Field(28).getHL7Repetition(0));
	}
	
	public HL7DateTime getDateOfDeath() throws HL7ParseException {
		return this.getHL7FieldAsHL7Date(29);
	}

	public String getDeathIndicator() {
		return this.getHL7Field(30).getValue();
	}

	public String getTraceStatus() {
		return this.getHL7Field(32).getValue();
	}
	
	public CE getTraceStatusAsCE() {
		return new CE(this.getHL7Field(32).getHL7Repetition(0));
	}

}
