package com.sefah.hl7.message;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.sefah.hl7.message.components.HL7Field;
import com.sefah.hl7.message.segment.MSHSegment;

public class HL7MessageMSHSegmentTest {
	private static String MSH_HEADER_23 = "MSH|^~\\&|NES|NINTENDO|TESTSYSTEM|TESTFACILITY|20010101000000||ADT^A04|Q123456789T123456789X123456|P|2.3\r";
	private static String MSH_HEADER_24 = "MSH|^~\\&|GHH LAB|ELAB-3|GHH OE|BLDG4|200202150930||ORU^R01|CNTRL-3456|P|2.4";
	private static String MSH_HEADER_25 = "MSH|^~\\&|SUBx||PAT||20040328112408||ADT^A01^ADT_A01|47|P|2.5|||AL|NE|DEU|8859/1|DEU^^HL70296||2.16.840.1.113883.2.6.9.1^^2.16.840.1.113883.2.6^ISO|";

	@Test
	public void testMessageParsingV23() throws Exception {
		final HL7Message message = new HL7Message(MSH_HEADER_23);
		assertNotEquals(message, null);
		assertEquals(message.getSegmentCount(),1);

		final MSHSegment segment = (MSHSegment) message.getSegment("MSH");
		assertNotEquals(segment, null);
		assertEquals(segment.getHL7FieldCount(),12);

		assertHl7Field(segment.getHL7Field(0), "MSH");

		assertEquals(segment.getEncodingCharacters(),"|^~\\&");
		assertHl7Field(segment.getHL7Field(1), "|^~\\&");

		assertEquals(segment.getSendingApplication(),"NES");
		assertHl7Field(segment.getHL7Field(2), "NES");
		
		assertEquals(segment.getSendingFacility(),"NINTENDO");
		assertHl7Field(segment.getHL7Field(3), "NINTENDO");

		assertEquals(segment.getReceivingApplication(),"TESTSYSTEM");
		assertHl7Field(segment.getHL7Field(4), "TESTSYSTEM");

		assertEquals(segment.getReceivingFacility(),"TESTFACILITY");
		assertHl7Field(segment.getHL7Field(5), "TESTFACILITY");
		
		assertEquals(segment.getDateTimeOfMessage().toString(),"2001-01-01T00:00");
		assertHl7Field(segment.getHL7Field(6), "20010101000000");

		assertEquals(segment.getSecurity(),"");
		assertHl7Field(segment.getHL7Field(7), "");

		assertEquals(segment.getMessageType(),"ADT^A04");
		assertHl7Field(segment.getHL7Field(8), "ADT^A04");

		assertEquals(segment.getMessageControlId(),"Q123456789T123456789X123456");
		assertHl7Field(segment.getHL7Field(9), "Q123456789T123456789X123456");

		assertEquals(segment.getProcessingId(),"P");
		assertHl7Field(segment.getHL7Field(10), "P");

		assertEquals(segment.getVersionId(),"2.3");
		assertHl7Field(segment.getHL7Field(11), "2.3");
	}

	@Test
	public void testMessageParsingV24() throws Exception {
		final HL7Message message = new HL7Message(MSH_HEADER_24);
		assertNotEquals(message, null);
		assertEquals(message.getSegmentCount(),1);

		final MSHSegment segment = (MSHSegment) message.getSegment("MSH");
		assertNotEquals(segment, null);
		assertEquals(segment.getHL7FieldCount(),12);

		assertHl7Field(segment.getHL7Field(0), "MSH");

		assertEquals(segment.getEncodingCharacters(),"|^~\\&");
		assertHl7Field(segment.getHL7Field(1), "|^~\\&");

		assertEquals(segment.getSendingApplication(),"GHH LAB");
		assertHl7Field(segment.getHL7Field(2), "GHH LAB");
		
		assertEquals(segment.getSendingFacility(),"ELAB-3");
		assertHl7Field(segment.getHL7Field(3), "ELAB-3");

		assertEquals(segment.getReceivingApplication(),"GHH OE");
		assertHl7Field(segment.getHL7Field(4), "GHH OE");

		assertEquals(segment.getReceivingFacility(),"BLDG4");
		assertHl7Field(segment.getHL7Field(5), "BLDG4");

		assertEquals(segment.getDateTimeOfMessage().toString(),"2002-02-15T09:30");
		assertHl7Field(segment.getHL7Field(6), "200202150930");

		assertEquals(segment.getSecurity(),"");
		assertHl7Field(segment.getHL7Field(7), "");

		assertEquals(segment.getMessageType(),"ORU^R01");
		assertHl7Field(segment.getHL7Field(8), "ORU^R01");

		assertEquals(segment.getMessageControlId(),"CNTRL-3456");
		assertHl7Field(segment.getHL7Field(9), "CNTRL-3456");

		assertEquals(segment.getProcessingId(),"P");
		assertHl7Field(segment.getHL7Field(10), "P");

		assertEquals(segment.getVersionId(),"2.4");
		assertHl7Field(segment.getHL7Field(11), "2.4");
	}
	
