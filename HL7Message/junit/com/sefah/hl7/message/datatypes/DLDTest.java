package com.sefah.hl7.message.datatypes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.sefah.hl7.message.components.HL7Encoding;
import com.sefah.hl7.message.components.HL7Repetition;

public class DLDTest {

	@Test
	public void testName() throws Exception {
		HL7Repetition hl7Repetition = new HL7Repetition("20170930^19880507", new HL7Encoding());
		DLD dld = new DLD(hl7Repetition);
		
		assertThat(dld.getDischargeLocation(), is("20170930"));
		assertThat(dld.getEffectiveDate(), is("19880507"));
		assertThat(dld.getEffectiveDateAsLocalDateTime().toString(), is("1988-05-07T00:00"));
	}
}
