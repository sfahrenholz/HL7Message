package com.sefah.hl7.message.datatypes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.sefah.hl7.message.components.HL7Encoding;
import com.sefah.hl7.message.components.HL7Repetition;

public class XADTest {
	@Test
	public void testName() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("1234 Easy St.^Ste. 123^San Francisco^CA^95123^USA^B^^SF^", new HL7Encoding());
		final XAD cx = new XAD(hl7Repetition);

		assertEquals(cx.getAddressRepresentationCode(), "");
		assertEquals(cx.getAddressType(), "B");
		assertEquals(cx.getCensusTract(), "");
		assertEquals(cx.getCity(), "San Francisco");
		assertEquals(cx.getCountry(), "USA");
		assertEquals(cx.getCountyCode(), "SF");
		assertEquals(cx.getOtherDesignation(), "Ste. 123");
		assertEquals(cx.getOtherGeographicDesignation(), "");
		assertEquals(cx.getPostCode(), "95123");
		assertEquals(cx.getProvince(), "CA");
		assertEquals(cx.getStreetAddress(), "1234 Easy St.");
		assertEquals(cx.getAddressValidityRange(), "");
	}
}
