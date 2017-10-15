package com.sefah.hl7.message.datatypes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.sefah.hl7.message.components.HL7Encoding;
import com.sefah.hl7.message.components.HL7Repetition;

public class JCCTest {
	
	@Test
	public void testName() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("ACME Pathology^2184^AUSNATA", new HL7Encoding());
		final JCC jcc = new JCC(hl7Repetition);

		assertEquals(jcc.getJobClass(),"2184");
		assertEquals(jcc.getJobCode(),"ACME Pathology");
		assertEquals(jcc.toString(),"ACME Pathology, 2184");

	}
}
