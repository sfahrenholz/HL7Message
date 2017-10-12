package com.sefah.hl7.message.datatypes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.sefah.hl7.message.components.HL7Encoding;
import com.sefah.hl7.message.components.HL7Repetition;

public class JCCTest {
	
	@Test
	public void testName() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("ACME Pathology^2184^AUSNATA", new HL7Encoding());
		final JCC jcc = new JCC(hl7Repetition);

		assertThat(jcc.getJobClass(), is("2184"));
		assertThat(jcc.getJobCode(), is("ACME Pathology"));
		assertThat(jcc.toString(), is("ACME Pathology, 2184"));

	}
}
