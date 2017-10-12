package com.sefah.hl7.message.datatypes;

import com.sefah.hl7.message.components.HL7Repetition;

/**
 * XAD - extended address
 *
 * Components: <street address (SAD)> ^ <other designation (ST)> ^ <city (ST)> ^
 * <state or province (ST)> ^ <zip or postal code (ST)> ^ <country (ID)> ^ <
 * address type (ID)> ^ <other geographic designation (ST)> ^ <county/parish
 * code (IS)> ^ <census tract (IS)> ^ <address representation code (ID)> ^
 * <address validity range (DR)>
 *
 * Subcomponents of street address (SAD): <street or mailing address (ST)> &
 * <street name (ST)> & <dwelling number (ST)>Subcomponents of address validity
 * range (DR): <date range start date/time (TS)> & <date range end date/time
 * (TS)>
 *
 *
 * @author Sebastian Fahrenholz
 *
 */
public class XAD extends Datatype {

	public XAD(final HL7Repetition datatype) {
		super(datatype);
	}

	/**
	 * Components: <street or mailing address (ST)> ^ <street name (ST)> ^ <dwelling
	 * number (ST)> Note: Appears ONLY in the XAD data type
	 * 
	 * @return
	 */
	public String getStreetAddress() {
		return repetitionValue.getHL7ComponentValue(0);
	}

	/**
	 * Second line of address. In US usage, it qualifies address. Examples: Suite
	 * 555 or Fourth Floor. When referencing an institution, this component
	 * specifies the street address.
	 * 
	 * @return
	 */
	public String getOtherDesignation() {
		return repetitionValue.getHL7ComponentValue(1);
	}

	/**
	 * This may be the name of the city, or district or place depending upon the
	 * national convention for formatting addresses for postal usage.
	 * 
	 * @return
	 */
	public String getCity() {
		return repetitionValue.getHL7ComponentValue(2);
	}

	/**
	 * State or province should be represented by the official postal service codes
	 * for that country.
	 * 
	 * @return
	 */
	public String getProvince() {
		return repetitionValue.getHL7ComponentValue(3);
	}

	/**
	 * Zip or postal codes should be represented by the official codes for that
	 * country. In the US, the zip code takes the form 99999[-9999], while the
	 * Canadian postal code takes the form A9A9A9, and the Australian Postcode takes
	 * the form 9999.
	 * 
	 * @return
	 */
	public String getPostCode() {
		return repetitionValue.getHL7ComponentValue(4);
	}

	/**
	 * Defines the country of the address. ISO 3166 provides a list of country codes
	 * that may be used. The ISO 3166 table has three separate forms of the country
	 * code: HL7 specifies that the 3-character (alphabetic)form be used for the
	 * country code. HL7 Table 0399 – Country code is defined to contain these
	 * 3-character codes.
	 * 
	 * @return
	 */
	public String getCountry() {
		return repetitionValue.getHL7ComponentValue(5);
	}

	/**
	 * Address type is optional and defined by HL7 Table 0190 - Address type.
	 * 
	 * @return
	 */
	public String getAddressType() {
		return repetitionValue.getHL7ComponentValue(6);
	}

	/**
	 * Other geographic designation includes county, bioregion, SMSA, etc.
	 * 
	 * @return
	 */
	public String getOtherGeographicDesignation() {
		return repetitionValue.getHL7ComponentValue(7);
	}

	/**
	 * A code that represents the county in which the specified address resides.
	 * User-defined Table 0289 - County/parish is used as the HL7 identifier for the
	 * user-defined table of values for this component. When this component is used
	 * to represent the county (or parish), component 8 <other geographic
	 * designation> should not duplicate it (i.e., the use of <other geographic
	 * designation> to represent the county is allowed only for the purpose of
	 * backward compatibility, and should be discouraged in this and future versions
	 * of HL7).
	 * 
	 * @return
	 */
	public String getCountyCode() {
		return repetitionValue.getHL7ComponentValue(8);
	}

	/**
	 * A code that represents the census tract in which the specified address
	 * resides. User-defined Table 0288 - Census tract is used as the HL7 identifier
	 * for the user-defined table of values for this component.
	 * 
	 * @return
	 */
	public String getCensusTract() {
		return repetitionValue.getHL7ComponentValue(9);
	}

	/**
	 * Different <name/address types> and representations of the same name/address
	 * should be described by repeating of this field, with different values of the
	 * <name/address type> and/or <name/address representation> component.
	 * 
	 * Note: Also note that this new component remains in "alphabetic"
	 * representation with each repetition of the fields using these data types.
	 * I.e. even though the address may be represented in an ideographic character
	 * set, this component will remain represented in an alphabetic character set.
	 * 
	 * @return
	 */
	public String getAddressRepresentationCode() {
		return repetitionValue.getHL7ComponentValue(10);
	}

	/**
	 * This component contains the start and end date/times which define the period
	 * in which this address was valid
	 * 
	 * @return
	 */
	public String getAddressValidityRange() {
		return repetitionValue.getHL7ComponentValue(11);
	}
}
