package com.sefah.hl7.message.components;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

public class HL7FieldTest {
	static HL7Encoding encoding;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		encoding = new HL7Encoding();
	}

	@Test
	public void testInitWithoutRepetition() throws Exception {
		final HL7Field field = new HL7Field("field", encoding);
		assertThat(field.getHL7RepetitionCount(), is(1));
		assertThat(field.getValue(), is("field"));

		assertThat(field.getHL7Repetition(-1), nullValue());
		assertThat(field.getHL7Repetition(0), notNullValue());
		assertThat(field.getHL7Repetition(1), nullValue());
		assertThat(field.getHL7RepetitionValue(-1), is(""));
		assertThat(field.getHL7RepetitionValue(0), is("field"));
		assertThat(field.getHL7RepetitionValue(1), is(""));
	}

	@Test
	public void testInitWithRepetition() throws Exception {
		final HL7Field field = new HL7Field("field1~field2~field3", encoding);
		assertThat(field.getHL7RepetitionCount(), is(3));
		assertThat(field.getValue(), is("field1~field2~field3"));

		assertThat(field.getHL7Repetition(-1), nullValue());
		assertThat(field.getHL7Repetition(0), notNullValue());
		assertThat(field.getHL7Repetition(1), notNullValue());
		assertThat(field.getHL7Repetition(2), notNullValue());
		assertThat(field.getHL7Repetition(3), nullValue());

		assertThat(field.getHL7RepetitionValue(-1), is(""));
		assertThat(field.getHL7RepetitionValue(0), is("field1"));
		assertThat(field.getHL7RepetitionValue(1), is("field2"));
		assertThat(field.getHL7RepetitionValue(2), is("field3"));
		assertThat(field.getHL7RepetitionValue(3), is(""));
	}

	@Test
	public void testInitWithRepetitionComponentSubComponent() throws Exception {
		final HL7Field field = new HL7Field("field1~field2^Comp2&SubComp2~field3", encoding);
		assertThat(field.getHL7RepetitionCount(), is(3));
		assertThat(field.getValue(), is("field1~field2^Comp2&SubComp2~field3"));

		assertThat(field.getHL7Repetition(-1), nullValue());
		assertThat(field.getHL7Repetition(0), notNullValue());
		assertThat(field.getHL7Repetition(1), notNullValue());
		assertThat(field.getHL7Repetition(2), notNullValue());
		assertThat(field.getHL7Repetition(3), nullValue());

		assertThat(field.getHL7RepetitionValue(-1), is(""));
		assertThat(field.getHL7RepetitionValue(0), is("field1"));
		assertThat(field.getHL7RepetitionValue(1), is("field2^Comp2&SubComp2"));
		assertThat(field.getHL7RepetitionValue(2), is("field3"));
		assertThat(field.getHL7RepetitionValue(3), is(""));
	}
}
