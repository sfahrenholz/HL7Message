package com.sefah.hl7.message.datatypes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.sefah.hl7.message.components.HL7Encoding;
import com.sefah.hl7.message.components.HL7Repetition;

public class HDTest {

	@Test
	public void testName() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("ACME Pathology^2184^AUSNATA", new HL7Encoding());
		final HD hd = new HD(hl7Repetition);

		assertThat(hd.getNamespaceId(), is("ACME Pathology"));
		assertThat(hd.getUniversalId(), is("2184"));
		assertThat(hd.getUniversalIdType(), is("AUSNATA"));

	}

	@Test
	public void testName2() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition(
				"ACME Pathology^1.2.36.1.2001.1003.0.8003621566684455^ISO", new HL7Encoding());
		final HD hd = new HD(hl7Repetition);

		assertThat(hd.getNamespaceId(), is("ACME Pathology"));
		assertThat(hd.getUniversalId(), is("1.2.36.1.2001.1003.0.8003621566684455"));
		assertThat(hd.getUniversalIdType(), is("ISO"));

	}

	@Test
	public void testName3() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("^1.2.344.24.1.1.3^ISO", new HL7Encoding());
		final HD hd = new HD(hl7Repetition);

		assertThat(hd.getNamespaceId(), is(""));
		assertThat(hd.getUniversalId(), is("1.2.344.24.1.1.3"));
		assertThat(hd.getUniversalIdType(), is("ISO"));

	}
}
