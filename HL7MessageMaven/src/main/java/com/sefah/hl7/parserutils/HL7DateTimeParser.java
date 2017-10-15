package com.sefah.hl7.parserutils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import com.sefah.hl7.exception.HL7MessageErrorCode;
import com.sefah.hl7.exception.HL7ParseException;

public abstract class HL7DateTimeParser {

	private static final int YYYY = 4;
	private static final int YYYYMM = 6;
	private static final int YYYYMMDD = 8;
	private static final int YYYYMMDDHHMM = 12;
	private static final int YYYYMMDDHHMMSS = 14;
	private static final int YYYYMMDDHHMMSS_T = 16;
	private static final int YYYYMMDDHHMMSS_TT = 17;
	private static final int YYYYMMDDHHMMSS_TTT = 18;
	private static final int YYYYMMDDHHMMSS_TTTT = 19;

	private HL7DateTimeParser() {
		// SQ
	}

	/**
	 * Parsing the given dateTime-String to the LocalDateTime-Object. it can only
	 * parse Strings with the format Year - Month - Day - Hour - Minutes - Seconds - Milliseconds
	 * Other formats can not be parse correctly!!!
	 * 
	 * @param dateTime
	 * @return
	 * @throws HL7ParseException
	 */
	public static LocalDateTime parse(final String dateTime) throws HL7ParseException {
		Objects.requireNonNull(dateTime);

		String cleanDateTime = dateTime.trim();

		if ("".equals(cleanDateTime)) {
			return null;
		}

		if (!isValidTs(cleanDateTime)) {
			throw new HL7ParseException(HL7MessageErrorCode.HL7_MESSAGE_ERROR_IVALID_DATETIME,cleanDateTime);
		}

		if (cleanDateTime.length() < 8) {
			cleanDateTime = handleShortDates(cleanDateTime);
		}

		final String pattern = getPattern(cleanDateTime);
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

		if (cleanDateTime.length() == 8) {
			return LocalDate.parse(cleanDateTime, formatter).atStartOfDay();
		}

		return LocalDateTime.parse(cleanDateTime, formatter);
	}

	private static String handleShortDates(final String dateTime) {
		if (dateTime.length() == 4) {
			return dateTime + "0101";
		}

		if (dateTime.length() == 6) {
			return dateTime + "01";
		}

		return dateTime;
	}

	public static String getPattern(final String dateTime) throws HL7ParseException {
		switch (dateTime.length()) {
		case YYYY:
			return "yyyy";
		case YYYYMM:
			return "yyyy-MM";
		case YYYYMMDD:
			return "yyyyMMdd";
		case YYYYMMDDHHMM:
			return "yyyyMMddHHmm";
		case YYYYMMDDHHMMSS:
			return "yyyyMMddHHmmss";
		case YYYYMMDDHHMMSS_T:
			return "yyyyMMddHHmmss.S";
		case YYYYMMDDHHMMSS_TT:
			return "yyyyMMddHHmmss.SS";
		case YYYYMMDDHHMMSS_TTT:
			return "yyyyMMddHHmmss.SSS";
		case YYYYMMDDHHMMSS_TTTT:
			return "yyyyMMddHHmmss.SSSS";
		default:
			throw new HL7ParseException(HL7MessageErrorCode.HL7_MESSAGE_ERROR_PARSE_DATETIME, dateTime);
		}
	}

	/**
	 * Check if the given string in the correct (expected) datetime format.
	 * 
	 * @param dateTime
	 * @return
	 */
	public static boolean isValidTs(final String dateTime) {
		if (dateTime == null) {
			return false;
		}

		final String regex = "([12]\\d{3}" + "((0[1-9]|1[0-2])" + "((0[1-9]|[12]\\d|3[01])" + "(([01]\\d|2[0-3])"
				+ "([0-5]\\d" + "([0-5]\\d" + "(\\.\\d\\d?\\d?\\d?)?)?)?)?)?)?"
				+ "((\\+|\\-)([01]\\d|2[0-3])[0-5]\\d)?)?";
		return dateTime.matches(regex);
	}
}