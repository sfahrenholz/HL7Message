package com.sefah.hl7.message.components;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

public class HL7RepetitionTest {

	static HL7Encoding encoding;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		encoding = new HL7Encoding();
	}

	@Test
	public void testInitWithoutComponents() throws Exception {
		final HL7Repetition rep = new HL7Repetition("comp1", encoding);
		assertThat(rep.getHL7ComponentCount(), is(1));
		assertThat(rep.getHL7RepetitionValue(), is("comp1"));

		assertThat(rep.getHL7Component(-1), nullValue());
		assertThat(rep.getHL7Component(0), notNullValue());
		assertThat(rep.getHL7Component(1), nullValue());
		assertThat(rep.getHL7ComponentValue(-1), is(""));
		assertThat(rep.getHL7ComponentValue(0), is("comp1"));
		assertThat(rep.getHL7ComponentValue(1), is(""));
	}

	@Test
	public void testInitWithComponents() throws Exception {
		final HL7Repetition rep = new HL7Repetition("comp1^comp2^comp3", encoding);
		assertThat(rep.getHL7ComponentCount(), is(3));
		assertThat(rep.getHL7RepetitionValue(), is("comp1^comp2^comp3"));

		assertThat(rep.getHL7Component(-1), nullValue());
		assertThat(rep.getHL7Component(0), notNullValue());
		assertThat(rep.getHL7Component(1), notNullValue());
		assertThat(rep.getHL7Component(2), notNullValue());
		assertThat(rep.getHL7Component(3), nullValue());
		assertThat(rep.getHL7ComponentValue(-1), is(""));
		assertThat(rep.getHL7ComponentValue(0), is("comp1"));
		assertThat(rep.getHL7ComponentValue(1), is("comp2"));
		assertThat(rep.getHL7ComponentValue(2), is("comp3"));
		assertThat(rep.getHL7ComponentValue(3), is(""));
	}

	@Test
	public void testInitWithComponentsSubComponents() throws Exception {
		final HL7Repetition rep = new HL7Repetition("comp1^comp2&SubComp2^comp3", encoding);
		assertThat(rep.getHL7ComponentCount(), is(3));
		assertThat(rep.getHL7RepetitionValue(), is("comp1^comp2&SubComp2^comp3"));

		assertThat(rep.getHL7Component(-1), nullValue());
		assertThat(rep.getHL7Component(0), notNullValue());
		assertThat(rep.getHL7Component(1), notNullValue());
		assertThat(rep.getHL7Component(2), notNullValue());
		assertThat(rep.getHL7Component(3), nullValue());
		assertThat(rep.getHL7ComponentValue(-1), is(""));
		assertThat(rep.getHL7ComponentValue(0), is("comp1"));
		assertThat(rep.getHL7ComponentValue(1), is("comp2&SubComp2"));
		assertThat(rep.getHL7ComponentValue(2), is("comp3"));
		assertThat(rep.getHL7ComponentValue(3), is(""));
	}

}
