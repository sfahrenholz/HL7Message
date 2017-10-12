package com.sefah.hl7.message;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.sefah.hl7.message.components.HL7Field;
import com.sefah.hl7.message.segment.MSHSegment;

public class HL7MessageMSHSegmentTest {
	private static String MSH_HEADER_23 = "MSH|^~\\&|NES|NINTENDO|TESTSYSTEM|TESTFACILITY|20010101000000||ADT^A04|Q123456789T123456789X123456|P|2.3\r";
	private static String MSH_HEADER_24 = "MSH|^~\\&|GHH LAB|ELAB-3|GHH OE|BLDG4|200202150930||ORU^R01|CNTRL-3456|P|2.4";
	private static String MSH_HEADER_25 = "MSH|^~\\&|SUBx||PAT||20040328112408||ADT^A01^ADT_A01|47|P|2.5|||AL|NE|DEU|8859/1|DEU^^HL70296||2.16.840.1.113883.2.6.9.1^^2.16.840.1.113883.2.6^ISO|";

	@Test
	public void testMessageParsingV23() throws Exception {
		final HL7Message message = new HL7Message(MSH_HEADER_23);
		assertThat(message, notNullValue());
		assertThat(message.getSegmentCount(), is(1));

		final MSHSegment segment = (MSHSegment) message.getSegment("MSH");
		assertThat(segment, notNullValue());
		assertThat(segment.getHL7FieldCount(), is(12));

		assertHl7Field(segment.getHL7Field(0), "MSH");

		assertThat(segment.getEncodingCharacters(), is("|^~\\&"));
		assertHl7Field(segment.getHL7Field(1), "|^~\\&");

		assertThat(segment.getSendingApplication(), is("NES"));
		assertHl7Field(segment.getHL7Field(2), "NES");
		
		assertThat(segment.getSendingFacility(), is("NINTENDO"));
		assertHl7Field(segment.getHL7Field(3), "NINTENDO");

		assertThat(segment.getReceivingApplication(), is("TESTSYSTEM"));
		assertHl7Field(segment.getHL7Field(4), "TESTSYSTEM");

		assertThat(segment.getReceivingFacility(), is("TESTFACILITY"));
		assertHl7Field(segment.getHL7Field(5), "TESTFACILITY");
		
		assertThat(segment.getDateTimeOfMessage().toString(), is("2001-01-01T00:00"));
		assertHl7Field(segment.getHL7Field(6), "20010101000000");

		assertThat(segment.getSecurity(), is(""));
		assertHl7Field(segment.getHL7Field(7), "");

		assertThat(segment.getMessageType(), is("ADT^A04"));
		assertHl7Field(segment.getHL7Field(8), "ADT^A04");

		assertThat(segment.getMessageControlId(), is("Q123456789T123456789X123456"));
		assertHl7Field(segment.getHL7Field(9), "Q123456789T123456789X123456");

		assertThat(segment.getProcessingId(), is("P"));
		assertHl7Field(segment.getHL7Field(10), "P");

		assertThat(segment.getVersionId(), is("2.3"));
		assertHl7Field(segment.getHL7Field(11), "2.3");
	}

	@Test
	public void testMessageParsingV24() throws Exception {
		final HL7Message message = new HL7Message(MSH_HEADER_24);
		assertThat(message, notNullValue());
		assertThat(message.getSegmentCount(), is(1));

		final MSHSegment segment = (MSHSegment) message.getSegment("MSH");
		assertThat(segment, notNullValue());
		assertThat(segment.getHL7FieldCount(), is(12));

		assertHl7Field(segment.getHL7Field(0), "MSH");

		assertThat(segment.getEncodingCharacters(), is("|^~\\&"));
		assertHl7Field(segment.getHL7Field(1), "|^~\\&");

		assertThat(segment.getSendingApplication(), is("GHH LAB"));
		assertHl7Field(segment.getHL7Field(2), "GHH LAB");
		
		assertThat(segment.getSendingFacility(), is("ELAB-3"));
		assertHl7Field(segment.getHL7Field(3), "ELAB-3");

		assertThat(segment.getReceivingApplication(), is("GHH OE"));
		assertHl7Field(segment.getHL7Field(4), "GHH OE");

		assertThat(segment.getReceivingFacility(), is("BLDG4"));
		assertHl7Field(segment.getHL7Field(5), "BLDG4");

		assertThat(segment.getDateTimeOfMessage().toString(), is("2002-02-15T09:30"));
		assertHl7Field(segment.getHL7Field(6), "200202150930");

		assertThat(segment.getSecurity(), is(""));
		assertHl7Field(segment.getHL7Field(7), "");

		assertThat(segment.getMessageType(), is("ORU^R01"));
		assertHl7Field(segment.getHL7Field(8), "ORU^R01");

		assertThat(segment.getMessageControlId(), is("CNTRL-3456"));
		assertHl7Field(segment.getHL7Field(9), "CNTRL-3456");

		assertThat(segment.getProcessingId(), is("P"));
		assertHl7Field(segment.getHL7Field(10), "P");

		assertThat(segment.getVersionId(), is("2.4"));
		assertHl7Field(segment.getHL7Field(11), "2.4");
	}
	
