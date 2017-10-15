package com.sefah.hl7.message.datatypes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.sefah.hl7.message.components.HL7Encoding;
import com.sefah.hl7.message.components.HL7Repetition;

public class XPNTest {

	@Test
	public void testXPNExample1() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("Meier^Otto^^^^^L^A^^^G", new HL7Encoding());
		final XPN xpn = new XPN(hl7Repetition);

		assertEquals(xpn.getFamilyName(), "Meier");
		assertEquals(xpn.getGivenName(), "Otto");
		assertEquals(xpn.getMiddleName(), "");
		assertEquals(xpn.getNameRepresentationCode(), "A");
		assertEquals(xpn.getNameTypeCode(), "L");
		assertEquals(xpn.getPrefix(), "");
		assertEquals(xpn.getSuffix(), "");
		assertEquals(xpn.getDegree(), "");
		assertEquals(xpn.getEffectiveDate(), "");
		assertEquals(xpn.getExpirationDate(), "");
		assertEquals(xpn.getNameAssemblyOrder(), "G");
		assertEquals(xpn.getNameContext(), "");
		assertEquals(xpn.getNameValidityRange(), "");
		assertEquals(xpn.getProfessionalSuffix(), "");

		assertEquals(xpn.toString(), "Meier^Otto^^^^^L^A^^^G");
	}

	@Test
	public void testXPNExample2() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("Langer^Bernhard^^^Dr.^^L", new HL7Encoding());
		final XPN xpn = new XPN(hl7Repetition);

		assertEquals(xpn.getFamilyName(), "Langer");
		assertEquals(xpn.getGivenName(), "Bernhard");
		assertEquals(xpn.getMiddleName(), "");
		assertEquals(xpn.getNameRepresentationCode(), "");
		assertEquals(xpn.getNameTypeCode(), "L");
		assertEquals(xpn.getPrefix(), "Dr.");
		assertEquals(xpn.getSuffix(), "");
		assertEquals(xpn.getDegree(), "");
		assertEquals(xpn.getEffectiveDate(), "");
		assertEquals(xpn.getExpirationDate(), "");
		assertEquals(xpn.getNameAssemblyOrder(), "");
		assertEquals(xpn.getNameContext(), "");
		assertEquals(xpn.getNameValidityRange(), "");
		assertEquals(xpn.getProfessionalSuffix(), "");

		assertEquals(xpn.toString(), "Langer^Bernhard^^^Dr.^^L");
	}

	@Test
	public void testXPNExample3() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("van Beethoven&van&Beethoven^Ludwig^^^^^L^A^^^G",
				new HL7Encoding());
		final XPN xpn = new XPN(hl7Repetition);

		assertEquals(xpn.getFamilyName(), "van Beethoven&van&Beethoven");
		assertEquals(xpn.getGivenName(), "Ludwig");
		assertEquals(xpn.getMiddleName(), "");
		assertEquals(xpn.getNameRepresentationCode(), "A");
		assertEquals(xpn.getNameTypeCode(), "L");
		assertEquals(xpn.getPrefix(), "");
		assertEquals(xpn.getSuffix(), "");
		assertEquals(xpn.getDegree(), "");
		assertEquals(xpn.getEffectiveDate(), "");
		assertEquals(xpn.getExpirationDate(), "");
		assertEquals(xpn.getNameAssemblyOrder(), "G");
		assertEquals(xpn.getNameContext(), "");
		assertEquals(xpn.getNameValidityRange(), "");
		assertEquals(xpn.getProfessionalSuffix(), "");

		assertEquals(xpn.toString(), "van Beethoven&van&Beethoven^Ludwig^^^^^L^A^^^G");
	}

	@Test
	public void testXPNExample4() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("Dudeck^Joachim^W.^^Prof. Dr.^^L^A^^^G^^^Dr.med.",
				new HL7Encoding());
		final XPN xpn = new XPN(hl7Repetition);

		assertEquals(xpn.getFamilyName(), "Dudeck");
		assertEquals(xpn.getGivenName(), "Joachim");
		assertEquals(xpn.getMiddleName(), "W.");
		assertEquals(xpn.getNameRepresentationCode(), "A");
		assertEquals(xpn.getNameTypeCode(), "L");
		assertEquals(xpn.getPrefix(), "Prof. Dr.");
		assertEquals(xpn.getSuffix(), "");
		assertEquals(xpn.getDegree(), "");
		assertEquals(xpn.getEffectiveDate(), "");
		assertEquals(xpn.getExpirationDate(), "");
		assertEquals(xpn.getNameAssemblyOrder(), "G");
		assertEquals(xpn.getNameContext(), "");
		assertEquals(xpn.getNameValidityRange(), "");
		assertEquals(xpn.getProfessionalSuffix(), "Dr.med.");

		assertEquals(xpn.toString(), "Dudeck^Joachim^W.^^Prof. Dr.^^L^A^^^G^^^Dr.med.");
	}
}
