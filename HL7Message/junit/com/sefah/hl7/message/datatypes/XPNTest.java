package com.sefah.hl7.message.datatypes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.sefah.hl7.message.components.HL7Encoding;
import com.sefah.hl7.message.components.HL7Repetition;

public class XPNTest {

	@Test
	public void testXPNExample1() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("Meier^Otto^^^^^L^A^^^G", new HL7Encoding());
		final XPN xpn = new XPN(hl7Repetition);

		assertThat(xpn.getFamilyName(), is("Meier"));
		assertThat(xpn.getGivenName(), is("Otto"));
		assertThat(xpn.getMiddleName(), is(""));
		assertThat(xpn.getNameRepresentationCode(), is("A"));
		assertThat(xpn.getNameTypeCode(), is("L"));
		assertThat(xpn.getPrefix(), is(""));
		assertThat(xpn.getSuffix(), is(""));
		assertThat(xpn.getDegree(), is(""));
		assertThat(xpn.getEffectiveDate(), is(""));
		assertThat(xpn.getExpirationDate(), is(""));
		assertThat(xpn.getNameAssemblyOrder(), is("G"));
		assertThat(xpn.getNameContext(), is(""));
		assertThat(xpn.getNameValidityRange(), is(""));
		assertThat(xpn.getProfessionalSuffix(), is(""));

		assertThat(xpn.toString(), is("Meier^Otto^^^^^L^A^^^G"));
	}

	@Test
	public void testXPNExample2() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("Langer^Bernhard^^^Dr.^^L", new HL7Encoding());
		final XPN xpn = new XPN(hl7Repetition);

		assertThat(xpn.getFamilyName(), is("Langer"));
		assertThat(xpn.getGivenName(), is("Bernhard"));
		assertThat(xpn.getMiddleName(), is(""));
		assertThat(xpn.getNameRepresentationCode(), is(""));
		assertThat(xpn.getNameTypeCode(), is("L"));
		assertThat(xpn.getPrefix(), is("Dr."));
		assertThat(xpn.getSuffix(), is(""));
		assertThat(xpn.getDegree(), is(""));
		assertThat(xpn.getEffectiveDate(), is(""));
		assertThat(xpn.getExpirationDate(), is(""));
		assertThat(xpn.getNameAssemblyOrder(), is(""));
		assertThat(xpn.getNameContext(), is(""));
		assertThat(xpn.getNameValidityRange(), is(""));
		assertThat(xpn.getProfessionalSuffix(), is(""));

		assertThat(xpn.toString(), is("Langer^Bernhard^^^Dr.^^L"));
	}

	@Test
	public void testXPNExample3() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("van Beethoven&van&Beethoven^Ludwig^^^^^L^A^^^G",
				new HL7Encoding());
		final XPN xpn = new XPN(hl7Repetition);

		assertThat(xpn.getFamilyName(), is("van Beethoven&van&Beethoven"));
		assertThat(xpn.getGivenName(), is("Ludwig"));
		assertThat(xpn.getMiddleName(), is(""));
		assertThat(xpn.getNameRepresentationCode(), is("A"));
		assertThat(xpn.getNameTypeCode(), is("L"));
		assertThat(xpn.getPrefix(), is(""));
		assertThat(xpn.getSuffix(), is(""));
		assertThat(xpn.getDegree(), is(""));
		assertThat(xpn.getEffectiveDate(), is(""));
		assertThat(xpn.getExpirationDate(), is(""));
		assertThat(xpn.getNameAssemblyOrder(), is("G"));
		assertThat(xpn.getNameContext(), is(""));
		assertThat(xpn.getNameValidityRange(), is(""));
		assertThat(xpn.getProfessionalSuffix(), is(""));

		assertThat(xpn.toString(), is("van Beethoven&van&Beethoven^Ludwig^^^^^L^A^^^G"));
	}

	@Test
	public void testXPNExample4() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("Dudeck^Joachim^W.^^Prof. Dr.^^L^A^^^G^^^Dr.med.",
				new HL7Encoding());
		final XPN xpn = new XPN(hl7Repetition);

		assertThat(xpn.getFamilyName(), is("Dudeck"));
		assertThat(xpn.getGivenName(), is("Joachim"));
		assertThat(xpn.getMiddleName(), is("W."));
		assertThat(xpn.getNameRepresentationCode(), is("A"));
		assertThat(xpn.getNameTypeCode(), is("L"));
		assertThat(xpn.getPrefix(), is("Prof. Dr."));
		assertThat(xpn.getSuffix(), is(""));
		assertThat(xpn.getDegree(), is(""));
		assertThat(xpn.getEffectiveDate(), is(""));
		assertThat(xpn.getExpirationDate(), is(""));
		assertThat(xpn.getNameAssemblyOrder(), is("G"));
		assertThat(xpn.getNameContext(), is(""));
		assertThat(xpn.getNameValidityRange(), is(""));
		assertThat(xpn.getProfessionalSuffix(), is("Dr.med."));

		assertThat(xpn.toString(), is("Dudeck^Joachim^W.^^Prof. Dr.^^L^A^^^G^^^Dr.med."));
	}
}
