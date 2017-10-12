package com.sefah.hl7.message.datatypes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.sefah.hl7.message.components.HL7Encoding;
import com.sefah.hl7.message.components.HL7Repetition;

public class CXTest {

	@Test
	public void testName() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("12345^^^Alpha-Klinik^PI", new HL7Encoding());
		final CX cx = new CX(hl7Repetition);

		assertThat(cx.getAssigningAuthority(), is("Alpha-Klinik"));
		assertThat(cx.getAssigningFacility(), is(""));
		assertThat(cx.getCheckDigit(), is(""));
		assertThat(cx.getCheckDigitCodeScheme(), is(""));
		assertThat(cx.getId(), is("12345"));
		assertThat(cx.getIdentifierTypeCode(), is("PI"));
		assertThat(cx.getEffectiveDate(), is(""));
		assertThat(cx.getExpirationDate(), is(""));

	}

	@Test
	public void testName2() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("1234567^4^M11^ADT01^MR^University Hospital",
				new HL7Encoding());
		final CX cx = new CX(hl7Repetition);

		assertThat(cx.getAssigningAuthority(), is("ADT01"));
		assertThat(cx.getAssigningFacility(), is("University Hospital"));
		assertThat(cx.getCheckDigit(), is("4"));
		assertThat(cx.getCheckDigitCodeScheme(), is("M11"));
		assertThat(cx.getId(), is("1234567"));
		assertThat(cx.getIdentifierTypeCode(), is("MR"));
		assertThat(cx.getEffectiveDate(), is(""));
		assertThat(cx.getExpirationDate(), is(""));

	}
}
