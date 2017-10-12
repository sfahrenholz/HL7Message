package com.sefah.hl7.message.datatypes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.sefah.hl7.message.components.HL7Encoding;
import com.sefah.hl7.message.components.HL7Repetition;

public class XCNTest {

	@Test
	public void testName() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("1234567^Smith^John^J^III^DR^PHD^ADT01^^L^4^M11^MR",
				new HL7Encoding());
		final XCN cx = new XCN(hl7Repetition);

		assertThat(cx.getAssigningAuthority(), is(""));
		assertThat(cx.getAssigningFacility(), is(""));
		assertThat(cx.getCheckDigit(), is("4"));
		assertThat(cx.getCheckDigitCodeScheme(), is("M11"));
		assertThat(cx.getDegree(), is("PHD"));
		assertThat(cx.getFamilyName(), is("Smith"));
		assertThat(cx.getGivenName(), is("John"));
		assertThat(cx.getId(), is("1234567"));
		assertThat(cx.getIdentifierTypeCode(), is("MR"));
		assertThat(cx.getMiddleName(), is("J"));
		assertThat(cx.getNameRepresentationCode(), is(""));
		assertThat(cx.getNameTypeCode(), is("L"));
		assertThat(cx.getPrefix(), is("DR"));
		assertThat(cx.getSourceTable(), is("ADT01"));
		assertThat(cx.getSuffix(), is("III"));
		assertThat(cx.getNameContext(), is(""));
		assertThat(cx.getNameValidityRange(), is(""));
		assertThat(cx.getNameAssemblyOorder(), is(""));

	}

	@Test
	public void testName1() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition(
				"2188^Semmelweiss^Samuel^S^IV^Dr^MD^^&Provider Master.University Hospitals&L^L^9^M10^DN^&Fairview Hospital.University Hospitals&L^A ",
				new HL7Encoding());
		final XCN cx = new XCN(hl7Repetition);

		assertThat(cx.getAssigningAuthority(), is("&Provider Master.University Hospitals&L"));
		assertThat(cx.getAssigningFacility(), is("&Fairview Hospital.University Hospitals&L"));
		assertThat(cx.getCheckDigit(), is("9"));
		assertThat(cx.getCheckDigitCodeScheme(), is("M10"));
		assertThat(cx.getDegree(), is("MD"));
		assertThat(cx.getFamilyName(), is("Semmelweiss"));
		assertThat(cx.getGivenName(), is("Samuel"));
		assertThat(cx.getId(), is("2188"));
		assertThat(cx.getIdentifierTypeCode(), is("DN"));
		assertThat(cx.getMiddleName(), is("S"));
		assertThat(cx.getNameRepresentationCode(), is("A "));
		assertThat(cx.getNameTypeCode(), is("L"));
		assertThat(cx.getPrefix(), is("Dr"));
		assertThat(cx.getSourceTable(), is(""));
		assertThat(cx.getSuffix(), is("IV"));
		assertThat(cx.getNameContext(), is(""));
		assertThat(cx.getNameValidityRange(), is(""));
		assertThat(cx.getNameAssemblyOorder(), is(""));
	}

	@Test
	public void testName2() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition(
				"10535^van Beethoven&van^Ludwig^A^III^Dr^PHD^^&MPI.University Hospitals&L^L^3^M10^MR^&Fairview Hospital.University Hospitals&L^A",
				new HL7Encoding());
		final XCN cx = new XCN(hl7Repetition);

		assertThat(cx.getAssigningAuthority(), is("&MPI.University Hospitals&L"));
		assertThat(cx.getAssigningFacility(), is("&Fairview Hospital.University Hospitals&L"));
		assertThat(cx.getCheckDigit(), is("3"));
		assertThat(cx.getCheckDigitCodeScheme(), is("M10"));
		assertThat(cx.getDegree(), is("PHD"));
		assertThat(cx.getFamilyName(), is("van Beethoven&van"));
		assertThat(cx.getGivenName(), is("Ludwig"));
		assertThat(cx.getId(), is("10535"));
		assertThat(cx.getIdentifierTypeCode(), is("MR"));
		assertThat(cx.getMiddleName(), is("A"));
		assertThat(cx.getNameRepresentationCode(), is("A"));
		assertThat(cx.getNameTypeCode(), is("L"));
		assertThat(cx.getPrefix(), is("Dr"));
		assertThat(cx.getSourceTable(), is(""));
		assertThat(cx.getSuffix(), is("III"));
		assertThat(cx.getNameContext(), is(""));
		assertThat(cx.getNameValidityRange(), is(""));
		assertThat(cx.getNameAssemblyOorder(), is(""));
	}
}
