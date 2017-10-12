package com.sefah.hl7.message;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.sefah.hl7.exception.HL7MessageErrorCode;
import com.sefah.hl7.exception.HL7MessageException;
import com.sefah.hl7.message.components.HL7Segment;

public class HL7MessageTest {
	private static String msg = "MSH|^~\\&|NES|NINTENDO|TESTSYSTEM|TESTFACILITY|20010101000000||ADT^A04|Q123456789T123456789X123456|P|2.3\r"
			+ "EVN|A04|20010101000000|||^KOOPA^BOWSER^^^^^^^CURRENT\r"
			+ "PID|1||123456789|0123456789^AA^^JP|BROS^MARIO^^^^||19850101000000|M|||123 FAKE STREET^MARIO \\T\\ LUIGI BROS PLACE^TOADSTOOL KINGDOM^NES^A1B2C3^JP^HOME^^1234|1234|(555)555-0123^HOME^JP:1234567|||S|MSH|12345678|||||||0|||||N\r"
			+ "NK1|1|PEACH^PRINCESS^^^^|SO|ANOTHER CASTLE^^TOADSTOOL KINGDOM^NES^^JP|(123)555-1234|(123)555-2345|NOK|||||||||||||\r"
			+ "PV1|1|O|ABCD^EFGH^|||^^|123456^DINO^YOSHI^^^^^^MSRM^CURRENT^^^NEIGHBOURHOOD DR NBR^|^DOG^DUCKHUNT^^^^^^^CURRENT||CRD|||||||123456^DINO^YOSHI^^^^^^MSRM^CURRENT^^^NEIGHBOURHOOD DR NBR^|AO|0123456789|1|||||||||||||||||||MSH||A|||20010101000000\r";

	private static String HL7Message_Segment = "MSH|^~\\&|NES|NINTENDO|TESTSYSTEM|TESTFACILITY|20010101000000||ADT^A04|Q123456789T123456789X123456|P|2.3\r"
			+ "EVN|A04|20010101000000|||^KOOPA^BOWSER^^^^^^^CURRENT\r"
			+ "PID|1||123456789|0123456789^AA^^JP|BROS^MARIO^^^^||19850101000000|M|||123 FAKE STREET^MARIO \\T\\ LUIGI BROS PLACE^TOADSTOOL KINGDOM^NES^A1B2C3^JP^HOME^^1234|1234|(555)555-0123^HOME^JP:1234567|||S|MSH|12345678|||||||0|||||N\r"
			+ "NK1|1|PEACH^PRINCESS^^^^|SO|ANOTHER CASTLE^^TOADSTOOL KINGDOM^NES^^JP|(123)555-1234|(123)555-2345|NOK|||||||||||||\r"
			+ "NK1|2|TOADSTOOL^PRINCESS^^^^|SO|YET ANOTHER CASTLE^^TOADSTOOL KINGDOM^NES^^JP|(123)555-3456|(123)555-4567|EMC|||||||||||||\r"
			+ "PV1|1|O|ABCD^EFGH^|||^^|123456^DINO^YOSHI^^^^^^MSRM^CURRENT^^^NEIGHBOURHOOD DR NBR^|^DOG^DUCKHUNT^^^^^^^CURRENT||CRD|||||||123456^DINO^YOSHI^^^^^^MSRM^CURRENT^^^NEIGHBOURHOOD DR NBR^|AO|0123456789|1|||||||||||||||||||MSH||A|||20010101000000\r"
			+ "IN1|1|PAR^PARENT||||LUIGI\r" + "IN1|2|FRI^FRIEND||||PRINCESS";

	private static String segment_Complete = "EVN|A04|20010101000000|||Component1&SubComponent1^Component11~Component2&SubComponent2^Component22\r";

	private static String HL7Message_INVALID = "MSH|^~\\&|NES|NINTENDO|TESTSYSTEM|TESTFACILITY|20010101000000||ADT^A04|Q123456789T123456789X123456|P|2.3\n"
			+ "EVN|A04|20010101000000|||^KOOPA^BOWSER^^^^^^^CURRENT\r";
	private static String HL7Message_INVALID_1 = "MSH|^~\\&|NES|NINTENDO|TESTSYSTEM|TESTFACILITY|20010101000000||ADT^A04|Q123456789T123456789X123456|P|2.3\r\n"
			+ "EVN|A04|20010101000000|||^KOOPA^BOWSER^^^^^^^CURRENT\r";

