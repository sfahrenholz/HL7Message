package com.sefah.hl7.message.datatypes;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.sefah.hl7.message.components.HL7Encoding;
import com.sefah.hl7.message.components.HL7Repetition;

public class CETest {

	@Test
	public void testName() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("2148-5^Creatinine^LN^F-11380^^I9^", new HL7Encoding());
		final CE ce = new CE(hl7Repetition);

		assertEquals(ce.getAlternateIdentifier(),"F-11380");
		assertEquals(ce.getAlternateText(),"");
		assertEquals(ce.getAlternativeCodingSystem(),"I9");
		assertEquals(ce.getCodingSystem(),"LN");
		assertEquals(ce.getIdentifier(),"2148-5");
		assertEquals(ce.getText(),"Creatinine");
	}
}
