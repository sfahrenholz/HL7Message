package com.sefah.hl7.message;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.sefah.testresource.HL7TestResourceManager;

public class HL7MessageReaderTest {

	@Test
	public void testHL7_MESSAGE_ORU_R01() throws Exception {
		final HL7Message message = new HL7Message(HL7TestResourceManager.getHL7TestFileString(HL7TestResourceManager.HL7_MESSAGE_ORU_R01));
		assertThat(message, notNullValue());
		assertThat(message.getSegmentCount(), is(17));
	}
	
	@Test
	public void testHL7_MESSAGE_ORU_R01_SIMPLE() throws Exception {
		final HL7Message message = new HL7Message(HL7TestResourceManager.getHL7TestFileString(HL7TestResourceManager.HL7_MESSAGE_ORU_R01_SIMPLE));
		assertThat(message, notNullValue());
		assertThat(message.getSegmentCount(), is(2));
	}
}
