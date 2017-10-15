package com.sefah.hl7.message.components;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.sefah.hl7.exception.HL7EncodingException;

public class HL7EncodingTest {

	@Test
	public void testDefaultHL7Encoding() throws Exception {
		final HL7Encoding encoding = new HL7Encoding();
		assertEquals(encoding.getComponentSeperator(),"^");
		assertEquals(encoding.getEscapeCharacter(),"\\");
		assertEquals(encoding.getFieldSeperator(),"|");
		assertEquals(encoding.getLineSeperator(),"\r");
		assertEquals(encoding.getRepetitionSeperator(),"~");
		assertEquals(encoding.getSubcomponentSeperator(),"&");
		assertEquals(encoding.getMSH2Field(),"|^~\\&");

		assertEquals(encoding.isSeperator(encoding.getComponentSeperator()),true);
		assertEquals(encoding.isSeperator(encoding.getEscapeCharacter()),false);
		assertEquals(encoding.isSeperator(encoding.getFieldSeperator()),true);
		assertEquals(encoding.isSeperator(encoding.getLineSeperator()),false);
		assertEquals(encoding.isSeperator(encoding.getRepetitionSeperator()),true);
		assertEquals(encoding.isSeperator(encoding.getSubcomponentSeperator()),true);

		assertNotEquals(encoding.toString(), null);
	}

	@Test
	public void testHL7Encoding() throws Exception {
		final HL7Encoding encoding = new HL7Encoding("#+~\\/");
		assertEquals(encoding.getEscapeCharacter(),"\\");
		assertEquals(encoding.getFieldSeperator(),"#");
		assertEquals(encoding.getRepetitionSeperator(),"~");
		assertEquals(encoding.getComponentSeperator(),"+");
		assertEquals(encoding.getSubcomponentSeperator(),"/");
		assertEquals(encoding.getLineSeperator(),"\r");
		assertEquals(encoding.getMSH2Field(),"#+~\\/");

		assertEquals(encoding.isSeperator(encoding.getComponentSeperator()),true);
		assertEquals(encoding.isSeperator(encoding.getEscapeCharacter()),false);
		assertEquals(encoding.isSeperator(encoding.getFieldSeperator()),true);
		assertEquals(encoding.isSeperator(encoding.getLineSeperator()),false);
		assertEquals(encoding.isSeperator(encoding.getRepetitionSeperator()),true);
		assertEquals(encoding.isSeperator(encoding.getSubcomponentSeperator()),true);

		assertNotEquals(encoding.toString(), null);
	}

	@Test
	public void testHL7EncodingNULL() throws Exception {
		
		Throwable exception = assertThrows(HL7EncodingException.class, () -> {
			new HL7Encoding(null);
	    });
	    assertEquals(exception.getClass().getName(),HL7EncodingException.class.getName());
	}

	@Test
	public void testHL7EncodingLength() throws Exception {
		Throwable exception = assertThrows(HL7EncodingException.class, () -> {
			new HL7Encoding("A");
	    });
	    assertEquals(exception.getClass().getName(),HL7EncodingException.class.getName());
	}
}
