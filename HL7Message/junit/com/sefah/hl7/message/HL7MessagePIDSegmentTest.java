package com.sefah.hl7.message;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

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
		assertThat(segment, notNullValue());
		assertThat(segment.getHL7FieldCount(), is(31));

		assertHl7Field(segment.getHL7Field(0), "PID");

		assertThat(segment.getSetId(), is(1));
		assertHl7Field(segment.getHL7Field(1), "1");

		assertThat(segment.getExternalPatientId(), is(""));
		assertHl7Field(segment.getHL7Field(2), "");
		final CX externalPatientIdAsCX = segment.getExternalPatientIdAsCX();
		assertThat(externalPatientIdAsCX.getAssigningAuthority(), is(""));
		assertThat(externalPatientIdAsCX.getAssigningFacility(), is(""));
		assertThat(externalPatientIdAsCX.getCheckDigit(), is(""));
		assertThat(externalPatientIdAsCX.getCheckDigitCodeScheme(), is(""));
		assertThat(externalPatientIdAsCX.getId(), is(""));
		assertThat(externalPatientIdAsCX.getIdentifierTypeCode(), is(""));

		assertThat(segment.getInternalPatientId(), is("123456789"));
		assertHl7Field(segment.getHL7Field(3), "123456789");

		assertThat(segment.getAlternatePatientId(), is("0123456789^AA^^JP"));
		assertHl7Field(segment.getHL7Field(4), "0123456789^AA^^JP");

		assertThat(segment.getPatientNames(), is("BROS^MARIO^^^^"));
		assertHl7Field(segment.getHL7Field(5), "BROS^MARIO^^^^");
		final XPN patientNamesAsXPN = segment.getPatientNamesAsXPN();
		assertThat(patientNamesAsXPN.getFamilyName(), is("BROS"));
		assertThat(patientNamesAsXPN.getGivenName(), is("MARIO"));
		assertThat(patientNamesAsXPN.getMiddleName(), is(""));
		assertThat(patientNamesAsXPN.getNameRepresentationCode(), is(""));
		assertThat(patientNamesAsXPN.getNameTypeCode(), is(""));
		assertThat(patientNamesAsXPN.getPrefix(), is(""));
		assertThat(patientNamesAsXPN.getSuffix(), is(""));
		assertThat(patientNamesAsXPN.getDegree(), is(""));

		assertThat(segment.getMothersMaidenNames(), is(""));
		assertHl7Field(segment.getHL7Field(6), "");

		assertThat(segment.getDateOfBirth().toString(), is("1985-01-01T00:00"));
		assertHl7Field(segment.getHL7Field(7), "19850101000000");

		assertThat(segment.getSex(), is("M"));
		assertHl7Field(segment.getHL7Field(8), "M");

		assertThat(segment.getPatientAlias(), is(""));
		assertHl7Field(segment.getHL7Field(9), "");

		assertThat(segment.getRace(), is(""));
		assertHl7Field(segment.getHL7Field(10), "");

		assertThat(segment.getAddresses(),
				is("123 FAKE STREET^MARIO \\T\\ LUIGI BROS PLACE^TOADSTOOL KINGDOM^NES^A1B2C3^JP^HOME^^1234"));
		assertHl7Field(segment.getHL7Field(11),
				"123 FAKE STREET^MARIO \\T\\ LUIGI BROS PLACE^TOADSTOOL KINGDOM^NES^A1B2C3^JP^HOME^^1234");

		assertThat(segment.getCountryCode(), is("1234"));
		assertHl7Field(segment.getHL7Field(12), "1234");

		assertThat(segment.getHomeTelephones(), is("(555)555-0123^HOME^JP:1234567"));
		assertHl7Field(segment.getHL7Field(13), "(555)555-0123^HOME^JP:1234567");

		assertThat(segment.getBusinessTelephones(), is(""));
		assertHl7Field(segment.getHL7Field(14), "");

		assertThat(segment.getPrimaryLanguage(), is(""));
		assertHl7Field(segment.getHL7Field(15), "");

		assertThat(segment.getMaritalStatus(), is("S"));
		assertHl7Field(segment.getHL7Field(16), "S");

		assertThat(segment.getReligion(), is("MSH"));
		assertHl7Field(segment.getHL7Field(17), "MSH");

		assertThat(segment.getPatientAccountNumber(), is("12345678"));
		assertHl7Field(segment.getHL7Field(18), "12345678");

		assertThat(segment.getSsnNumber(), is(""));
		assertHl7Field(segment.getHL7Field(19), "");

		assertThat(segment.getDriversLicenseNumber(), is(""));
		assertHl7Field(segment.getHL7Field(20), "");

		assertThat(segment.getMothersIdentifiers(), is(""));
		assertHl7Field(segment.getHL7Field(21), "");

		assertThat(segment.getEthnicGroups(), is(""));
		assertHl7Field(segment.getHL7Field(22), "");

		assertThat(segment.getBirthPlace(), is(""));
		assertHl7Field(segment.getHL7Field(23), "");

		assertThat(segment.getMultipleBirthIndicator(), is(""));
		assertHl7Field(segment.getHL7Field(24), "");

		assertThat(segment.getBirthOrder(), is("0"));
		assertHl7Field(segment.getHL7Field(25), "0");

		assertThat(segment.getCitizenship(), is(""));
		assertHl7Field(segment.getHL7Field(26), "");

		assertThat(segment.getVeteransMilitaryStatus(), is(""));
		assertHl7Field(segment.getHL7Field(27), "");

		assertThat(segment.getNationality(), is(""));
		assertHl7Field(segment.getHL7Field(28), "");

		assertThat(segment.getDateOfDeath(), nullValue());
		assertHl7Field(segment.getHL7Field(29), "");

		assertThat(segment.getDeathIndicator(), is("N"));
		assertHl7Field(segment.getHL7Field(30), "N");

		assertHl7Field(segment.getHL7Field(31), "");

		assertThat(segment.getTraceStatus(), is(""));
		assertHl7Field(segment.getHL7Field(32), "");
	}

	private void assertHl7Field(final HL7Field hl7Field, final String expectedValue) {
		if (hl7Field != null) {
			assertThat(hl7Field.getValue(), is(expectedValue));
		}
	}
}
