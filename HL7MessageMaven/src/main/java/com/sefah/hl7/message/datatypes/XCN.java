package com.sefah.hl7.message.datatypes;

import com.sefah.hl7.message.components.HL7Repetition;

/**
 * XCN - extended composite ID number and name for persons
 * 
 * Components: <ID number (ST)> ^ <family name (FN)> ^ <given name (ST)> ^
 * <second and further given names or initials thereof (ST)> ^ <suffix (e.g., JR
 * or III) (ST)> ^ <prefix (e.g., DR) (ST)> ^ <degree (e.g., MD) (IS)> ^ <source
 * table (IS)> ^ <assigning authority (HD)> ^ <name type code (ID)> ^
 * <identifier check digit (ST)> ^ <code identifying the check digit scheme
 * employed (ID)> ^ <identifier type code (IS)> ^ <assigning facility (HD)> ^
 * <name representation code (ID)> ^ <name context (CE)> ^ <name validity range
 * (DR)> ^ <name assembly order (ID)>
 * 
 * Subcomponents of family name: <surname (ST)> & <own surname prefix (ST)> &
 * <own surname (ST)> & <surname prefix from partner/spouse (ST)> & <surname
 * from partner/spouse (ST)>
 * 
 * Subcomponents of assigning authority: <namespace ID (IS)> & <universal ID
 * (ST)> & <universal ID type (ID)>
 * 
 * Subcomponents of assigning facility: <namespace ID (IS)> & <universal ID
 * (ST)> & <universal ID type (ID)>
 * 
 * Subcomponents of name context: <identifier (ST)> & <text (ST)> & <name of
 * coding system (IS)> & <alternate identifier (ST)> & <alternate text (ST)> &
 * <name of alternate coding system (IS)>
 * 
 * Subcomponents of name validity range: <date range start date/time (TS)> &
 * <date range end date/time (TS)>
 * 
 * @author Sebastian Fahrenholz
 *
 */
public class XCN extends Datatype implements XPNInterface, CXInterface {
	public XCN(final HL7Repetition datatype) {
		super(datatype);
	}

	/**
	 * This string refers to the coded ID according to a user-defined table, defined
	 * by the 9th component. If the first component is present, either the source
	 * table or the assigning authority must be valued.
	 */
	@Override
	public String getId() {
		return repetitionValue.getHL7ComponentValue(0);
	}

	/**
	 * This component allows full specification of the surname of a person. Where
	 * appropriate, it differentiates the person's own surname from that of the
	 * person's partner or spouse, in cases where the person's name may contain
	 * elements from either name. It also permits messages to distinguish the
	 * surname prefix (such as "van" or "de") from the surname root.
	 */
	@Override
	public String getFamilyName() {
		return repetitionValue.getHL7ComponentValue(1);
	}

	/**
	 * First name.
	 */
	@Override
	public String getGivenName() {
		return repetitionValue.getHL7ComponentValue(2);
	}

	/**
	 * Multiple middle names may be included by separating them with spaces.
	 */
	@Override
	public String getMiddleName() {
		return repetitionValue.getHL7ComponentValue(3);
	}

	/**
	 * Used to specify a name suffix (e.g., Jr. or III).
	 */
	@Override
	public String getSuffix() {
		return repetitionValue.getHL7ComponentValue(4);
	}

	/**
	 * Used to specify a name prefix (e.g., Dr.).
	 */
	@Override
	public String getPrefix() {
		return repetitionValue.getHL7ComponentValue(5);
	}

	/**
	 * Used to specify an educational degree (e.g., MD). Refer to User-defined Table
	 * 0360  Degree for suggested values.
	 */
	@Override
	public String getDegree() {
		return repetitionValue.getHL7ComponentValue(6);
	}

	/**
	 * User-defined Table 0297  CN ID source is used as the HL7 identifier for the
	 * user-defined table of values for this component. Used to delineate the first
	 * component.
	 * 
	 * @return
	 */
	public String getSourceTable() {
		return repetitionValue.getHL7ComponentValue(7);
	}

	/**
	 * The assigning authority is a unique identifier of the system (or organization
	 * or agency of department) that creates the data.
	 * 
	 * User-defined Table 0363  Assigning authority is used as the HL7 identifier
	 * for the userdefined table of values for the first sub-component of the HD
	 * component, <namespace ID>.
	 */
	@Override
	public String getAssigningAuthority() {
		return repetitionValue.getHL7ComponentValue(8);
	}

	/**
	 * A code that represents the type of name. Refer to HL7 Table 0200 - Name type
	 * for valid values.
	 */
	@Override
	public String getNameTypeCode() {
		return repetitionValue.getHL7ComponentValue(9);
	}

	/**
	 * The check digit in this data type is not an add-on produced by the message
	 * processor. It is the check digit that is part of the identifying number used
	 * in the sending application. If the sending application does not include a
	 * self-generated check digit in the identifying number, this component should
	 * be valued null.
	 */
	@Override
	public String getCheckDigit() {
		return repetitionValue.getHL7ComponentValue(10);
	}

	/**
	 * Refer to HL7 Table 0061 - Check digit scheme for valid values.
	 */
	@Override
	public String getCheckDigitCodeScheme() {
		return repetitionValue.getHL7ComponentValue(11);
	}

	/**
	 * A code corresponding to the type of identifier. In some cases, this code may
	 * be used as a qualifier to the <assigning authority> component. Refer to HL7
	 * Table 0203 - Identifier type for suggested values.
	 */
	@Override
	public String getIdentifierTypeCode() {
		return repetitionValue.getHL7ComponentValue(12);
	}

	/**
	 * The place or location identifier where the identifier was first assigned to
	 * the person. This component is not an inherent part of the identifier but
	 * rather part of the history of the identifier: as part of this data type, its
	 * existence is a convenience for certain intercommunicating systems.
	 */
	@Override
	public String getAssigningFacility() {
		return repetitionValue.getHL7ComponentValue(13);
	}

	/**
	 * Different <name/address types> and representations of the same <name/address>
	 * should be described by repeating of this field, with different values of the
	 * <name/address type> and/or <name/address representation> component.
	 */
	@Override
	public String getNameRepresentationCode() {
		return repetitionValue.getHL7ComponentValue(14);
	}

	/**
	 * This component is used to designate the context in which a name is used. The
	 * main use case is in Australian healthcare for indigenous patients who prefer
	 * to use different names when attending different healthcare institutions.
	 * Another use case occurs in the US where health practitioners can be licensed
	 * under slightly different names and the reporting of the correct name is vital
	 * for administrative purposes. Refer to User-defined Table 0448  Name context
	 * for suggested values
	 */
	public String getNameContext() {
		return repetitionValue.getHL7ComponentValue(15);
	}

	/**
	 * This component contains the start and end date/times that define the period
	 * during which this name was valid. See DR - date/time range for description of
	 * subcomponents.
	 */
	public String getNameValidityRange() {
		return repetitionValue.getHL7ComponentValue(16);
	}

	/**
	 * A code that represents the preferred display order of the components of this
	 * person name.
	 */
	public String getNameAssemblyOorder() {
		return repetitionValue.getHL7ComponentValue(17);
	}
}
