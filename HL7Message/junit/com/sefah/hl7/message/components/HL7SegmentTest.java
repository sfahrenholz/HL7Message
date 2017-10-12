package com.sefah.hl7.message.components;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

public class HL7SegmentTest {

	static HL7Encoding encoding;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		encoding = new HL7Encoding();
	}

	@Test
	public void testParsingSegmentValue() throws Exception {
		final HL7Segment seg = new HL7Segment("EVN|A04|20010101000000|||^KOOPA^BOWSER^^^^^^^CURRENT", encoding);
		assertThat(seg.getHL7FieldCount(), is(6));
		assertThat(seg.getHl7SegmentValue(), is("EVN|A04|20010101000000|||^KOOPA^BOWSER^^^^^^^CURRENT"));

		assertThat(seg.getHL7Field(0), notNullValue());
		assertThat(seg.getHL7Field(1), notNullValue());
		assertThat(seg.getHL7Field(2), notNullValue());
		assertThat(seg.getHL7Field(3), notNullValue());
		assertThat(seg.getHL7Field(4), notNullValue());
		assertThat(seg.getHL7Field(5), notNullValue());
		assertThat(seg.getHL7Field(6), notNullValue());

		assertThat(seg.getHL7Value(-1), is("EVN|A04|20010101000000|||^KOOPA^BOWSER^^^^^^^CURRENT"));
		assertThat(seg.getHL7Value(0), is("EVN"));
		assertThat(seg.getHL7Value(1), is("A04"));
		assertThat(seg.getHL7Value(2), is("20010101000000"));
		assertThat(seg.getHL7Value(3), is(""));
		assertThat(seg.getHL7Value(4), is(""));
		assertThat(seg.getHL7Value(5), is("^KOOPA^BOWSER^^^^^^^CURRENT"));
		assertThat(seg.getHL7Value(6), is("EVN|A04|20010101000000|||^KOOPA^BOWSER^^^^^^^CURRENT"));
	}

	@Test
	public void testParsingMSHSegmentValue() throws Exception {
		final HL7Segment seg = new HL7Segment(
				"MSH|^~\\&|NES|NINTENDO|TESTSYSTEM|TESTFACILITY|20010101000000||ADT^A04|Q123456789T123456789X123456|P|2.3",
				encoding);
		assertThat(seg.getHL7FieldCount(), is(12));
		assertThat(seg.getHl7SegmentValue(), is(
				"MSH|^~\\&|NES|NINTENDO|TESTSYSTEM|TESTFACILITY|20010101000000||ADT^A04|Q123456789T123456789X123456|P|2.3"));

		assertThat(seg.getHL7Field(0), notNullValue());
		assertThat(seg.getHL7Field(1), notNullValue());
		assertThat(seg.getHL7Field(2), notNullValue());
		assertThat(seg.getHL7Field(3), notNullValue());
		assertThat(seg.getHL7Field(4), notNullValue());
		assertThat(seg.getHL7Field(5), notNullValue());
		assertThat(seg.getHL7Field(6), notNullValue());
		assertThat(seg.getHL7Field(7), notNullValue());
		assertThat(seg.getHL7Field(8), notNullValue());
		assertThat(seg.getHL7Field(9), notNullValue());
		assertThat(seg.getHL7Field(10), notNullValue());
		assertThat(seg.getHL7Field(11), notNullValue());
		assertThat(seg.getHL7Field(12), notNullValue());

		assertThat(seg.getHL7Value(-1), is(
				"MSH|^~\\&|NES|NINTENDO|TESTSYSTEM|TESTFACILITY|20010101000000||ADT^A04|Q123456789T123456789X123456|P|2.3"));
		assertThat(seg.getHL7Value(0), is("MSH"));
		assertThat(seg.getHL7Value(1), is("|^~\\&"));
		assertThat(seg.getHL7Value(2), is("NES"));
		assertThat(seg.getHL7Value(3), is("NINTENDO"));
		assertThat(seg.getHL7Value(4), is("TESTSYSTEM"));
		assertThat(seg.getHL7Value(5), is("TESTFACILITY"));
		assertThat(seg.getHL7Value(6), is("20010101000000"));
		assertThat(seg.getHL7Value(7), is(""));
		assertThat(seg.getHL7Value(8), is("ADT^A04"));
		assertThat(seg.getHL7Value(9), is("Q123456789T123456789X123456"));
		assertThat(seg.getHL7Value(10), is("P"));
		assertThat(seg.getHL7Value(11), is("2.3"));
		assertThat(seg.getHL7Value(12), is(
				"MSH|^~\\&|NES|NINTENDO|TESTSYSTEM|TESTFACILITY|20010101000000||ADT^A04|Q123456789T123456789X123456|P|2.3"));

	}
}
