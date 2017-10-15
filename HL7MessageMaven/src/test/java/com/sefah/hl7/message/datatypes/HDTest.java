package com.sefah.hl7.message.datatypes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.sefah.hl7.message.components.HL7Encoding;
import com.sefah.hl7.message.components.HL7Repetition;

public class HDTest {

	@Test
	public void testName() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("ACME Pathology^2184^AUSNATA", new HL7Encoding());
		final HD hd = new HD(hl7Repetition);

		assertEquals(hd.getNamespaceId(),"ACME Pathology");
		assertEquals(hd.getUniversalId(),"2184");
		assertEquals(hd.getUniversalIdType(),"AUSNATA");

	}

	@Test
	public void testName2() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition(
				"ACME Pathology^1.2.36.1.2001.1003.0.8003621566684455^ISO", new HL7Encoding());
		final HD hd = new HD(hl7Repetition);

		assertEquals(hd.getNamespaceId(),"ACME Pathology");
		assertEquals(hd.getUniversalId(),"1.2.36.1.2001.1003.0.8003621566684455");
		assertEquals(hd.getUniversalIdType(),"ISO");

	}

	@Test
	public void testName3() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("^1.2.344.24.1.1.3^ISO", new HL7Encoding());
		final HD hd = new HD(hl7Repetition);

		assertEquals(hd.getNamespaceId(),"");
		assertEquals(hd.getUniversalId(),"1.2.344.24.1.1.3");
		assertEquals(hd.getUniversalIdType(),"ISO");

	}
}
