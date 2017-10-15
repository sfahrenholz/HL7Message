package com.sefah.hl7.message;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.Month;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class HL7DateTimeTest {
	
	@DisplayName("Test add user with passed argument is null.")
	@Test
	public void testHL7DateTime() throws Exception {
		
		HL7DateTime dt = new HL7DateTime("20170202");
		assertEquals(dt.toString(),"2017-02-02T00:00");
		assertEquals(dt.asDate().toString(),"Thu Feb 02 00:00:00 CET 2017");
		assertEquals(dt.getLocalDateTime().getYear(),2017);
		assertEquals(dt.getLocalDateTime().getMonth(),Month.FEBRUARY);
		assertEquals(dt.getLocalDateTime().getDayOfMonth(),02);
		assertEquals(dt.getLocalDateTime().getHour(),0);
		assertEquals(dt.getLocalDateTime().getMinute(),0);
		assertEquals(dt.getPrecision(),"yyyyMMdd");
		assertEquals(dt.hasTimeComponent(),false);
		assertNotEquals(dt.getFormatter(), null);
		
		dt = new HL7DateTime("201709292201");
		assertEquals(dt.toString(),"2017-09-29T22:01");
		assertEquals(dt.asDate().toString(),"Fri Sep 29 22:01:00 CEST 2017");
		assertEquals(dt.getLocalDateTime().getYear(),2017);
		assertEquals(dt.getLocalDateTime().getMonth(),Month.SEPTEMBER);
		assertEquals(dt.getLocalDateTime().getDayOfMonth(),29);
		assertEquals(dt.getLocalDateTime().getHour(),22);
		assertEquals(dt.getLocalDateTime().getMinute(),1);
		assertEquals(dt.getPrecision(),"yyyyMMddHHmm");
		assertEquals(dt.hasTimeComponent(),true);
		assertNotEquals(dt.getFormatter(), null);
	}
}
