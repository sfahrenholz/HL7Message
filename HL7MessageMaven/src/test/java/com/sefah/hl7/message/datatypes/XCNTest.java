package com.sefah.hl7.message.datatypes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.sefah.hl7.message.components.HL7Encoding;
import com.sefah.hl7.message.components.HL7Repetition;

public class XCNTest {

	@Test
	public void testName() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("1234567^Smith^John^J^III^DR^PHD^ADT01^^L^4^M11^MR",
				new HL7Encoding());
		final XCN cx = new XCN(hl7Repetition);

		assertEquals(cx.getAssigningAuthority(), "");
		assertEquals(cx.getAssigningFacility(), "");
		assertEquals(cx.getCheckDigit(), "4");
		assertEquals(cx.getCheckDigitCodeScheme(), "M11");
		assertEquals(cx.getDegree(), "PHD");
		assertEquals(cx.getFamilyName(), "Smith");
		assertEquals(cx.getGivenName(), "John");
		assertEquals(cx.getId(), "1234567");
		assertEquals(cx.getIdentifierTypeCode(), "MR");
		assertEquals(cx.getMiddleName(), "J");
		assertEquals(cx.getNameRepresentationCode(), "");
		assertEquals(cx.getNameTypeCode(), "L");
		assertEquals(cx.getPrefix(), "DR");
		assertEquals(cx.getSourceTable(), "ADT01");
		assertEquals(cx.getSuffix(), "III");
		assertEquals(cx.getNameContext(), "");
		assertEquals(cx.getNameValidityRange(), "");
		assertEquals(cx.getNameAssemblyOorder(), "");

	}

	@Test
	public void testName1() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition(
				"2188^Semmelweiss^Samuel^S^IV^Dr^MD^^&Provider Master.University Hospitals&L^L^9^M10^DN^&Fairview Hospital.University Hospitals&L^A ",
				new HL7Encoding());
		final XCN cx = new XCN(hl7Repetition);

		assertEquals(cx.getAssigningAuthority(), "&Provider Master.University Hospitals&L");
		assertEquals(cx.getAssigningFacility(), "&Fairview Hospital.University Hospitals&L");
		assertEquals(cx.getCheckDigit(), "9");
		assertEquals(cx.getCheckDigitCodeScheme(), "M10");
		assertEquals(cx.getDegree(), "MD");
		assertEquals(cx.getFamilyName(), "Semmelweiss");
		assertEquals(cx.getGivenName(), "Samuel");
		assertEquals(cx.getId(), "2188");
		assertEquals(cx.getIdentifierTypeCode(), "DN");
		assertEquals(cx.getMiddleName(), "S");
		assertEquals(cx.getNameRepresentationCode(), "A ");
		assertEquals(cx.getNameTypeCode(), "L");
		assertEquals(cx.getPrefix(), "Dr");
		assertEquals(cx.getSourceTable(), "");
		assertEquals(cx.getSuffix(), "IV");
		assertEquals(cx.getNameContext(), "");
		assertEquals(cx.getNameValidityRange(), "");
		assertEquals(cx.getNameAssemblyOorder(), "");
	}

	@Test
	public void testName2() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition(
				"10535^van Beethoven&van^Ludwig^A^III^Dr^PHD^^&MPI.University Hospitals&L^L^3^M10^MR^&Fairview Hospital.University Hospitals&L^A",
				new HL7Encoding());
		final XCN cx = new XCN(hl7Repetition);

		assertEquals(cx.getAssigningAuthority(), "&MPI.University Hospitals&L");
		assertEquals(cx.getAssigningFacility(), "&Fairview Hospital.University Hospitals&L");
		assertEquals(cx.getCheckDigit(), "3");
		assertEquals(cx.getCheckDigitCodeScheme(), "M10");
		assertEquals(cx.getDegree(), "PHD");
		assertEquals(cx.getFamilyName(), "van Beethoven&van");
		assertEquals(cx.getGivenName(), "Ludwig");
		assertEquals(cx.getId(), "10535");
		assertEquals(cx.getIdentifierTypeCode(), "MR");
		assertEquals(cx.getMiddleName(), "A");
		assertEquals(cx.getNameRepresentationCode(), "A");
		assertEquals(cx.getNameTypeCode(), "L");
		assertEquals(cx.getPrefix(), "Dr");
		assertEquals(cx.getSourceTable(), "");
		assertEquals(cx.getSuffix(), "III");
		assertEquals(cx.getNameContext(), "");
		assertEquals(cx.getNameValidityRange(), "");
		assertEquals(cx.getNameAssemblyOorder(), "");
	}
}
