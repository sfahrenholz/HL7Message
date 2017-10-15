package com.sefah.hl7.message.datatypes;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.sefah.hl7.message.components.HL7Encoding;
import com.sefah.hl7.message.components.HL7Repetition;

public class DLDTest {

	@Test
	public void testName() throws Exception {
		HL7Repetition hl7Repetition = new HL7Repetition("20170930^19880507", new HL7Encoding());
		DLD dld = new DLD(hl7Repetition);
		
		assertEquals(dld.getDischargeLocation(),"20170930");
		assertEquals(dld.getEffectiveDate(),"19880507");
		assertEquals(dld.getEffectiveDateAsLocalDateTime().toString(),"1988-05-07T00:00");
	}
}
