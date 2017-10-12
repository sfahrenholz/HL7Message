package com.sefah.testresource;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HL7TestResourceManager {
	
	public static final String HL7_MESSAGE_ORU_R01 = "HL7MessageTest_ORU_R01.hl7";
	public static final String HL7_MESSAGE_ORU_R01_SIMPLE = "HL7MessageTest_ORU_R01_Simple.hl7";
	
	private HL7TestResourceManager() {
		// SQ
	}

	public static String getHL7TestFileString(final String ressource) throws IOException, URISyntaxException {
		URL resource = HL7TestResourceManager.class.getResource(ressource);
		return new String(Files.readAllBytes(Paths.get(resource.toURI())));
	}
}
