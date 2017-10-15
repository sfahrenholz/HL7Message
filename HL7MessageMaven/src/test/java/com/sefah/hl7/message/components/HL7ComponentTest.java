package com.sefah.hl7.message.components;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class HL7ComponentTest {

	@Test
	public void testInitalizationWithoutSubComponent() throws Exception {
		final HL7Component com = new HL7Component("Comp2", new HL7Encoding());
		assertEquals(com.getComponentValue(),"Comp2");
		assertEquals(com.getHL7SubComponentCount(),1);
		
		assertEquals(com.getHL7SubComponent(-1), null);
		assertNotEquals(com.getHL7SubComponent(0), null);
		assertEquals(com.getHL7SubComponent(1), null);
		assertEquals(com.getHL7SubComponentValue(-1),"");
		assertEquals(com.getHL7SubComponentValue(0),"Comp2");
		assertEquals(com.getHL7SubComponentValue(1),"");

		final HL7SubComponent hl7SubComponent = com.getHL7SubComponent(0);
		assertEquals(hl7SubComponent.getSubComponentValue(),"Comp2");
	}

	@Test
	public void testInitalizationWithSubComponent() throws Exception {
		final HL7Component com = new HL7Component("Comp2&SubComp2", new HL7Encoding());
		assertEquals(com.getComponentValue(),"Comp2&SubComp2");
		assertEquals(com.getHL7SubComponentCount(),2);
		assertEquals(com.getHL7SubComponent(-1), null);
		assertNotEquals(com.getHL7SubComponent(0), null);
		assertNotEquals(com.getHL7SubComponent(1), null);
		assertEquals(com.getHL7SubComponentValue(-1),"");
		assertEquals(com.getHL7SubComponentValue(0),"Comp2");
		assertEquals(com.getHL7SubComponentValue(1),"SubComp2");
		assertEquals(com.getHL7SubComponentValue(2),"");

		HL7SubComponent hl7SubComponent = com.getHL7SubComponent(0);
		assertEquals(hl7SubComponent.getSubComponentValue(),"Comp2");
		hl7SubComponent = com.getHL7SubComponent(1);
		assertEquals(hl7SubComponent.getSubComponentValue(),"SubComp2");
	}
}
