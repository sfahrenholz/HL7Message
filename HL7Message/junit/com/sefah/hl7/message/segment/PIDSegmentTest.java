package com.sefah.hl7.message.segment;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.sefah.hl7.message.components.HL7Encoding;
import com.sefah.hl7.message.datatypes.lists.CXArrayList;

public class PIDSegmentTest {
	final String PID_SEGMENT_1 = "PID|1||||KENNEDY^JOHN";
	final String PID_SEGMENT_2 = "PID|||1234^^^^SR^~1234-12^^^^LR^~3872^^^^MR~221345671^^^^SS^~430078856^^^^MA^ ||KENNEDY^JOHN^FITZGERALD^JR^^^L|BOUVIER^^^^^^M|19900607|M|KENNEDY^BABY BOY^^^^^^ B|W^WHITE^NY8 RACE CODES^W^WHITE^HL70005|123 MAIN ST^APT 3B^LEXINGTON^MA^00210^ ^M^MSA CODE^MA034~345 ELM ST^^BOSTON^MA^00314^^BLD~^^^^^^BR^^MA002| |(617) 555-1212 ^PRN^PH^^^617^5551212^^||EN^ENGLISH^HL70296^^^|||||||WN^NOT HISPANIC^LOCAL CODE SET^NH^NOT OF HISPANIC ORIGIN^HL70189|CHILDREN=S HOSPITAL";
	final String PID_SEGMENT_3 = "PID|||221345671^^^^SS||KENNEDY^JOHN^FITZGERALD^JR|BOUVIER^^^^^^M|19900607|M|||^^^^MA^^^BLD";
	final String PID_SEGMENT_4 = "PD1|||CHILDREN=S HOSPITAL^^1234^^^^XX~LEXINGTON CLINIC^^1234A^^^^FI|12345^CARE^ PRIMARY^^^DR^MD^^^L^^^DN|||||||03^REMINDER/RECALL - NO CALLS^HL70215|Y";

	@Test
	public void testPIDSegment_1() throws Exception {
		PIDSegment seg = new PIDSegment(PID_SEGMENT_1, new HL7Encoding());
		
		assertThat(seg, notNullValue());
		assertThat(seg.getHL7FieldCount(), is(6));

		assertThat(seg.getSetId(), is(1));
		assertThat(seg.getExternalPatientId(), is(""));
		assertThat(seg.getInternalPatientId().isEmpty(), is(true));
		assertThat(seg.getAlternatePatientId().isEmpty(), is(true));
		assertThat(seg.getPatientNames(), is("KENNEDY^JOHN"));
		assertThat(seg.getMothersMaidenNames().isEmpty(), is(true));
		assertThat(seg.getDateOfBirth(), nullValue());
		assertThat(seg.getSex(), is(""));
		assertThat(seg.getPatientAlias().isEmpty(), is(true));
		assertThat(seg.getRace(), is(""));
		assertThat(seg.getAddresses().isEmpty(), is(true));

		assertThat(seg.getCountryCode(), is(""));
		assertThat(seg.getHomeTelephones().isEmpty(), is(true));
		assertThat(seg.getBusinessTelephones().isEmpty(), is(true));
		assertThat(seg.getPrimaryLanguage(), is(""));
		assertThat(seg.getMaritalStatus(), is(""));
		assertThat(seg.getReligion(), is(""));
		assertThat(seg.getPatientAccountNumber(), is(""));
		assertThat(seg.getSsnNumber(), is(""));
		assertThat(seg.getDriversLicenseNumber(), is(""));

		assertThat(seg.getMothersIdentifiers().isEmpty(), is(true));
		assertThat(seg.getEthnicGroups().isEmpty(), is(true));
		assertThat(seg.getBirthPlace(), is(""));
		assertThat(seg.getMultipleBirthIndicator(), is(""));
		assertThat(seg.getBirthOrder(), is(""));
		assertThat(seg.getCitizenship().isEmpty(), is(true));
		assertThat(seg.getVeteransMilitaryStatus().isEmpty(), is(true));
		assertThat(seg.getNationality(), is(""));
		assertThat(seg.getDateOfDeath(), nullValue());
		assertThat(seg.getDeathIndicator(), is(""));
		assertThat(seg.getTraceStatus(), is(""));
	}

