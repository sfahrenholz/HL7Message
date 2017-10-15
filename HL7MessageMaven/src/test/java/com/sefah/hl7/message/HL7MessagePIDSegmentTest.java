package com.sefah.hl7.message;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.sefah.hl7.message.components.HL7Field;
import com.sefah.hl7.message.datatypes.CX;
import com.sefah.hl7.message.datatypes.XPN;
import com.sefah.hl7.message.segment.PIDSegment;

public class HL7MessagePIDSegmentTest {
	private static String msg = "PID|1||123456789|0123456789^AA^^JP|BROS^MARIO^^^^||19850101000000|M|||123 FAKE STREET^MARIO \\T\\ LUIGI BROS PLACE^TOADSTOOL KINGDOM^NES^A1B2C3^JP^HOME^^1234|1234|(555)555-0123^HOME^JP:1234567|||S|MSH|12345678|||||||0|||||N\r";

	@Test
	public void testMessageParsing() throws Exception {
		final HL7Message message = new HL7Message(msg);
		final PIDSegment segment = (PIDSegment) message.getSegment("PID");
		assertNotEquals(segment, null);
		assertEquals(segment.getHL7FieldCount(),31);

		assertHl7Field(segment.getHL7Field(0), "PID");

		assertEquals(segment.getSetId(), new Integer(1));
		assertHl7Field(segment.getHL7Field(1), "1");

		assertEquals(segment.getExternalPatientId(),"");
		assertHl7Field(segment.getHL7Field(2), "");
		final CX externalPatientIdAsCX = segment.getExternalPatientIdAsCX();
		assertEquals(externalPatientIdAsCX.getAssigningAuthority(),"");
		assertEquals(externalPatientIdAsCX.getAssigningFacility(),"");
		assertEquals(externalPatientIdAsCX.getCheckDigit(),"");
		assertEquals(externalPatientIdAsCX.getCheckDigitCodeScheme(),"");
		assertEquals(externalPatientIdAsCX.getId(),"");
		assertEquals(externalPatientIdAsCX.getIdentifierTypeCode(),"");

		assertEquals(segment.getInternalPatientId(),"123456789");
		assertHl7Field(segment.getHL7Field(3), "123456789");

		assertEquals(segment.getAlternatePatientId(),"0123456789^AA^^JP");
		assertHl7Field(segment.getHL7Field(4), "0123456789^AA^^JP");

		assertEquals(segment.getPatientNames(),"BROS^MARIO^^^^");
		assertHl7Field(segment.getHL7Field(5), "BROS^MARIO^^^^");
		final XPN patientNamesAsXPN = segment.getPatientNamesAsXPN();
		assertEquals(patientNamesAsXPN.getFamilyName(),"BROS");
		assertEquals(patientNamesAsXPN.getGivenName(),"MARIO");
		assertEquals(patientNamesAsXPN.getMiddleName(),"");
		assertEquals(patientNamesAsXPN.getNameRepresentationCode(),"");
		assertEquals(patientNamesAsXPN.getNameTypeCode(),"");
		assertEquals(patientNamesAsXPN.getPrefix(),"");
		assertEquals(patientNamesAsXPN.getSuffix(),"");
		assertEquals(patientNamesAsXPN.getDegree(),"");

		assertEquals(segment.getMothersMaidenNames(),"");
		assertHl7Field(segment.getHL7Field(6), "");

		assertEquals(segment.getDateOfBirth().toString(),"1985-01-01T00:00");
		assertHl7Field(segment.getHL7Field(7), "19850101000000");

		assertEquals(segment.getSex(),"M");
		assertHl7Field(segment.getHL7Field(8), "M");

		assertEquals(segment.getPatientAlias(),"");
		assertHl7Field(segment.getHL7Field(9), "");

		assertEquals(segment.getRace(),"");
		assertHl7Field(segment.getHL7Field(10), "");

		assertEquals(segment.getAddresses(),
				"123 FAKE STREET^MARIO \\T\\ LUIGI BROS PLACE^TOADSTOOL KINGDOM^NES^A1B2C3^JP^HOME^^1234");
		assertHl7Field(segment.getHL7Field(11),
				"123 FAKE STREET^MARIO \\T\\ LUIGI BROS PLACE^TOADSTOOL KINGDOM^NES^A1B2C3^JP^HOME^^1234");

		assertEquals(segment.getCountryCode(),"1234");
		assertHl7Field(segment.getHL7Field(12), "1234");

		assertEquals(segment.getHomeTelephones(),"(555)555-0123^HOME^JP:1234567");
		assertHl7Field(segment.getHL7Field(13), "(555)555-0123^HOME^JP:1234567");

		assertEquals(segment.getBusinessTelephones(),"");
		assertHl7Field(segment.getHL7Field(14), "");

		assertEquals(segment.getPrimaryLanguage(),"");
		assertHl7Field(segment.getHL7Field(15), "");

		assertEquals(segment.getMaritalStatus(),"S");
		assertHl7Field(segment.getHL7Field(16), "S");

		assertEquals(segment.getReligion(),"MSH");
		assertHl7Field(segment.getHL7Field(17), "MSH");

		assertEquals(segment.getPatientAccountNumber(),"12345678");
		assertHl7Field(segment.getHL7Field(18), "12345678");

		assertEquals(segment.getSsnNumber(),"");
		assertHl7Field(segment.getHL7Field(19), "");

		assertEquals(segment.getDriversLicenseNumber(),"");
		assertHl7Field(segment.getHL7Field(20), "");

		assertEquals(segment.getMothersIdentifiers(),"");
		assertHl7Field(segment.getHL7Field(21), "");

		assertEquals(segment.getEthnicGroups(),"");
		assertHl7Field(segment.getHL7Field(22), "");

		assertEquals(segment.getBirthPlace(),"");
		assertHl7Field(segment.getHL7Field(23), "");

		assertEquals(segment.getMultipleBirthIndicator(),"");
		assertHl7Field(segment.getHL7Field(24), "");

		assertEquals(segment.getBirthOrder(),"0");
		assertHl7Field(segment.getHL7Field(25), "0");

		assertEquals(segment.getCitizenship(),"");
		assertHl7Field(segment.getHL7Field(26), "");

		assertEquals(segment.getVeteransMilitaryStatus(),"");
		assertHl7Field(segment.getHL7Field(27), "");

		assertEquals(segment.getNationality(),"");
		assertHl7Field(segment.getHL7Field(28), "");

		assertEquals(segment.getDateOfDeath(), null);
		assertHl7Field(segment.getHL7Field(29), "");

		assertEquals(segment.getDeathIndicator(),"N");
		assertHl7Field(segment.getHL7Field(30), "N");

		assertHl7Field(segment.getHL7Field(31), "");

		assertEquals(segment.getTraceStatus(),"");
		assertHl7Field(segment.getHL7Field(32), "");
	}

	private void assertHl7Field(final HL7Field hl7Field, final String expectedValue) {
		if (hl7Field != null) {
			assertEquals(hl7Field.getValue(),expectedValue);
		}
	}
}