	@Test
	public void testMessageParsingV25() throws Exception {
		final HL7Message message = new HL7Message(MSH_HEADER_25);
		assertThat(message, notNullValue());
		assertThat(message.getSegmentCount(), is(1));

		final MSHSegment segment = (MSHSegment) message.getSegment("MSH");
		assertThat(segment, notNullValue());
		assertThat(segment.getHL7FieldCount(), is(21));

		int fieldValue = 0;
		assertHl7Field(segment.getHL7Field(fieldValue++), "MSH");

		assertThat(segment.getEncodingCharacters(), is("|^~\\&"));
		assertHl7Field(segment.getHL7Field(fieldValue++), "|^~\\&");

		assertThat(segment.getSendingApplication(), is("SUBx"));
		assertHl7Field(segment.getHL7Field(fieldValue++), "SUBx");
		
		assertThat(segment.getSendingFacility(), is(""));
		assertHl7Field(segment.getHL7Field(fieldValue++), "");

		assertThat(segment.getReceivingApplication(), is("PAT"));
		assertHl7Field(segment.getHL7Field(fieldValue++), "PAT");

		assertThat(segment.getReceivingFacility(), is(""));
		assertHl7Field(segment.getHL7Field(fieldValue++), "");

		assertThat(segment.getDateTimeOfMessage().toString(), is("2004-03-28T11:24:08"));
		assertHl7Field(segment.getHL7Field(fieldValue++), "20040328112408");

		assertThat(segment.getSecurity(), is(""));
		assertHl7Field(segment.getHL7Field(fieldValue++), "");

		assertThat(segment.getMessageType(), is("ADT^A01^ADT_A01"));
		assertHl7Field(segment.getHL7Field(fieldValue++), "ADT^A01^ADT_A01");

		assertThat(segment.getMessageControlId(), is("47"));
		assertHl7Field(segment.getHL7Field(fieldValue++), "47");

		assertThat(segment.getProcessingId(), is("P"));
		assertHl7Field(segment.getHL7Field(fieldValue++), "P");

		assertThat(segment.getVersionId(), is("2.5"));
		assertHl7Field(segment.getHL7Field(fieldValue++), "2.5");

		assertThat(segment.getSequenceNumber(), nullValue());
		assertHl7Field(segment.getHL7Field(fieldValue++), "");
		
		assertThat(segment.getContinuationPointer(), is(""));
		assertHl7Field(segment.getHL7Field(fieldValue++), "");
		
		assertThat(segment.getAcceptAcknowledgmentType(), is("AL"));
		assertHl7Field(segment.getHL7Field(fieldValue++), "AL");
		
		assertThat(segment.getApplicationAcknowledgmentType(), is("NE"));
		assertHl7Field(segment.getHL7Field(fieldValue++), "NE");
		
		assertThat(segment.getCountryCode(), is("DEU"));
		assertHl7Field(segment.getHL7Field(fieldValue++), "DEU");
		
		assertThat(segment.getCharacterSet(), is("8859/1"));
		assertHl7Field(segment.getHL7Field(fieldValue++), "8859/1");
		
		assertThat(segment.getPrincipalLanguageOfMessage(), is("DEU^^HL70296"));
		assertHl7Field(segment.getHL7Field(fieldValue++), "DEU^^HL70296");
		
		assertHl7Field(segment.getHL7Field(fieldValue++), "");
		assertHl7Field(segment.getHL7Field(fieldValue++), "2.16.840.1.113883.2.6.9.1^^2.16.840.1.113883.2.6^ISO");
		assertHl7Field(segment.getHL7Field(fieldValue++), "");
	}
	
	private void assertHl7Field(final HL7Field hl7Field, final String expectedValue) {
		if (hl7Field != null) {
			assertThat(hl7Field.getValue(), is(expectedValue));
		}
	}
}
