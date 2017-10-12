package com.sefah.hl7.message.datatypes;

import com.sefah.hl7.message.components.HL7Repetition;

/**
 * XPN - extended person name
 * 
 * Components: In Version 2.3, replaces the PN data type. <family name (FN)> ^
 * <given name (ST)> ^ <second and further given names or initials thereof (ST)>
 * ^ <suffix (e.g., JR or III) (ST)> ^ <prefix (e.g., DR) (ST)> ^ <degree (e.g.,
 * MD) (IS)> ^ <name type code (ID) > ^ <name representation code (ID)> ^ <name
 * context (CE)> ^ <name validity range (DR)> ^ <name assembly order (ID)>
 * 
 * Subcomponents of family name: <surname (ST)> ^ <own surname prefix (ST)> ^
 * <own surname (ST)> ^<surname prefix from partner/spouse (ST)> ^ <surname from
 * partner/spouse (ST)>
 * 
 * Subcomponents of name context: <identifier (ST)> & <text (ST)> & <name of
 * coding system (IS)> &<alternate identifier (ST)> & <alternate text (ST)> &
 * <name of alternate coding system (IS)>
 * 
 * Subcomponents of name validity range: <date range start date/time (TS)> &
 * <date range end date/time (TS)>
 * 
 * Length: 250
 * 
 * Note: Replaces PN data type as of v 2.3.
 * 
 * @author Sebastian Fahrenholz
 *
 */
public class XPN extends Datatype implements XPNInterface {

	public XPN(final HL7Repetition datatype) {
		super(datatype);
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
		return repetitionValue.getHL7ComponentValue(0);
	}

	/**
	 * First name.
	 */
	@Override
	public String getGivenName() {
		return repetitionValue.getHL7ComponentValue(1);
	}

	/**
	 * Multiple middle names may be included by separating them with spaces.
	 */
	@Override
	public String getMiddleName() {
		return repetitionValue.getHL7ComponentValue(2);
	}

	/**
	 * Used to specify a name suffix (e.g., Jr. or III).
	 */
	@Override
	public String getSuffix() {
		return repetitionValue.getHL7ComponentValue(3);
	}

	/**
	 * Used to specify a name prefix (e.g., Dr.).
	 */
	@Override
	public String getPrefix() {
		return repetitionValue.getHL7ComponentValue(4);
	}

	/**
	 * Used to specify an educational degree (e.g., MD). Refer to User-defined Table
	 * 0360 – Degree for suggested values.
	 */
	@Override
	public String getDegree() {
		return repetitionValue.getHL7ComponentValue(5);
	}

	/**
	 * A code that represents the type of name. Refer to HL7 Table 0200 - Name type
	 * for valid values.
	 * 
	 * Note: The content of Legal Name is country specific. In the US the legal name
	 * is the same as the current married name.
	 */
	@Override
	public String getNameTypeCode() {
		return repetitionValue.getHL7ComponentValue(6);
	}

	/**
	 * Different <name/address types> and representations of the same <name/address>
	 * should be described by repeating of this field, with different values of the
	 * <name/address type> and/or <name/address representation> component.
	 * 
	 * Note: This new component remains in "alphabetic" representation with each
	 * repetition of the field using these data types. I.e. even though the name may
	 * be represented in an ideographic character set, this component will remain
	 * represented in an alphabetic character set.
	 */
	@Override
	public String getNameRepresentationCode() {
		return repetitionValue.getHL7ComponentValue(7);
	}

	/**
	 * Subcomponents of name context: <identifier (ID)> & <text (ST)> & <name of
	 * coding system (IS)> & <alternate identifier (ID)> & <alternate text (ST)> &
	 * <name of alternate coding system (IS)>
	 * 
	 * This component is used to designate the context in which a name is used. The
	 * main use case is in Australian healthcare for indigenous patients who prefer
	 * to use different names when attending different healthcare institutions.
	 * Another use case occurs in the US where health practitioners can be licensed
	 * under slightly different names and the reporting of the correct name is vital
	 * for administrative purposes. Refer to User-defined Table 0448 – Name context
	 * for suggested values.
	 * 
	 * 
	 * @return
	 */
	public String getNameContext() {
		return repetitionValue.getHL7ComponentValue(8);
	}

	/**
	 * This component contains the start and end date/times which define the period
	 * during which this name was valid. See "DR - date/time range" for description
	 * of subcomponents.
	 * 
	 * @return
	 */
	public String getNameValidityRange() {
		return repetitionValue.getHL7ComponentValue(9);
	}

	/**
	 * A code that represents the preferred display order of the components of this
	 * person name. Refer to HL7 Table 0444 – Name assembly order for valid values.
	 * 
	 * @return
	 */
	public String getNameAssemblyOrder() {
		return repetitionValue.getHL7ComponentValue(10);
	}

	public String getEffectiveDate() {
		return repetitionValue.getHL7ComponentValue(11);
	}

	public String getExpirationDate() {
		return repetitionValue.getHL7ComponentValue(12);
	}

	public String getProfessionalSuffix() {
		return repetitionValue.getHL7ComponentValue(13);
	}
}
