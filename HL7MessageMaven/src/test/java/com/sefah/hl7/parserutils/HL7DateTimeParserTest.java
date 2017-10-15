package com.sefah.hl7.parserutils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import com.sefah.hl7.exception.HL7MessageErrorCode;
import com.sefah.hl7.exception.HL7ParseException;

public class HL7DateTimeParserTest {

	@Test
	public void testParse() throws Exception {
		assertEquals(HL7DateTimeParser.parse(""),null);
		assertEquals(HL7DateTimeParser.parse("2017").toString(), "2017-01-01T00:00");
		
		try {
			assertEquals(HL7DateTimeParser.parse("20170").toString(), "2017-09-29T00:00");
			fail("Expected HL7ParseException, but was not throwing");
		} catch (final HL7ParseException e) {
			assertEquals(e.getErrorCode(), HL7MessageErrorCode.HL7_MESSAGE_ERROR_IVALID_DATETIME.getCode());
		}
		
		assertEquals(HL7DateTimeParser.parse("201709").toString(), "2017-09-01T00:00");
		assertEquals(HL7DateTimeParser.parse("20170929").toString(), "2017-09-29T00:00");
		
		try {
			assertEquals(HL7DateTimeParser.parse("2017092923").toString(), "2017-09-29T00:00");
			fail("Expected HL7ParseException, but was not throwing");
		} catch (final HL7ParseException e) {
			assertEquals(e.getErrorCode(), HL7MessageErrorCode.HL7_MESSAGE_ERROR_PARSE_DATETIME.getCode());
		}
		
		assertEquals(HL7DateTimeParser.parse("201709292325").toString(), "2017-09-29T23:25");
		assertEquals(HL7DateTimeParser.parse("20170929232521").toString(), "2017-09-29T23:25:21");
	}
	
	@Test
	public void testGetPattern() throws Exception {
		try {
			assertEquals(HL7DateTimeParser.getPattern(""),null);
			fail("Expected HL7ParseException, but was not throwing");
		} catch (final HL7ParseException e) {
			assertEquals(e.getErrorCode(), HL7MessageErrorCode.HL7_MESSAGE_ERROR_PARSE_DATETIME.getCode());
		}

		assertEquals(HL7DateTimeParser.getPattern("2017").toString(), "yyyy");
		assertEquals(HL7DateTimeParser.getPattern("201709").toString(), "yyyy-MM");
		assertEquals(HL7DateTimeParser.getPattern("20170929").toString(), "yyyyMMdd");

		try {
			assertEquals(HL7DateTimeParser.getPattern("2017092923").toString(), "2017-09-29T00:00");
			fail("Expected HL7ParseException, but was not throwing");
		} catch (final HL7ParseException e) {
			assertEquals(e.getErrorCode(), HL7MessageErrorCode.HL7_MESSAGE_ERROR_PARSE_DATETIME.getCode());
		}
		
		assertEquals(HL7DateTimeParser.getPattern("201709292325").toString(), "yyyyMMddHHmm");
		assertEquals(HL7DateTimeParser.getPattern("20170929232521").toString(), "yyyyMMddHHmmss");
		assertEquals(HL7DateTimeParser.getPattern("2017092923252100").toString(), "yyyyMMddHHmmss.S");
		assertEquals(HL7DateTimeParser.getPattern("20170929232521000").toString(), "yyyyMMddHHmmss.SS");
		assertEquals(HL7DateTimeParser.getPattern("201709292325210000").toString(), "yyyyMMddHHmmss.SSS");
		assertEquals(HL7DateTimeParser.getPattern("2017092923252100000").toString(), "yyyyMMddHHmmss.SSSS");
	}

	@Test
	public void testIsValidTs() throws Exception {
		assertEquals(HL7DateTimeParser.isValidTs(null), false);
		assertEquals(HL7DateTimeParser.isValidTs(""), true);
		assertEquals(HL7DateTimeParser.isValidTs("2"), false);
		assertEquals(HL7DateTimeParser.isValidTs("20"), false);
		assertEquals(HL7DateTimeParser.isValidTs("201"), false);
		assertEquals(HL7DateTimeParser.isValidTs("2017"), true);
		assertEquals(HL7DateTimeParser.isValidTs("201709"), true);
		assertEquals(HL7DateTimeParser.isValidTs("20170929"), true);
		assertEquals(HL7DateTimeParser.isValidTs("2017092923"), true);
		assertEquals(HL7DateTimeParser.isValidTs("201709292325"), true);
		assertEquals(HL7DateTimeParser.isValidTs("20170929232521"), true);
	}
}
