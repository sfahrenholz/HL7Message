package com.sefah.hl7.message.components;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class HL7FieldTest {

	@Test
	public void testInitWithoutRepetition() throws Exception {
		final HL7Field field = new HL7Field("field", new HL7Encoding());
		assertEquals(field.getHL7RepetitionCount(),1);
		assertEquals(field.getValue(),"field");

		assertEquals(field.getHL7Repetition(-1),null);
		assertNotEquals(field.getHL7Repetition(0), null);
		assertEquals(field.getHL7Repetition(1),null);
		assertEquals(field.getHL7RepetitionValue(-1),"");
		assertEquals(field.getHL7RepetitionValue(0),"field");
		assertEquals(field.getHL7RepetitionValue(1),"");
	}

	@Test
	public void testInitWithRepetition() throws Exception {
		final HL7Field field = new HL7Field("field1~field2~field3", new HL7Encoding());
		assertEquals(field.getHL7RepetitionCount(),3);
		assertEquals(field.getValue(),"field1~field2~field3");

		assertEquals(field.getHL7Repetition(-1),null);
		assertNotEquals(field.getHL7Repetition(0), null);
		assertNotEquals(field.getHL7Repetition(1), null);
		assertNotEquals(field.getHL7Repetition(2), null);
		assertEquals(field.getHL7Repetition(3),null);

		assertEquals(field.getHL7RepetitionValue(-1),"");
		assertEquals(field.getHL7RepetitionValue(0),"field1");
		assertEquals(field.getHL7RepetitionValue(1),"field2");
		assertEquals(field.getHL7RepetitionValue(2),"field3");
		assertEquals(field.getHL7RepetitionValue(3),"");
	}

	@Test
	public void testInitWithRepetitionComponentSubComponent() throws Exception {
		final HL7Field field = new HL7Field("field1~field2^Comp2&SubComp2~field3", new HL7Encoding());
		assertEquals(field.getHL7RepetitionCount(),3);
		assertEquals(field.getValue(),"field1~field2^Comp2&SubComp2~field3");

		assertEquals(field.getHL7Repetition(-1),null);
		assertNotEquals(field.getHL7Repetition(0), null);
		assertNotEquals(field.getHL7Repetition(1), null);
		assertNotEquals(field.getHL7Repetition(2), null);
		assertEquals(field.getHL7Repetition(3),null);

		assertEquals(field.getHL7RepetitionValue(-1),"");
		assertEquals(field.getHL7RepetitionValue(0),"field1");
		assertEquals(field.getHL7RepetitionValue(1),"field2^Comp2&SubComp2");
		assertEquals(field.getHL7RepetitionValue(2),"field3");
		assertEquals(field.getHL7RepetitionValue(3),"");
	}
}
