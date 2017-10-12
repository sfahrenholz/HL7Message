package com.sefah.hl7.message.components;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.sefah.hl7.exception.HL7EncodingException;

public class HL7EncodingTest {

	@Test
	public void testDefaultHL7Encoding() throws Exception {
		final HL7Encoding encoding = new HL7Encoding();
		assertThat(encoding.getComponentSeperator(), is("^"));
		assertThat(encoding.getEscapeCharacter(), is("\\"));
		assertThat(encoding.getFieldSeperator(), is("|"));
		assertThat(encoding.getLineSeperator(), is("\r"));
		assertThat(encoding.getRepetitionSeperator(), is("~"));
		assertThat(encoding.getSubcomponentSeperator(), is("&"));
		assertThat(encoding.getMSH2Field(), is("|^~\\&"));

		assertThat(encoding.isSeperator(encoding.getComponentSeperator()), is(true));
		assertThat(encoding.isSeperator(encoding.getEscapeCharacter()), is(false));
		assertThat(encoding.isSeperator(encoding.getFieldSeperator()), is(true));
		assertThat(encoding.isSeperator(encoding.getLineSeperator()), is(false));
		assertThat(encoding.isSeperator(encoding.getRepetitionSeperator()), is(true));
		assertThat(encoding.isSeperator(encoding.getSubcomponentSeperator()), is(true));

		assertThat(encoding.toString(), notNullValue());
	}

	@Test
	public void testHL7Encoding() throws Exception {
		final HL7Encoding encoding = new HL7Encoding("#+~\\/");
		assertThat(encoding.getEscapeCharacter(), is("\\"));
		assertThat(encoding.getFieldSeperator(), is("#"));
		assertThat(encoding.getRepetitionSeperator(), is("~"));
		assertThat(encoding.getComponentSeperator(), is("+"));
		assertThat(encoding.getSubcomponentSeperator(), is("/"));
		assertThat(encoding.getLineSeperator(), is("\r"));
		assertThat(encoding.getMSH2Field(), is("#+~\\/"));

		assertThat(encoding.isSeperator(encoding.getComponentSeperator()), is(true));
		assertThat(encoding.isSeperator(encoding.getEscapeCharacter()), is(false));
		assertThat(encoding.isSeperator(encoding.getFieldSeperator()), is(true));
		assertThat(encoding.isSeperator(encoding.getLineSeperator()), is(false));
		assertThat(encoding.isSeperator(encoding.getRepetitionSeperator()), is(true));
		assertThat(encoding.isSeperator(encoding.getSubcomponentSeperator()), is(true));

		assertThat(encoding.toString(), notNullValue());
	}

	@Test(expected = HL7EncodingException.class)
	public void testHL7EncodingNULL() throws Exception {
		new HL7Encoding(null);
	}

	@Test(expected = HL7EncodingException.class)
	public void testHL7EncodingLength() throws Exception {
		new HL7Encoding("A");
	}
}
