package com.sefah.hl7.message.datatypes;

import com.sefah.hl7.message.components.HL7Repetition;

/**
 * RP - reference pointer
 * 
 * Components: <pointer (ST) > ^ < application ID (HD)> ^ <type of data (ID)> ^
 * <subtype (ID)>
 * 
 * This data type transmits information about data stored on another system. It
 * contains a reference pointer that uniquely identifies the data on the other
 * system, the identity of the other system, and the type of data.
 * 
 * @author Sebastian Fahrenholz
 *
 */
public class RP extends Datatype {

	public RP(HL7Repetition datatype) {
		super(datatype);
	}

	/**
	 * A unique key assigned by the system that stores the data. The key, which is a
	 * ST data type, is used to identify and access the data.
	 * 
	 * @return
	 */
	public String getPointer() {
		return repetitionValue.getHL7ComponentValue(0);
	}

	/**
	 * Subcomponents: <namespace ID (IS)> & < universal ID (ST)> & <universal ID
	 * type (ID)>
	 * 
	 * A unique designator of the system that stores the data. It is a HD data type
	 * (See HD - hierarchic designator). Application ID’s must be unique across a
	 * given HL7 implementation.
	 * 
	 * @return
	 */
	public String getApplicationID() {
		return repetitionValue.getHL7ComponentValue(1);
	}

	/**
	 * An ID data type that declares the general type of data. Refer to HL7 Table
	 * 0191 - Type of referenced data for valid values.
	 * 
	 * @return
	 */
	public String getTypeOfData() {
		return repetitionValue.getHL7ComponentValue(2);
	}

	/**
	 * MIMEType
	 * 
	 * @return
	 */
	public String getSubtype() {
		return repetitionValue.getHL7ComponentValue(3);
	}

	/**
	 * Possible subtypes are specific to main types (though in principle the same
	 * subtype could be used for more than one main type), and so are defined under
	 * their main types.
	 * 
	 * Additional subtypes may be added to this Standard. In addition, private,
	 * non-standard subtypes may be defined by agreement between cooperating
	 * parties. All private, non-standard subtypes should begin with the letter Z to
	 * distinguish them from the standard subtypes.
	 * 
	 * @return
	 */
	public String getTypeSubtypeCombinations() {
		return repetitionValue.getHL7ComponentValue(4);
	}

}
