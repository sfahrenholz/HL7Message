package com.sefah.hl7.message.datatypes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.sefah.hl7.message.components.HL7Encoding;
import com.sefah.hl7.message.components.HL7Repetition;

public class PLTest {

	@Test
	public void testName() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("4E^136^B^CommunityHospital^^N^^^", new HL7Encoding());
		final PL cx = new PL(hl7Repetition);

		assertEquals(cx.getBuilding(), "");
		assertEquals(cx.getBed(), "B");
		assertEquals(cx.getFacility(), "CommunityHospital");
		assertEquals(cx.getFloor(), "");
		assertEquals(cx.getLocationDescription(), "");
		assertEquals(cx.getLocationStatus(), "");
		assertEquals(cx.getPersonLocationType(), "N");
		assertEquals(cx.getPointOfCare(), "4E");
		assertEquals(cx.getRoom(), "136");

	}
	
	@Test
	public void testName2() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("InternalMedicine^^^UniversityHospitals^^C^Briones^3^", new HL7Encoding());
		final PL cx = new PL(hl7Repetition);
		
		assertEquals(cx.getBuilding(), "Briones");
		assertEquals(cx.getBed(), "");
		assertEquals(cx.getFacility(), "UniversityHospitals");
		assertEquals(cx.getFloor(), "3");
		assertEquals(cx.getLocationDescription(), "");
		assertEquals(cx.getLocationStatus(), "");
		assertEquals(cx.getPersonLocationType(), "C");
		assertEquals(cx.getPointOfCare(), "InternalMedicine");
		assertEquals(cx.getRoom(), "");
		
	}
}
