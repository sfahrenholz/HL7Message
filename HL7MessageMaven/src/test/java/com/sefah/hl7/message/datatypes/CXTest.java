package com.sefah.hl7.message.datatypes;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.sefah.hl7.message.components.HL7Encoding;
import com.sefah.hl7.message.components.HL7Repetition;

public class CXTest {

	@Test
	public void testName() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("12345^^^Alpha-Klinik^PI", new HL7Encoding());
		final CX cx = new CX(hl7Repetition);

		assertEquals(cx.getAssigningAuthority(),"Alpha-Klinik");
		assertEquals(cx.getAssigningFacility(),"");
		assertEquals(cx.getCheckDigit(),"");
		assertEquals(cx.getCheckDigitCodeScheme(),"");
		assertEquals(cx.getId(),"12345");
		assertEquals(cx.getIdentifierTypeCode(),"PI");
		assertEquals(cx.getEffectiveDate(),"");
		assertEquals(cx.getExpirationDate(),"");

	}

	@Test
	public void testName2() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("1234567^4^M11^ADT01^MR^University Hospital",
				new HL7Encoding());
		final CX cx = new CX(hl7Repetition);

		assertEquals(cx.getAssigningAuthority(),"ADT01");
		assertEquals(cx.getAssigningFacility(),"University Hospital");
		assertEquals(cx.getCheckDigit(),"4");
		assertEquals(cx.getCheckDigitCodeScheme(),"M11");
		assertEquals(cx.getId(),"1234567");
		assertEquals(cx.getIdentifierTypeCode(),"MR");
		assertEquals(cx.getEffectiveDate(),"");
		assertEquals(cx.getExpirationDate(),"");

	}
}
