package com.sefah.hl7.message.datatypes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.sefah.hl7.message.components.HL7Encoding;
import com.sefah.hl7.message.components.HL7Repetition;

public class VIDTest {

	@Test
	public void testName() throws Exception {
		HL7Repetition hl7Repetition = new HL7Repetition("2.4^DEU^HL7AU-OO-201701", new HL7Encoding());
		VID dld = new VID(hl7Repetition);
		
		assertEquals(dld.getInternationalizationCode(), "DEU");
		assertEquals(dld.getInternationalVersionID(), "HL7AU-OO-201701");
		assertEquals(dld.getVersionId(), "2.4");
	}
}
