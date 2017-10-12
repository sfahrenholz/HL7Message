package com.sefah.hl7.message.datatypes;

// extended common name
public interface XPNInterface {
    String getFamilyName();
    String getGivenName();
    String getMiddleName();
    String getSuffix();
    String getPrefix();
    String getDegree();
    String getNameTypeCode();
    String getNameRepresentationCode();
}