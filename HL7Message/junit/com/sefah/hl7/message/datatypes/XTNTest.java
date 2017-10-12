package com.sefah.hl7.message.datatypes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.sefah.hl7.message.components.HL7Encoding;
import com.sefah.hl7.message.components.HL7Repetition;

public class XTNTest {

	@Test
	public void testName() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("(415)555-3210^ORN^FX^", new HL7Encoding());
		final XTN cx = new XTN(hl7Repetition);

		assertThat(cx.getAreaCode(), is(""));
		assertThat(cx.getCountryCode(), is(""));
		assertThat(cx.getEmailAddress(), is(""));
		assertThat(cx.getEquipmentType(), is("FX"));
		assertThat(cx.getExtension(), is(""));
		assertThat(cx.getPhoneNumber(), is(""));
		assertThat(cx.getTelephoneNumber(), is("(415)555-3210"));
		assertThat(cx.getText(), is(""));
		assertThat(cx.getUseCode(), is("ORN"));

	}

	@Test
	public void testName2() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("^NET^Internet^Alfons.Meier@xy-domain.de",
				new HL7Encoding());
		final XTN cx = new XTN(hl7Repetition);

		assertThat(cx.getAreaCode(), is(""));
		assertThat(cx.getCountryCode(), is(""));
		assertThat(cx.getEmailAddress(), is("Alfons.Meier@xy-domain.de"));
		assertThat(cx.getEquipmentType(), is("Internet"));
		assertThat(cx.getExtension(), is(""));
		assertThat(cx.getPhoneNumber(), is(""));
		assertThat(cx.getTelephoneNumber(), is(""));
		assertThat(cx.getText(), is(""));
		assertThat(cx.getUseCode(), is("NET"));
	}

	@Test
	public void testName3() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("^PRN^FX^^49^40^7654322^^^^^040/7654322",
				new HL7Encoding());
		final XTN cx = new XTN(hl7Repetition);

		assertThat(cx.getAreaCode(), is("40"));
		assertThat(cx.getCountryCode(), is("49"));
		assertThat(cx.getEmailAddress(), is(""));
		assertThat(cx.getEquipmentType(), is("FX"));
		assertThat(cx.getExtension(), is(""));
		assertThat(cx.getPhoneNumber(), is("7654322"));
		assertThat(cx.getTelephoneNumber(), is(""));
		assertThat(cx.getText(), is(""));
		assertThat(cx.getUseCode(), is("PRN"));
	}

	@Test
	public void testName4() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("^PRN^PH^^49^40^7654321^^^^^040/7654321",
				new HL7Encoding());
		final XTN cx = new XTN(hl7Repetition);

		assertThat(cx.getAreaCode(), is("40"));
		assertThat(cx.getCountryCode(), is("49"));
		assertThat(cx.getEmailAddress(), is(""));
		assertThat(cx.getEquipmentType(), is("PH"));
		assertThat(cx.getExtension(), is(""));
		assertThat(cx.getPhoneNumber(), is("7654321"));
		assertThat(cx.getTelephoneNumber(), is(""));
		assertThat(cx.getText(), is(""));
		assertThat(cx.getUseCode(), is("PRN"));
	}
}
