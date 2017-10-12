package com.sefah.hl7.message.components;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

public class HL7ComponentTest {
	static HL7Encoding encoding;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		encoding = new HL7Encoding();
	}

	@Test
	public void testInitalizationWithoutSubComponent() throws Exception {
		final HL7Component com = new HL7Component("Comp2", encoding);
		assertThat(com.getComponentValue(), is("Comp2"));
		assertThat(com.getHL7SubComponentCount(), is(1));
		
		assertThat(com.getHL7SubComponent(-1), nullValue());
		assertThat(com.getHL7SubComponent(0), notNullValue());
		assertThat(com.getHL7SubComponent(1), nullValue());
		assertThat(com.getHL7SubComponentValue(-1), is(""));
		assertThat(com.getHL7SubComponentValue(0), is("Comp2"));
		assertThat(com.getHL7SubComponentValue(1), is(""));

		final HL7SubComponent hl7SubComponent = com.getHL7SubComponent(0);
		assertThat(hl7SubComponent.getSubComponentValue(), is("Comp2"));
	}

	@Test
	public void testInitalizationWithSubComponent() throws Exception {
		final HL7Component com = new HL7Component("Comp2&SubComp2", encoding);
		assertThat(com.getComponentValue(), is("Comp2&SubComp2"));
		assertThat(com.getHL7SubComponentCount(), is(2));
		assertThat(com.getHL7SubComponent(-1), nullValue());
		assertThat(com.getHL7SubComponent(0), notNullValue());
		assertThat(com.getHL7SubComponent(1), notNullValue());
		assertThat(com.getHL7SubComponentValue(-1), is(""));
		assertThat(com.getHL7SubComponentValue(0), is("Comp2"));
		assertThat(com.getHL7SubComponentValue(1), is("SubComp2"));
		assertThat(com.getHL7SubComponentValue(2), is(""));

		HL7SubComponent hl7SubComponent = com.getHL7SubComponent(0);
		assertThat(hl7SubComponent.getSubComponentValue(), is("Comp2"));
		hl7SubComponent = com.getHL7SubComponent(1);
		assertThat(hl7SubComponent.getSubComponentValue(), is("SubComp2"));
	}
}
