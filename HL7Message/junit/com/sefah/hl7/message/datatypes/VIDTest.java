package com.sefah.hl7.message.datatypes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.sefah.hl7.message.components.HL7Encoding;
import com.sefah.hl7.message.components.HL7Repetition;

public class VIDTest {

	@Test
	public void testName() throws Exception {
		HL7Repetition hl7Repetition = new HL7Repetition("2.4^DEU^HL7AU-OO-201701", new HL7Encoding());
		VID dld = new VID(hl7Repetition);
		
		assertThat(dld.getInternationalizationCode(), is("DEU"));
		assertThat(dld.getInternationalVersionID(), is("HL7AU-OO-201701"));
		assertThat(dld.getVersionId(), is("2.4"));
	}
}
