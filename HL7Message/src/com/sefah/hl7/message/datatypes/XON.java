package com.sefah.hl7.message.datatypes;

import com.sefah.hl7.message.components.HL7Repetition;

/**
 * XON - extended composite name and identification number for organizations
 * 
 * Components: <organization name (ST)> ^ <organization name type code (IS)> ^
 * <ID number (NM)> ^<check digit (NM)> ^ <code identifying the check digit
 * scheme employed (ID)> ^ <assigning authority (HD)> ^ <identifier type code
 * (IS)> ^ <assigning facility ID (HD)> ^ <name representation code(ID)>
 * 
 * Subcomponents of assigning authority: <namespace ID (IS)> & <universal ID
 * (ST)> & <universal ID type (ID)>
 * 
 * Subcomponents of assigning facility: <namespace ID (IS)> & <universal ID
 * (ST)> & <universal ID type (ID)>
 * 
 * Length: 250
 * 
 * This data type is used in fields (e.g., PV2-23, NK1-13, PD1-3, OBR-44) to
 * specify the name and ID number of an organization.
 * 
 * @author Sebastian Fahrenholz
 *
 */
public class XON extends Datatype {

	public XON(HL7Repetition datatype) {
		super(datatype);
	}

	/**
	 * The name of the specified organization.
	 * 
	 * @return
	 */
	public String getOrganizationName() {
		return repetitionValue.getHL7ComponentValue(0);
	}

	/**
	 * A code that represents the type of name i.e., legal name, display name. Refer
	 * to User-defined Table 0204 - Organizational name type for suggested values. 
	 * 
	 * @return
	 */
	public String getOrganizationNameTypeCode() {
		return repetitionValue.getHL7ComponentValue(1);
	}

	public String getIdNumber() {
		return repetitionValue.getHL7ComponentValue(2);
	}

	/**
	 * The check digit in this data type is not an add-on produced by the message
	 * processor. It is the check digit that is part of the identifying number used
	 * in the sending application. If the sending application does not include a
	 * self-generated check digit in the identifying number, this component should
	 * be valued null.
	 * 
	 * @return
	 */
	public String getCheckDigit() {
		return repetitionValue.getHL7ComponentValue(3);
	}

	/**
	 * The check digit scheme codes are defined in HL7 Table 0061 - Check digit
	 * scheme.
	 * 
	 * @return
	 */
	public String getCodeIdentifyingTheCheckDigitSchemeEmployed() {
		return repetitionValue.getHL7ComponentValue(4);
	}

	/**
	 * The assigning authority is a unique identifier of the system (or organization
	 * or agency or department) that creates the data. Assigning authorities are
	 * unique across a given HL7 implementation. User-defined Table 0363 – Assigning
	 * authority is used as the HL7 identifier for the user-defined table of values
	 * for the first sub-component of the HD component <namespace ID>.
	 * 
	 * @return
	 */
	public String getAssigningAuthority() {
		return repetitionValue.getHL7ComponentValue(5);
	}

	/**
	 * A code corresponding to the type of identifier. In some cases, this code may
	 * be used as a qualifier to the “Assigning authority” component. Refer to HL7
	 * Table 0203 -Identifier type for suggested values.
	 * 
	 * @return
	 */
	public String getIdentifierTypeCode() {
		return repetitionValue.getHL7ComponentValue(6);
	}

	/**
	 * The place or location identifier where the identifier was first assigned to
	 * the person. This component is not an inherent part of the identifier but
	 * rather part of the history of the identifier: as part of this data type, its
	 * existence is a convenience for certain intercommunicating systems.
	 * 
	 * @return
	 */
	public String getAssigningFacilityId() {
		return repetitionValue.getHL7ComponentValue(7);
	}

	/**
	 * Different <name/address types> and representations of the same <name/address>
	 * should be described by repeating of this field, with different values of the
	 * <name/address type> and/or <name/address representation> component.
	 * 
	 * Note: This new component remains in “alphabetic” representation with each
	 * repetition of the field using these data types, i.e. even though the name may
	 * be represented in an ideographic character set, this component will remain
	 * represented in an alphabetic character set.
	 * 
	 * @return
	 */
	public String getNameRepresentationCode() {
		return repetitionValue.getHL7ComponentValue(8);
	}
}
