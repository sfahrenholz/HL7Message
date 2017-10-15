package com.sefah.hl7.message.datatypes;

import com.sefah.hl7.message.components.HL7Repetition;

/**
 * XTN - extended telecommunication number

Components: [NNN] [(999)]999-9999 [X99999] [B99999] [C any text] ^ <telecommunication use code (ID)> ^ <telecommunication equipment type (ID)> ^ <email address (ST)> ^ <country code (NM)> ^ <area/city code (NM)> ^ <phone number (NM)> ^ <extension (NM)> ^ <any text (ST)>

Note: Replaces TN data type as of v 2.3

Length: 250
 * @author Sebastian Fahrenholz
 *
 */
public class XTN extends Datatype {

	public XTN(final HL7Repetition datatype) {
		super(datatype);
	}

	/**
	 * Defined as the TN data type (see HL7 International v2.4 Section 2.9.45, TN - telephone number), except that the length of the country access code has been increased to three.
	 * @return
	 */
	public String getTelephoneNumber() {
		return repetitionValue.getHL7ComponentValue(0);
	}

	/**
	 * A code that represents a specific use of a telecommunication number. Refer to HL7 Table 0201 - Telecommunication use code for valid values.
	 * @return
	 */
	public String getUseCode() {
		return repetitionValue.getHL7ComponentValue(1);
	}

	/**
	 * A code that represents the type of telecommunication equipment. Refer to HL7 Table 0202 - Telecommunication equipment type for valid values.
	 * @return
	 */
	public String getEquipmentType() {
		return repetitionValue.getHL7ComponentValue(2);
	}

	/**
	 * nternationalization note:  To make this data type interoperate with CENs Telecommunication data attribute group, we allow use of the second component for email addresses. The presence of an email address is specified by the addition of the value NET  to the Phone Use Code table, and the type of Internet address is specified with the values Internet  and X.400  to the Phone Equipment Type table. When used for an Internet address, the first component of the XTN data type will be null. If the @-sign is being used as a subcomponent delimiter, the HL7 subcomponent escape sequence may be used when encoding an Internet address (see HL7 International v2.4 Section 2.10.1, Formatting codes).
	 * @return
	 */
	public String getEmailAddress() {
		return repetitionValue.getHL7ComponentValue(3);
	}

	public String getCountryCode() {
		return repetitionValue.getHL7ComponentValue(4);
	}

	public String getAreaCode() {
		return repetitionValue.getHL7ComponentValue(5);
	}

	public String getPhoneNumber() {
		return repetitionValue.getHL7ComponentValue(6);
	}

	public String getExtension() {
		return repetitionValue.getHL7ComponentValue(7);
	}

	public String getText() {
		return repetitionValue.getHL7ComponentValue(8);
	}
}
