package com.sefah.hl7.message;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

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
		assertNotEquals(message, null);
		assertEquals(message.getSegmentCount(),5);
		assertEquals(message.getOriginalMessageText(),msg);

		HL7Segment segment = message.getSegment("MSH");
		assertNotEquals(segment, null);
		assertEquals(segment.getHL7FieldCount(),12);

		segment = message.getSegment("EVN");
		assertNotEquals(segment, null);
		assertEquals(segment.getHL7FieldCount(),6);

		segment = message.getSegment("PID");
		assertNotEquals(segment, null);
		assertEquals(segment.getHL7FieldCount(),31);

		segment = message.getSegment("NK1");
		assertNotEquals(segment, null);
		assertEquals(segment.getHL7FieldCount(),8);

		segment = message.getSegment("PV1");
		assertNotEquals(segment, null);
		assertEquals(segment.getHL7FieldCount(),45);
	}

	@Test
	public void testHL7MessageGetValue() throws Exception {
		final HL7Message message = new HL7Message(segment_Complete);
		assertNotEquals(message, null);
		assertEquals(message.getSegmentCount(),1);

		final HL7Segment segment = message.getSegment("EVN");
		assertNotEquals(segment, null);
		assertEquals(segment.getHL7FieldCount(),6);

		assertEquals(segment.getHL7Value(5),
				"Component1&SubComponent1^Component11~Component2&SubComponent2^Component22");
		assertEquals(segment.getHL7Value(5, 0),"Component1&SubComponent1^Component11");
		assertEquals(segment.getHL7Value(5, 1),"Component2&SubComponent2^Component22");
		// erste Componente
		assertEquals(segment.getHL7Value(5, 0, 0),"Component1&SubComponent1");
		assertEquals(segment.getHL7Value(5, 1, 0),"Component2&SubComponent2");

		assertEquals(segment.getHL7Value(5, 0, 0, 0),"Component1");
		assertEquals(segment.getHL7Value(5, 0, 1, 0),"Component11");
		assertEquals(segment.getHL7Value(5, 0, 0, 1),"SubComponent1");

		assertEquals(segment.getHL7Value(5, 1, 0, 0),"Component2");
		assertEquals(segment.getHL7Value(5, 1, 1, 0),"Component22");
		assertEquals(segment.getHL7Value(5, 1, 0, 1),"SubComponent2");
	}

	@Test
	public void testHL7MessageMultipleSegments() throws Exception {
		final HL7Message message = new HL7Message(HL7Message_Segment);
		assertNotEquals(message, null);
		assertEquals(message.getSegmentCount(),8);

		final HL7Segment segment = message.getSegment("NK1");
		assertNotEquals(segment, null);
		assertEquals(segment.getHL7FieldCount(),8);

		final HL7Segment segmentNK11 = message.getSegment("NK1", 1);
		assertNotEquals(segmentNK11, null);
		assertEquals(segmentNK11,segment);

		final HL7Segment segmentNK12 = message.getSegment("NK1", 2);
		assertNotEquals(segmentNK12, null);
		assertNotEquals(segmentNK12,segment);
		assertNotEquals(segmentNK12,segmentNK11);
	}

	@Test
	public void testInvalidMessageWindowsEncoding() throws Exception {
		try {
			new HL7Message(HL7Message_INVALID);
		} catch (final HL7MessageException e) {
			assertEquals(e.getErrorCode(),HL7MessageErrorCode.HL7_MESSAGE_ENCODING.getCode());
		}
	}

	@Test
	public void testInvalidMessageCombineEncoding() throws Exception {
		try {
			new HL7Message(HL7Message_INVALID_1);
		} catch (final HL7MessageException e) {
			assertEquals(e.getErrorCode(),HL7MessageErrorCode.HL7_MESSAGE_ENCODING.getCode());
		}
	}
}
