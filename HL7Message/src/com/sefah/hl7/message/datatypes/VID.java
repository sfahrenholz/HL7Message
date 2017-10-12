package com.sefah.hl7.message.datatypes;

import com.sefah.hl7.message.components.HL7Repetition;

/**
 * VID – version identifier
 * 
 * Components: <version ID (ID)> ^ <internationalization code (CE)> ^
 * <international version ID (CE)
 * 
 * @author Sebastian Fahrenholz
 *
 */
public class VID extends Datatype {

	public VID(HL7Repetition datatype) {
		super(datatype);
	}

	/**
	 * Used to identify the HL7 version. Refer to HL7 Table 0104 - Version ID for
	 * valid values.
	 */
	public String getVersionId() {
		return repetitionValue.getHL7ComponentValue(0);
	}

	/**
	 * Used to identify the international affiliate country code. The values to be
	 * used are those of ISO 3166 - 1:1977. The ISO 3166 table has three separate
	 * forms of the country code: HL7 specifies that the 3-character (alphabetic)
	 * form be used for the country code. * @return
	 */
	public String getInternationalizationCode() {
		return repetitionValue.getHL7ComponentValue(1);
	}

	/**
	 * This field component identifies international affiliate’s version; it is
	 * especially important when the international affiliate has more than a single
	 * local version associated with a single US version.
	 */
	public String getInternationalVersionID() {
		return repetitionValue.getHL7ComponentValue(2);
	}
}
