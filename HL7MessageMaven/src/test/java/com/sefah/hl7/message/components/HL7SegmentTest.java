package com.sefah.hl7.message.components;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class HL7SegmentTest {

	@Test
	public void testParsingSegmentValue() throws Exception {
		final HL7Segment seg = new HL7Segment("EVN|A04|20010101000000|||^KOOPA^BOWSER^^^^^^^CURRENT", new HL7Encoding());
		assertEquals(seg.getHL7FieldCount(), 6);
		assertEquals(seg.getHl7SegmentValue(), "EVN|A04|20010101000000|||^KOOPA^BOWSER^^^^^^^CURRENT");

		assertNotEquals(seg.getHL7Field(0), null);
		assertNotEquals(seg.getHL7Field(1), null);
		assertNotEquals(seg.getHL7Field(2), null);
		assertNotEquals(seg.getHL7Field(3), null);
		assertNotEquals(seg.getHL7Field(4), null);
		assertNotEquals(seg.getHL7Field(5), null);
		assertNotEquals(seg.getHL7Field(6), null);

		assertEquals(seg.getHL7Value(-1), "EVN|A04|20010101000000|||^KOOPA^BOWSER^^^^^^^CURRENT");
		assertEquals(seg.getHL7Value(0), "EVN");
		assertEquals(seg.getHL7Value(1), "A04");
		assertEquals(seg.getHL7Value(2), "20010101000000");
		assertEquals(seg.getHL7Value(3), "");
		assertEquals(seg.getHL7Value(4), "");
		assertEquals(seg.getHL7Value(5), "^KOOPA^BOWSER^^^^^^^CURRENT");
		assertEquals(seg.getHL7Value(6), "EVN|A04|20010101000000|||^KOOPA^BOWSER^^^^^^^CURRENT");
	}

	@Test
	public void testParsingMSHSegmentValue() throws Exception {
		final HL7Segment seg = new HL7Segment(
				"MSH|^~\\&|NES|NINTENDO|TESTSYSTEM|TESTFACILITY|20010101000000||ADT^A04|Q123456789T123456789X123456|P|2.3",
				new HL7Encoding());
		assertEquals(seg.getHL7FieldCount(), 12);
		assertEquals(seg.getHl7SegmentValue(), 
				"MSH|^~\\&|NES|NINTENDO|TESTSYSTEM|TESTFACILITY|20010101000000||ADT^A04|Q123456789T123456789X123456|P|2.3");

		assertEquals(seg.getHL7Value(-1), 
				"MSH|^~\\&|NES|NINTENDO|TESTSYSTEM|TESTFACILITY|20010101000000||ADT^A04|Q123456789T123456789X123456|P|2.3");
		assertEquals(seg.getHL7Value(0), "MSH");
		assertEquals(seg.getHL7Value(1), "|^~\\&");
		assertEquals(seg.getHL7Value(2), "NES");
		assertEquals(seg.getHL7Value(3), "NINTENDO");
		assertEquals(seg.getHL7Value(4), "TESTSYSTEM");
		assertEquals(seg.getHL7Value(5), "TESTFACILITY");
		assertEquals(seg.getHL7Value(6), "20010101000000");
		assertEquals(seg.getHL7Value(7), "");
		assertEquals(seg.getHL7Value(8), "ADT^A04");
		assertEquals(seg.getHL7Value(9), "Q123456789T123456789X123456");
		assertEquals(seg.getHL7Value(10), "P");
		assertEquals(seg.getHL7Value(11), "2.3");
		assertEquals(seg.getHL7Value(12), 
				"MSH|^~\\&|NES|NINTENDO|TESTSYSTEM|TESTFACILITY|20010101000000||ADT^A04|Q123456789T123456789X123456|P|2.3");

	}
}
