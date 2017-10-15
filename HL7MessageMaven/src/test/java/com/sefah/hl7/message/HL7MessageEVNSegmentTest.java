package com.sefah.hl7.message;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.sefah.hl7.message.components.HL7Field;
import com.sefah.hl7.message.components.HL7Segment;

public class HL7MessageEVNSegmentTest {

	private static String msg = "EVN|A04|20010101000000|||^KOOPA^BOWSER^^^^^^^CURRENT\r";

	@Test
	public void testMessageParsing() throws Exception {
		final HL7Message message = new HL7Message(msg);
		assertNotEquals(message, null);
		assertEquals(message.getSegmentCount(),1);

		final HL7Segment segment = message.getSegment("EVN");
		assertNotEquals(segment, null);
		assertEquals(segment.getHL7FieldCount(),6);

		assertHl7Field(segment.getHL7Field(0), "EVN");
		assertHl7Field(segment.getHL7Field(1), "A04");
		assertHl7Field(segment.getHL7Field(2), "20010101000000");
		assertHl7Field(segment.getHL7Field(3), "");
		assertHl7Field(segment.getHL7Field(4), "");
		assertHl7Field(segment.getHL7Field(5), "^KOOPA^BOWSER^^^^^^^CURRENT");
	}

	private void assertHl7Field(final HL7Field hl7Field, final String expectedValue) {
		assertEquals(hl7Field.getValue(),expectedValue);
	}
}
