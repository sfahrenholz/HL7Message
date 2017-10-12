package com.sefah.hl7.parserutils;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.sefah.hl7.exception.HL7MessageErrorCode;
import com.sefah.hl7.exception.HL7ParseException;

public class HL7DateTimeParserTest {

	@Test
	public void testParse() throws Exception {
		assertThat(HL7DateTimeParser.parse(""), nullValue());
		assertThat(HL7DateTimeParser.parse("2017").toString(), is("2017-01-01T00:00"));
		
		try {
			assertThat(HL7DateTimeParser.parse("20170").toString(), is("2017-09-29T00:00"));
			fail("Expected HL7ParseException, but was not throwing");
		} catch (final HL7ParseException e) {
			assertThat(e.getErrorCode(), is(HL7MessageErrorCode.HL7_MESSAGE_ERROR_IVALID_DATETIME.getCode()));
		}
		
		assertThat(HL7DateTimeParser.parse("201709").toString(), is("2017-09-01T00:00"));
		assertThat(HL7DateTimeParser.parse("20170929").toString(), is("2017-09-29T00:00"));
		
		try {
			assertThat(HL7DateTimeParser.parse("2017092923").toString(), is("2017-09-29T00:00"));
			fail("Expected HL7ParseException, but was not throwing");
		} catch (final HL7ParseException e) {
			assertThat(e.getErrorCode(), is(HL7MessageErrorCode.HL7_MESSAGE_ERROR_PARSE_DATETIME.getCode()));
		}
		
		assertThat(HL7DateTimeParser.parse("201709292325").toString(), is("2017-09-29T23:25"));
		assertThat(HL7DateTimeParser.parse("20170929232521").toString(), is("2017-09-29T23:25:21"));
	}
	
	@Test
	public void testGetPattern() throws Exception {
		try {
			assertThat(HL7DateTimeParser.getPattern(""), nullValue());
			fail("Expected HL7ParseException, but was not throwing");
		} catch (final HL7ParseException e) {
			assertThat(e.getErrorCode(), is(HL7MessageErrorCode.HL7_MESSAGE_ERROR_PARSE_DATETIME.getCode()));
		}

		assertThat(HL7DateTimeParser.getPattern("2017").toString(), is("yyyy"));
		assertThat(HL7DateTimeParser.getPattern("201709").toString(), is("yyyy-MM"));
		assertThat(HL7DateTimeParser.getPattern("20170929").toString(), is("yyyyMMdd"));

		try {
			assertThat(HL7DateTimeParser.getPattern("2017092923").toString(), is("2017-09-29T00:00"));
			fail("Expected HL7ParseException, but was not throwing");
		} catch (final HL7ParseException e) {
			assertThat(e.getErrorCode(), is(HL7MessageErrorCode.HL7_MESSAGE_ERROR_PARSE_DATETIME.getCode()));
		}
		
		assertThat(HL7DateTimeParser.getPattern("201709292325").toString(), is("yyyyMMddHHmm"));
		assertThat(HL7DateTimeParser.getPattern("20170929232521").toString(), is("yyyyMMddHHmmss"));
		assertThat(HL7DateTimeParser.getPattern("2017092923252100").toString(), is("yyyyMMddHHmmss.S"));
		assertThat(HL7DateTimeParser.getPattern("20170929232521000").toString(), is("yyyyMMddHHmmss.SS"));
		assertThat(HL7DateTimeParser.getPattern("201709292325210000").toString(), is("yyyyMMddHHmmss.SSS"));
		assertThat(HL7DateTimeParser.getPattern("2017092923252100000").toString(), is("yyyyMMddHHmmss.SSSS"));
	}

	@Test
	public void testIsValidTs() throws Exception {
		assertThat(HL7DateTimeParser.isValidTs(null), is(false));
		assertThat(HL7DateTimeParser.isValidTs(""), is(true));
		assertThat(HL7DateTimeParser.isValidTs("2"), is(false));
		assertThat(HL7DateTimeParser.isValidTs("20"), is(false));
		assertThat(HL7DateTimeParser.isValidTs("201"), is(false));
		assertThat(HL7DateTimeParser.isValidTs("2017"), is(true));
		assertThat(HL7DateTimeParser.isValidTs("201709"), is(true));
		assertThat(HL7DateTimeParser.isValidTs("20170929"), is(true));
		assertThat(HL7DateTimeParser.isValidTs("2017092923"), is(true));
		assertThat(HL7DateTimeParser.isValidTs("201709292325"), is(true));
		assertThat(HL7DateTimeParser.isValidTs("20170929232521"), is(true));
	}
}
