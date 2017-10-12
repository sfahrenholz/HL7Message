package com.sefah.hl7.message;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.time.Month;
import org.junit.Test;

public class HL7DateTimeTest {

	@Test
	public void testHL7DateTime() throws Exception {
		HL7DateTime dt = new HL7DateTime("20170202");
		assertThat(dt.toString(), is("2017-02-02T00:00"));
		assertThat(dt.asDate().toString(), is("Thu Feb 02 00:00:00 CET 2017"));
		assertThat(dt.getLocalDateTime().getYear(), is(2017));
		assertThat(dt.getLocalDateTime().getMonth(), is(Month.FEBRUARY));
		assertThat(dt.getLocalDateTime().getDayOfMonth(), is(02));
		assertThat(dt.getLocalDateTime().getHour(), is(0));
		assertThat(dt.getLocalDateTime().getMinute(), is(0));
		assertThat(dt.getPrecision(), is("yyyyMMdd"));
		assertThat(dt.hasTimeComponent(), is(false));
		assertThat(dt.getFormatter(), notNullValue());
		
		dt = new HL7DateTime("201709292201");
		assertThat(dt.toString(), is("2017-09-29T22:01"));
		assertThat(dt.asDate().toString(), is("Fri Sep 29 22:01:00 CEST 2017"));
		assertThat(dt.getLocalDateTime().getYear(), is(2017));
		assertThat(dt.getLocalDateTime().getMonth(), is(Month.SEPTEMBER));
		assertThat(dt.getLocalDateTime().getDayOfMonth(), is(29));
		assertThat(dt.getLocalDateTime().getHour(), is(22));
		assertThat(dt.getLocalDateTime().getMinute(), is(1));
		assertThat(dt.getPrecision(), is("yyyyMMddHHmm"));
		assertThat(dt.hasTimeComponent(), is(true));
		assertThat(dt.getFormatter(), notNullValue());
	}
}
