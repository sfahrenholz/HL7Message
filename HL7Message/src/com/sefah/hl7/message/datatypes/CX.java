package com.sefah.hl7.message.datatypes;

import com.sefah.hl7.message.components.HL7Repetition;

/**
 * Components: <ID (ST)> ^ <check digit (ST)> ^ <code identifying the check
 * digit scheme employed (ID)> ^ < assigning authority (HD)> ^ <identifier type
 * code (ID)> ^ < assigning facility (HD) ^ <effective date (DT)> ^ <expiration
 * date (DT)>
 *
 * Length: 250
 *
 * Example:
 * 
 * |1234567^4^M11^ADT01^MR^University Hospital| This data type is used for
 * specifying an identifier with its associated administrative detail.
 * 
 * @author Sebastian Fahrenholz
 */
public class CX extends Datatype implements CXInterface {

	public CX(final HL7Repetition datatype) {
		super(datatype);
	}

	/**
	 * Definition: The value of the identifier itself. It is similar to the CK data
	 * type except that a ST data type is used instead of a NM data type.
	 */
	@Override
	public String getId() {
		return repetitionValue.getHL7ComponentValue(0);
	}

	/**
	 * The check digit in this data type is not an add-on produced by the message
	 * processor. It is the check digit that is part of the identifying number used
	 * in the sending application. If the sending application does not include a
	 * self-generated check digit in the identifying number, this component should
	 * be valued null. Many identifiers (eg Australian provider numbers) have check
	 * digits built into the identifier and this field is not used in that case.
	 */
	@Override
	public String getCheckDigit() {
		return repetitionValue.getHL7ComponentValue(1);
	}

	/**
	 * This field is not usually used in Australia. The international standard
	 * defines several check digit scheme codes than can be used when the ID is
	 * numeric. The use of this field in Australia is by site specific agreement.
	 * 
	 * Note: The check digit and code identifying check digit scheme are null if ID
	 * is alphanumeric.
	 */
	@Override
	public String getCheckDigitCodeScheme() {
		return repetitionValue.getHL7ComponentValue(2);
	}

	/**
	 * The assigning authority is a unique name of the system (or organization or
	 * agency or department) that creates the data. It is a HD data type.
	 * User-defined Table 0363 – Assigning authority is used as the HL7 identifier
	 * for the user-defined table of values for the first sub-component of the HD
	 * component, <namespace ID>.
	 */
	@Override
	public String getAssigningAuthority() {
		return repetitionValue.getHL7ComponentValue(3);
	}

	/**
	 * A code corresponding to the type of identifier. In some cases, this code may
	 * be used as a qualifier to the “Assigning authority” component. Refer to HL7
	 * Table 0203 - Identifier type for suggested values.
	 */
	@Override
	public String getIdentifierTypeCode() {
		return repetitionValue.getHL7ComponentValue(4);
	}

	/**
	 * Subcomponents: <namespace ID (IS)> & < universal ID (ST)> & <universal ID
	 * type (ID)>
	 * 
	 * Definition: The place or location identifier where the identifier was first
	 * assigned to the patient. This component is not an inherent part of the
	 * identifier but rather part of the history of the identifier: as part of this
	 * data type, its existence is a convenience for certain intercommunicating
	 * systems.
	 */
	@Override
	public String getAssigningFacility() {
		return repetitionValue.getHL7ComponentValue(5);
	}

	/**
	 * Definition: The first date, if known, on which the identifier is valid and
	 * active.
	 * 
	 * @return
	 */
	public String getEffectiveDate() {
		return repetitionValue.getHL7ComponentValue(6);
	}

	/**
	 * Definition: The last date, if known, on which the identifier is valid and
	 * active.
	 * 
	 * @return
	 */
	public String getExpirationDate() {
		return repetitionValue.getHL7ComponentValue(7);
	}
}
