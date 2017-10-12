package com.sefah.hl7.message.datatypes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.sefah.hl7.message.components.HL7Encoding;
import com.sefah.hl7.message.components.HL7Repetition;

public class XONTest {

	@Test
	public void testName() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition(
				"Fairview Hospital^L^716^9^M10^&Hospital Master.University Hositals&L^XX^&Central Offices.University Hospitals&L^A",
				new HL7Encoding());
		final XON cx = new XON(hl7Repetition);

		assertThat(cx.getAssigningAuthority(), is("&Hospital Master.University Hositals&L"));
		assertThat(cx.getAssigningFacilityId(), is("&Central Offices.University Hospitals&L"));
		assertThat(cx.getCheckDigit(), is("9"));
		assertThat(cx.getCodeIdentifyingTheCheckDigitSchemeEmployed(), is("M10"));
		assertThat(cx.getIdentifierTypeCode(), is("XX"));
		assertThat(cx.getIdNumber(), is("716"));
		assertThat(cx.getNameRepresentationCode(), is("A"));
		assertThat(cx.getOrganizationName(), is("Fairview Hospital"));
		assertThat(cx.getOrganizationNameTypeCode(), is("L"));

	}

	@Test
	public void testName2() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("Fairview Hospital^L^4544^3^M10^HCFA^XX^^A",
				new HL7Encoding());
		final XON cx = new XON(hl7Repetition);

		assertThat(cx.getAssigningAuthority(), is("HCFA"));
		assertThat(cx.getAssigningFacilityId(), is(""));
		assertThat(cx.getCheckDigit(), is("3"));
		assertThat(cx.getCodeIdentifyingTheCheckDigitSchemeEmployed(), is("M10"));
		assertThat(cx.getIdentifierTypeCode(), is("XX"));
		assertThat(cx.getIdNumber(), is("4544"));
		assertThat(cx.getNameRepresentationCode(), is("A"));
		assertThat(cx.getOrganizationName(), is("Fairview Hospital"));
		assertThat(cx.getOrganizationNameTypeCode(), is("L"));

	}

}
