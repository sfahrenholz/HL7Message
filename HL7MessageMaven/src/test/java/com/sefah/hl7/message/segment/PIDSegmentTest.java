package com.sefah.hl7.message.segment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
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
		
		assertNotEquals(seg, null);
		assertEquals(seg.getHL7FieldCount(), 6);

		assertEquals(seg.getSetId(), new Integer(1));
		assertEquals(seg.getExternalPatientId(), "");
		assertEquals(seg.getInternalPatientId().isEmpty(), true);
		assertEquals(seg.getAlternatePatientId().isEmpty(), true);
		assertEquals(seg.getPatientNames(), "KENNEDY^JOHN");
		assertEquals(seg.getMothersMaidenNames().isEmpty(), true);
		assertEquals(seg.getDateOfBirth(), null);
		assertEquals(seg.getSex(), "");
		assertEquals(seg.getPatientAlias().isEmpty(), true);
		assertEquals(seg.getRace(), "");
		assertEquals(seg.getAddresses().isEmpty(), true);

		assertEquals(seg.getCountryCode(), "");
		assertEquals(seg.getHomeTelephones().isEmpty(), true);
		assertEquals(seg.getBusinessTelephones().isEmpty(), true);
		assertEquals(seg.getPrimaryLanguage(), "");
		assertEquals(seg.getMaritalStatus(), "");
		assertEquals(seg.getReligion(), "");
		assertEquals(seg.getPatientAccountNumber(), "");
		assertEquals(seg.getSsnNumber(), "");
		assertEquals(seg.getDriversLicenseNumber(), "");

		assertEquals(seg.getMothersIdentifiers().isEmpty(), true);
		assertEquals(seg.getEthnicGroups().isEmpty(), true);
		assertEquals(seg.getBirthPlace(), "");
		assertEquals(seg.getMultipleBirthIndicator(), "");
		assertEquals(seg.getBirthOrder(), "");
		assertEquals(seg.getCitizenship().isEmpty(), true);
		assertEquals(seg.getVeteransMilitaryStatus().isEmpty(), true);
		assertEquals(seg.getNationality(), "");
		assertEquals(seg.getDateOfDeath(), null);
		assertEquals(seg.getDeathIndicator(), "");
		assertEquals(seg.getTraceStatus(), "");
	}

	@Test
	public void testPIDSegment_2() throws Exception {
		PIDSegment seg = new PIDSegment(PID_SEGMENT_2, new HL7Encoding());
		
		assertNotEquals(seg, null);
		assertEquals(seg.getHL7FieldCount(), 24);

		assertEquals(seg.getSetId(), null);
		assertEquals(seg.getExternalPatientId(), "");
		assertEquals(seg.getInternalPatientId().isEmpty(), false);
		
		CXArrayList internalPatientIds = seg.getInternalPatientIds();
		assertEquals(internalPatientIds.size(), 5);
		assertEquals(internalPatientIds.get(0).toString(), "1234^^^^SR^");
		assertEquals(internalPatientIds.get(1).toString(), "1234-12^^^^LR^");
		assertEquals(internalPatientIds.get(2).toString(), "3872^^^^MR");
		assertEquals(internalPatientIds.get(3).toString(), "221345671^^^^SS^");
		assertEquals(internalPatientIds.get(4).toString(), "430078856^^^^MA^ ");
		
		assertEquals(seg.getAlternatePatientId().isEmpty(), true);
		assertEquals(seg.getPatientNames(), "KENNEDY^JOHN^FITZGERALD^JR^^^L");
		assertEquals(seg.getMothersMaidenNames(), "BOUVIER^^^^^^M");
		assertEquals(seg.getDateOfBirth().toString(), "1990-06-07T00:00");
		assertEquals(seg.getSex(), "M");
		assertEquals(seg.getPatientAlias(), "KENNEDY^BABY BOY^^^^^^ B");
		assertEquals(seg.getRace(), "W^WHITE^NY8 RACE CODES^W^WHITE^HL70005");
		assertEquals(seg.getAddresses(), "123 MAIN ST^APT 3B^LEXINGTON^MA^00210^ ^M^MSA CODE^MA034~345 ELM ST^^BOSTON^MA^00314^^BLD~^^^^^^BR^^MA002");

		assertEquals(seg.getCountryCode(), " ");
		assertEquals(seg.getHomeTelephones(), "(617) 555-1212 ^PRN^PH^^^617^5551212^^");
		assertEquals(seg.getBusinessTelephones(), "");
		assertEquals(seg.getPrimaryLanguage(), "EN^ENGLISH^HL70296^^^");
		assertEquals(seg.getMaritalStatus(), "");
		assertEquals(seg.getReligion(), "");
		assertEquals(seg.getPatientAccountNumber(), "");
		assertEquals(seg.getSsnNumber(), "");
		assertEquals(seg.getDriversLicenseNumber(), "");

		assertEquals(seg.getMothersIdentifiers(), "");
		assertEquals(seg.getEthnicGroups(), "WN^NOT HISPANIC^LOCAL CODE SET^NH^NOT OF HISPANIC ORIGIN^HL70189");
		assertEquals(seg.getBirthPlace(), "CHILDREN=S HOSPITAL");
		assertEquals(seg.getMultipleBirthIndicator(), "");
		assertEquals(seg.getBirthOrder(), "");
		assertEquals(seg.getCitizenship(), "");
		assertEquals(seg.getVeteransMilitaryStatus(), "");
		assertEquals(seg.getNationality(), "");
		assertEquals(seg.getDateOfDeath(), null);
		assertEquals(seg.getDeathIndicator(), "");
		assertEquals(seg.getTraceStatus(), "");
	}
}
