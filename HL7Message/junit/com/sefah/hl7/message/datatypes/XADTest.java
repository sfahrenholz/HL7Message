package com.sefah.hl7.message.datatypes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.sefah.hl7.message.components.HL7Encoding;
import com.sefah.hl7.message.components.HL7Repetition;

public class XADTest {
	@Test
	public void testName() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("1234 Easy St.^Ste. 123^San Francisco^CA^95123^USA^B^^SF^", new HL7Encoding());
		final XAD cx = new XAD(hl7Repetition);

		assertThat(cx.getAddressRepresentationCode(), is(""));
		assertThat(cx.getAddressType(), is("B"));
		assertThat(cx.getCensusTract(), is(""));
		assertThat(cx.getCity(), is("San Francisco"));
		assertThat(cx.getCountry(), is("USA"));
		assertThat(cx.getCountyCode(), is("SF"));
		assertThat(cx.getOtherDesignation(), is("Ste. 123"));
		assertThat(cx.getOtherGeographicDesignation(), is(""));
		assertThat(cx.getPostCode(), is("95123"));
		assertThat(cx.getProvince(), is("CA"));
		assertThat(cx.getStreetAddress(), is("1234 Easy St."));
		assertThat(cx.getAddressValidityRange(), is(""));
	}
}