	@Test
	public void testMessageParsing() throws Exception {
		final HL7Message message = new HL7Message(msg);
		assertThat(message, notNullValue());
		assertThat(message.getSegmentCount(), is(5));
		assertThat(message.getOriginalMessageText(), is(msg));

		HL7Segment segment = message.getSegment("MSH");
		assertThat(segment, notNullValue());
		assertThat(segment.getHL7FieldCount(), is(12));

		segment = message.getSegment("EVN");
		assertThat(segment, notNullValue());
		assertThat(segment.getHL7FieldCount(), is(6));

		segment = message.getSegment("PID");
		assertThat(segment, notNullValue());
		assertThat(segment.getHL7FieldCount(), is(31));

		segment = message.getSegment("NK1");
		assertThat(segment, notNullValue());
		assertThat(segment.getHL7FieldCount(), is(8));

		segment = message.getSegment("PV1");
		assertThat(segment, notNullValue());
		assertThat(segment.getHL7FieldCount(), is(45));
	}

	@Test
	public void testHL7MessageGetValue() throws Exception {
		final HL7Message message = new HL7Message(segment_Complete);
		assertThat(message, notNullValue());
		assertThat(message.getSegmentCount(), is(1));

		final HL7Segment segment = message.getSegment("EVN");
		assertThat(segment, notNullValue());
		assertThat(segment.getHL7FieldCount(), is(6));

		assertThat(segment.getHL7Value(5),
				is("Component1&SubComponent1^Component11~Component2&SubComponent2^Component22"));
		assertThat(segment.getHL7Value(5, 0), is("Component1&SubComponent1^Component11"));
		assertThat(segment.getHL7Value(5, 1), is("Component2&SubComponent2^Component22"));
		// erste Componente
		assertThat(segment.getHL7Value(5, 0, 0), is("Component1&SubComponent1"));
		assertThat(segment.getHL7Value(5, 1, 0), is("Component2&SubComponent2"));

		assertThat(segment.getHL7Value(5, 0, 0, 0), is("Component1"));
		assertThat(segment.getHL7Value(5, 0, 1, 0), is("Component11"));
		assertThat(segment.getHL7Value(5, 0, 0, 1), is("SubComponent1"));

		assertThat(segment.getHL7Value(5, 1, 0, 0), is("Component2"));
		assertThat(segment.getHL7Value(5, 1, 1, 0), is("Component22"));
		assertThat(segment.getHL7Value(5, 1, 0, 1), is("SubComponent2"));
	}

	@Test
	public void testHL7MessageMultipleSegments() throws Exception {
		final HL7Message message = new HL7Message(HL7Message_Segment);
		assertThat(message, notNullValue());
		assertThat(message.getSegmentCount(), is(8));

		final HL7Segment segment = message.getSegment("NK1");
		assertThat(segment, notNullValue());
		assertThat(segment.getHL7FieldCount(), is(8));

		final HL7Segment segmentNK11 = message.getSegment("NK1", 1);
		assertThat(segmentNK11, notNullValue());
		assertThat(segmentNK11, is(segment));

		final HL7Segment segmentNK12 = message.getSegment("NK1", 2);
		assertThat(segmentNK12, notNullValue());
		assertThat(segmentNK12, is(not(segment)));
		assertThat(segmentNK12, is(not(segmentNK11)));
	}

	@Test
	public void testInvalidMessageWindowsEncoding() throws Exception {
		try {
			new HL7Message(HL7Message_INVALID);
		} catch (final HL7MessageException e) {
			assertThat(e.getErrorCode(), is(HL7MessageErrorCode.HL7_MESSAGE_ENCODING.getCode()));
		}
	}

	@Test
	public void testInvalidMessageCombineEncoding() throws Exception {
		try {
			new HL7Message(HL7Message_INVALID_1);
		} catch (final HL7MessageException e) {
			assertThat(e.getErrorCode(), is(HL7MessageErrorCode.HL7_MESSAGE_ENCODING.getCode()));
		}
	}
}
