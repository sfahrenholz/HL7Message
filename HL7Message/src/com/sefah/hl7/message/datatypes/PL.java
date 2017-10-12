package com.sefah.hl7.message.datatypes;

import com.sefah.hl7.message.components.HL7Repetition;

/**
 * PL - person location
 * 
 * Components: <point of care (IS)> ^ <room (IS)> ^ <bed (IS)> ^ <facility (HD)>
 * ^ <location status (IS )> ^ <person location type (IS)> ^ <building (IS )> ^
 * <floor (IS)> ^ <location description (ST)>
 * 
 * Note: This data type contains several location identifiers that should be
 * thought of in the following order from the most general to the most specific:
 * facility, building, floor, point of care, room, bed.
 * 
 * Additional data about any location defined by these components can be added
 * in the following components: person location type, location description and
 * location status.
 * 
 * @author Sebastian Fahrenhloz
 *
 */
public class PL extends Datatype {

	public PL(HL7Repetition datatype) {
		super(datatype);
	}

	/**
	 * Conditional on person location type (e.g., nursing unit or department or
	 * clinic). After floor, most general patient location designation. User-defined
	 * Table 0302 - Point of care is used as the HL7 identifier for the user-defined
	 * table of values for this component.
	 * 
	 * @return
	 */
	public String getPointOfCare() {
		return repetitionValue.getHL7ComponentValue(0);
	}

	/**
	 * Patient room. After point of care, most general person location designation.
	 * User-defined Table 0303 - Room is used as the HL7 identifier for the
	 * user-defined table of values for this component.
	 * 
	 * @return
	 */
	public String getRoom() {
		return repetitionValue.getHL7ComponentValue(1);
	}

	/**
	 * Patient bed. After room, most general person location designation.
	 * User-defined Table 0304 - Bed is used as the HL7 identifier for the
	 * user-defined table of values for this component.
	 * 
	 * @return
	 */
	public String getBed() {
		return repetitionValue.getHL7ComponentValue(2);
	}

	/**
	 * Subject to site interpretation but generally describes the highest level
	 * physical designation of an institution, medical centre or enterprise. Most
	 * general person location designation. (See HD - hierarchic designator) for
	 * discussion of data type.
	 * 
	 * @return
	 */
	public String getFacility() {
		return repetitionValue.getHL7ComponentValue(3);
	}

	/**
	 * Location (e.g., Bed) status. User-defined Table 0306 - Location status is
	 * used as the HL7 identifier for the user-defined table of values for this
	 * component.
	 * 
	 * @return
	 */
	public String getLocationStatus() {
		return repetitionValue.getHL7ComponentValue(4);
	}

	/**
	 * Person location type is the categorization of the person’s location defined
	 * by facility, building, floor, point of care, room or bed. Although not a
	 * required field, when used, it may be the only populated field. Usually
	 * includes values such as nursing unit, department, clinic, SNF, physician’s
	 * office
	 * 
	 * @return
	 */
	public String getPersonLocationType() {
		return repetitionValue.getHL7ComponentValue(5);
	}

	/**
	 * After facility, most general person location designation. User-defined Table
	 * 0307 - Building is used as the HL7 identifier for the user-defined table of
	 * values for this component.
	 * 
	 * @return
	 */
	public String getBuilding() {
		return repetitionValue.getHL7ComponentValue(6);
	}

	/**
	 * After building, most general person location designation. User-defined Table
	 * 0308 - Floor is used as the HL7 identifier for the user-defined table of
	 * values for this component.
	 * 
	 * @return
	 */
	public String getFloor() {
		return repetitionValue.getHL7ComponentValue(7);
	}

	/**
	 * A free text description of the location.
	 * 
	 * @return
	 */
	public String getLocationDescription() {
		return repetitionValue.getHL7ComponentValue(8);
	}
}
