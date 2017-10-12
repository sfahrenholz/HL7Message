package com.sefah.hl7.message.datatypes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.sefah.hl7.message.components.HL7Encoding;
import com.sefah.hl7.message.components.HL7Repetition;

public class RPTest {
	
	@Test
	public void testName() throws Exception {
		HL7Repetition hl7Repetition = new HL7Repetition("1234A321634BC^EFC^SD", new HL7Encoding());
		RP dld = new RP(hl7Repetition);
		
		assertThat(dld.getApplicationID(), is("EFC"));
		assertThat(dld.getPointer(), is("1234A321634BC"));
		assertThat(dld.getSubtype(), is(""));
		assertThat(dld.getTypeOfData(), is("SD"));
		assertThat(dld.getTypeSubtypeCombinations(), is(""));
	}
}
