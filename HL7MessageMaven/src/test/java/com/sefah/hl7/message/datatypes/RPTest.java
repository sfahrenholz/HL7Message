package com.sefah.hl7.message.datatypes;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.sefah.hl7.message.components.HL7Encoding;
import com.sefah.hl7.message.components.HL7Repetition;

public class RPTest {
	
	@Test
	public void testName() throws Exception {
		HL7Repetition hl7Repetition = new HL7Repetition("1234A321634BC^EFC^SD", new HL7Encoding());
		RP dld = new RP(hl7Repetition);
		
		assertEquals(dld.getApplicationID(), "EFC");
		assertEquals(dld.getPointer(), "1234A321634BC");
		assertEquals(dld.getSubtype(), "");
		assertEquals(dld.getTypeOfData(), "SD");
		assertEquals(dld.getTypeSubtypeCombinations(), "");
	}
}
