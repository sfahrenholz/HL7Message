package com.sefah.hl7.message;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.sefah.hl7.exception.HL7ParseException;
import com.sefah.hl7.parserutils.HL7DateTimeParser;

/**
 * Data Object for the HL7DateTime-Format. Converts the given string to the format.
 * 
 * @author Sebastian Fahrenholz
 *
 */
public class HL7DateTime {

	private final LocalDateTime localDateTime;
	private final String precision;
	private final DateTimeFormatter formatter;
	private final Boolean hasTimeComponent;

	public HL7DateTime(final String dateTime) throws HL7ParseException {
		localDateTime = HL7DateTimeParser.parse(dateTime);
		precision = HL7DateTimeParser.getPattern(dateTime);
		formatter = DateTimeFormatter.ofPattern(precision);
		hasTimeComponent = dateTime.length() > 8;
	}

	public Date asDate() {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public String getPrecision() {
		return precision;
	}

	public boolean hasTimeComponent() {
		return hasTimeComponent;
	}

	public DateTimeFormatter getFormatter() {
		return formatter;
	}
	
	@Override
	public String toString() {
		return localDateTime.toString();
	}
}
