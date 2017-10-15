package com.sefah.hl7.message.components;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class HL7RepetitionTest {

	@Test
	public void testInitWithoutComponents() throws Exception {
		final HL7Repetition rep = new HL7Repetition("comp1", new HL7Encoding());
		assertEquals(rep.getHL7ComponentCount(),1);
		assertEquals(rep.getHL7RepetitionValue(),"comp1");

		assertEquals(rep.getHL7Component(-1), null);
		assertNotEquals(rep.getHL7Component(0), null);
		assertEquals(rep.getHL7Component(1), null);
		assertEquals(rep.getHL7ComponentValue(-1),"");
		assertEquals(rep.getHL7ComponentValue(0),"comp1");
		assertEquals(rep.getHL7ComponentValue(1),"");
	}

	@Test
	public void testInitWithComponents() throws Exception {
		final HL7Repetition rep = new HL7Repetition("comp1^comp2^comp3", new HL7Encoding());
		assertEquals(rep.getHL7ComponentCount(),3);
		assertEquals(rep.getHL7RepetitionValue(),"comp1^comp2^comp3");

		assertEquals(rep.getHL7Component(-1), null);
		assertNotEquals(rep.getHL7Component(0), null);
		assertNotEquals(rep.getHL7Component(1), null);
		assertNotEquals(rep.getHL7Component(2), null);
		assertEquals(rep.getHL7Component(3), null);
		assertEquals(rep.getHL7ComponentValue(-1),"");
		assertEquals(rep.getHL7ComponentValue(0),"comp1");
		assertEquals(rep.getHL7ComponentValue(1),"comp2");
		assertEquals(rep.getHL7ComponentValue(2),"comp3");
		assertEquals(rep.getHL7ComponentValue(3),"");
	}

	@Test
	public void testInitWithComponentsSubComponents() throws Exception {
		final HL7Repetition rep = new HL7Repetition("comp1^comp2&SubComp2^comp3", new HL7Encoding());
		assertEquals(rep.getHL7ComponentCount(),3);
		assertEquals(rep.getHL7RepetitionValue(),"comp1^comp2&SubComp2^comp3");

		assertEquals(rep.getHL7Component(-1), null);
		assertNotEquals(rep.getHL7Component(0), null);
		assertNotEquals(rep.getHL7Component(1), null);
		assertNotEquals(rep.getHL7Component(2), null);
		assertEquals(rep.getHL7Component(3), null);
		assertEquals(rep.getHL7ComponentValue(-1),"");
		assertEquals(rep.getHL7ComponentValue(0),"comp1");
		assertEquals(rep.getHL7ComponentValue(1),"comp2&SubComp2");
		assertEquals(rep.getHL7ComponentValue(2),"comp3");
		assertEquals(rep.getHL7ComponentValue(3),"");
	}

}