	@Test
	public void testMessageParsingV25() throws Exception {
		final HL7Message message = new HL7Message(MSH_HEADER_25);
		assertNotEquals(message, null);
		assertEquals(message.getSegmentCount(),1);

		final MSHSegment segment = (MSHSegment) message.getSegment("MSH");
		assertNotEquals(segment, null);
		assertEquals(segment.getHL7FieldCount(),21);

		int fieldValue = 0;
		assertHl7Field(segment.getHL7Field(fieldValue++), "MSH");

		assertEquals(segment.getEncodingCharacters(),"|^~\\&");
		assertHl7Field(segment.getHL7Field(fieldValue++), "|^~\\&");

		assertEquals(segment.getSendingApplication(),"SUBx");
		assertHl7Field(segment.getHL7Field(fieldValue++), "SUBx");
		
		assertEquals(segment.getSendingFacility(),"");
		assertHl7Field(segment.getHL7Field(fieldValue++), "");

		assertEquals(segment.getReceivingApplication(),"PAT");
		assertHl7Field(segment.getHL7Field(fieldValue++), "PAT");

		assertEquals(segment.getReceivingFacility(),"");
		assertHl7Field(segment.getHL7Field(fieldValue++), "");

		assertEquals(segment.getDateTimeOfMessage().toString(),"2004-03-28T11:24:08");
		assertHl7Field(segment.getHL7Field(fieldValue++), "20040328112408");

		assertEquals(segment.getSecurity(),"");
		assertHl7Field(segment.getHL7Field(fieldValue++), "");

		assertEquals(segment.getMessageType(),"ADT^A01^ADT_A01");
		assertHl7Field(segment.getHL7Field(fieldValue++), "ADT^A01^ADT_A01");

		assertEquals(segment.getMessageControlId(),"47");
		assertHl7Field(segment.getHL7Field(fieldValue++), "47");

		assertEquals(segment.getProcessingId(),"P");
		assertHl7Field(segment.getHL7Field(fieldValue++), "P");

		assertEquals(segment.getVersionId(),"2.5");
		assertHl7Field(segment.getHL7Field(fieldValue++), "2.5");

		assertEquals(segment.getSequenceNumber(), null);
		assertHl7Field(segment.getHL7Field(fieldValue++), "");
		
		assertEquals(segment.getContinuationPointer(),"");
		assertHl7Field(segment.getHL7Field(fieldValue++), "");
		
		assertEquals(segment.getAcceptAcknowledgmentType(),"AL");
		assertHl7Field(segment.getHL7Field(fieldValue++), "AL");
		
		assertEquals(segment.getApplicationAcknowledgmentType(),"NE");
		assertHl7Field(segment.getHL7Field(fieldValue++), "NE");
		
		assertEquals(segment.getCountryCode(),"DEU");
		assertHl7Field(segment.getHL7Field(fieldValue++), "DEU");
		
		assertEquals(segment.getCharacterSet(),"8859/1");
		assertHl7Field(segment.getHL7Field(fieldValue++), "8859/1");
		
		assertEquals(segment.getPrincipalLanguageOfMessage(),"DEU^^HL70296");
		assertHl7Field(segment.getHL7Field(fieldValue++), "DEU^^HL70296");
		
		assertHl7Field(segment.getHL7Field(fieldValue++), "");
		assertHl7Field(segment.getHL7Field(fieldValue++), "2.16.840.1.113883.2.6.9.1^^2.16.840.1.113883.2.6^ISO");
		assertHl7Field(segment.getHL7Field(fieldValue++), "");
	}
	
	private void assertHl7Field(final HL7Field hl7Field, final String expectedValue) {
		if (hl7Field != null) {
			assertEquals(hl7Field.getValue(),expectedValue);
		}
	}
}
