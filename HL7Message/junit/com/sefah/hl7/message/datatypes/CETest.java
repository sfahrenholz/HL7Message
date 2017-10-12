package com.sefah.hl7.message.datatypes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.sefah.hl7.message.components.HL7Encoding;
import com.sefah.hl7.message.components.HL7Repetition;

public class CETest {

	@Test
	public void testName() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("2148-5^Creatinine^LN^F-11380^^I9^", new HL7Encoding());
		final CE ce = new CE(hl7Repetition);

		assertThat(ce.getAlternateIdentifier(), is("F-11380"));
		assertThat(ce.getAlternateText(), is(""));
		assertThat(ce.getAlternativeCodingSystem(), is("I9"));
		assertThat(ce.getCodingSystem(), is("LN"));
		assertThat(ce.getIdentifier(), is("2148-5"));
		assertThat(ce.getText(), is("Creatinine"));
	}
}
