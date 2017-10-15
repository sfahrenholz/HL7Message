package com.sefah.hl7.message.datatypes;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.sefah.hl7.message.components.HL7Encoding;
import com.sefah.hl7.message.components.HL7Repetition;

public class XONTest {

	@Test
	public void testName() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition(
				"Fairview Hospital^L^716^9^M10^&Hospital Master.University Hositals&L^XX^&Central Offices.University Hospitals&L^A",
				new HL7Encoding());
		final XON cx = new XON(hl7Repetition);

		assertEquals(cx.getAssigningAuthority(), "&Hospital Master.University Hositals&L");
		assertEquals(cx.getAssigningFacilityId(), "&Central Offices.University Hospitals&L");
		assertEquals(cx.getCheckDigit(), "9");
		assertEquals(cx.getCodeIdentifyingTheCheckDigitSchemeEmployed(), "M10");
		assertEquals(cx.getIdentifierTypeCode(), "XX");
		assertEquals(cx.getIdNumber(), "716");
		assertEquals(cx.getNameRepresentationCode(), "A");
		assertEquals(cx.getOrganizationName(), "Fairview Hospital");
		assertEquals(cx.getOrganizationNameTypeCode(), "L");

	}

	@Test
	public void testName2() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("Fairview Hospital^L^4544^3^M10^HCFA^XX^^A",
				new HL7Encoding());
		final XON cx = new XON(hl7Repetition);

		assertEquals(cx.getAssigningAuthority(), "HCFA");
		assertEquals(cx.getAssigningFacilityId(), "");
		assertEquals(cx.getCheckDigit(), "3");
		assertEquals(cx.getCodeIdentifyingTheCheckDigitSchemeEmployed(), "M10");
		assertEquals(cx.getIdentifierTypeCode(), "XX");
		assertEquals(cx.getIdNumber(), "4544");
		assertEquals(cx.getNameRepresentationCode(), "A");
		assertEquals(cx.getOrganizationName(), "Fairview Hospital");
		assertEquals(cx.getOrganizationNameTypeCode(), "L");

	}

}