	@Test
	public void testPIDSegment_2() throws Exception {
		PIDSegment seg = new PIDSegment(PID_SEGMENT_2, new HL7Encoding());
		
		assertThat(seg, notNullValue());
		assertThat(seg.getHL7FieldCount(), is(24));

		assertThat(seg.getSetId(), nullValue());
		assertThat(seg.getExternalPatientId(), is(""));
		assertThat(seg.getInternalPatientId().isEmpty(), is(false));
		
		CXArrayList internalPatientIds = seg.getInternalPatientIds();
		assertThat(internalPatientIds.size(), is(5));
		assertThat(internalPatientIds.get(0).toString(), is("1234^^^^SR^"));
		assertThat(internalPatientIds.get(1).toString(), is("1234-12^^^^LR^"));
		assertThat(internalPatientIds.get(2).toString(), is("3872^^^^MR"));
		assertThat(internalPatientIds.get(3).toString(), is("221345671^^^^SS^"));
		assertThat(internalPatientIds.get(4).toString(), is("430078856^^^^MA^ "));
		
		assertThat(seg.getAlternatePatientId().isEmpty(), is(true));
		assertThat(seg.getPatientNames(), is("KENNEDY^JOHN^FITZGERALD^JR^^^L"));
		assertThat(seg.getMothersMaidenNames(), is("BOUVIER^^^^^^M"));
		assertThat(seg.getDateOfBirth().toString(), is("1990-06-07T00:00"));
		assertThat(seg.getSex(), is("M"));
		assertThat(seg.getPatientAlias(), is("KENNEDY^BABY BOY^^^^^^ B"));
		assertThat(seg.getRace(), is("W^WHITE^NY8 RACE CODES^W^WHITE^HL70005"));
		assertThat(seg.getAddresses(), is("123 MAIN ST^APT 3B^LEXINGTON^MA^00210^ ^M^MSA CODE^MA034~345 ELM ST^^BOSTON^MA^00314^^BLD~^^^^^^BR^^MA002"));

		assertThat(seg.getCountryCode(), is(" "));
		assertThat(seg.getHomeTelephones(), is("(617) 555-1212 ^PRN^PH^^^617^5551212^^"));
		assertThat(seg.getBusinessTelephones(), is(""));
		assertThat(seg.getPrimaryLanguage(), is("EN^ENGLISH^HL70296^^^"));
		assertThat(seg.getMaritalStatus(), is(""));
		assertThat(seg.getReligion(), is(""));
		assertThat(seg.getPatientAccountNumber(), is(""));
		assertThat(seg.getSsnNumber(), is(""));
		assertThat(seg.getDriversLicenseNumber(), is(""));

		assertThat(seg.getMothersIdentifiers(), is(""));
		assertThat(seg.getEthnicGroups(), is("WN^NOT HISPANIC^LOCAL CODE SET^NH^NOT OF HISPANIC ORIGIN^HL70189"));
		assertThat(seg.getBirthPlace(), is("CHILDREN=S HOSPITAL"));
		assertThat(seg.getMultipleBirthIndicator(), is(""));
		assertThat(seg.getBirthOrder(), is(""));
		assertThat(seg.getCitizenship(), is(""));
		assertThat(seg.getVeteransMilitaryStatus(), is(""));
		assertThat(seg.getNationality(), is(""));
		assertThat(seg.getDateOfDeath(), nullValue());
		assertThat(seg.getDeathIndicator(), is(""));
		assertThat(seg.getTraceStatus(), is(""));
	}
}
