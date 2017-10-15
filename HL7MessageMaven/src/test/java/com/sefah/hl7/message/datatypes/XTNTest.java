package com.sefah.hl7.message.datatypes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.sefah.hl7.message.components.HL7Encoding;
import com.sefah.hl7.message.components.HL7Repetition;

public class XTNTest {

	@Test
	public void testName() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("(415)555-3210^ORN^FX^", new HL7Encoding());
		final XTN cx = new XTN(hl7Repetition);

		assertEquals(cx.getAreaCode(), "");
		assertEquals(cx.getCountryCode(), "");
		assertEquals(cx.getEmailAddress(), "");
		assertEquals(cx.getEquipmentType(), "FX");
		assertEquals(cx.getExtension(), "");
		assertEquals(cx.getPhoneNumber(), "");
		assertEquals(cx.getTelephoneNumber(), "(415)555-3210");
		assertEquals(cx.getText(), "");
		assertEquals(cx.getUseCode(), "ORN");

	}

	@Test
	public void testName2() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("^NET^Internet^Alfons.Meier@xy-domain.de",
				new HL7Encoding());
		final XTN cx = new XTN(hl7Repetition);

		assertEquals(cx.getAreaCode(), "");
		assertEquals(cx.getCountryCode(), "");
		assertEquals(cx.getEmailAddress(), "Alfons.Meier@xy-domain.de");
		assertEquals(cx.getEquipmentType(), "Internet");
		assertEquals(cx.getExtension(), "");
		assertEquals(cx.getPhoneNumber(), "");
		assertEquals(cx.getTelephoneNumber(), "");
		assertEquals(cx.getText(), "");
		assertEquals(cx.getUseCode(), "NET");
	}

	@Test
	public void testName3() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("^PRN^FX^^49^40^7654322^^^^^040/7654322",
				new HL7Encoding());
		final XTN cx = new XTN(hl7Repetition);

		assertEquals(cx.getAreaCode(), "40");
		assertEquals(cx.getCountryCode(), "49");
		assertEquals(cx.getEmailAddress(), "");
		assertEquals(cx.getEquipmentType(), "FX");
		assertEquals(cx.getExtension(), "");
		assertEquals(cx.getPhoneNumber(), "7654322");
		assertEquals(cx.getTelephoneNumber(), "");
		assertEquals(cx.getText(), "");
		assertEquals(cx.getUseCode(), "PRN");
	}

	@Test
	public void testName4() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("^PRN^PH^^49^40^7654321^^^^^040/7654321",
				new HL7Encoding());
		final XTN cx = new XTN(hl7Repetition);

		assertEquals(cx.getAreaCode(), "40");
		assertEquals(cx.getCountryCode(), "49");
		assertEquals(cx.getEmailAddress(), "");
		assertEquals(cx.getEquipmentType(), "PH");
		assertEquals(cx.getExtension(), "");
		assertEquals(cx.getPhoneNumber(), "7654321");
		assertEquals(cx.getTelephoneNumber(), "");
		assertEquals(cx.getText(), "");
		assertEquals(cx.getUseCode(), "PRN");
	}
}
