package com.sefah.hl7.message.datatypes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.sefah.hl7.message.components.HL7Encoding;
import com.sefah.hl7.message.components.HL7Repetition;

public class PLTest {

	@Test
	public void testName() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("4E^136^B^CommunityHospital^^N^^^", new HL7Encoding());
		final PL cx = new PL(hl7Repetition);

		assertThat(cx.getBuilding(), is(""));
		assertThat(cx.getBed(), is("B"));
		assertThat(cx.getFacility(), is("CommunityHospital"));
		assertThat(cx.getFloor(), is(""));
		assertThat(cx.getLocationDescription(), is(""));
		assertThat(cx.getLocationStatus(), is(""));
		assertThat(cx.getPersonLocationType(), is("N"));
		assertThat(cx.getPointOfCare(), is("4E"));
		assertThat(cx.getRoom(), is("136"));

	}
	
	@Test
	public void testName2() throws Exception {
		final HL7Repetition hl7Repetition = new HL7Repetition("InternalMedicine^^^UniversityHospitals^^C^Briones^3^", new HL7Encoding());
		final PL cx = new PL(hl7Repetition);
		
		assertThat(cx.getBuilding(), is("Briones"));
		assertThat(cx.getBed(), is(""));
		assertThat(cx.getFacility(), is("UniversityHospitals"));
		assertThat(cx.getFloor(), is("3"));
		assertThat(cx.getLocationDescription(), is(""));
		assertThat(cx.getLocationStatus(), is(""));
		assertThat(cx.getPersonLocationType(), is("C"));
		assertThat(cx.getPointOfCare(), is("InternalMedicine"));
		assertThat(cx.getRoom(), is(""));
		
	}
}
