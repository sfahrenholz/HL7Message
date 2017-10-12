package com.sefah.hl7.message.datatypes;

public interface CXInterface {
    String getId();
    String getCheckDigit();
    String getCheckDigitCodeScheme();
    String getAssigningAuthority();
    String getIdentifierTypeCode();
    String getAssigningFacility();
}
