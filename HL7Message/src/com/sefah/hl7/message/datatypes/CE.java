package com.sefah.hl7.message.datatypes;

import com.sefah.hl7.message.components.HL7Repetition;

/**
 * Components: <identifier (ST)> ^ <text (ST)> ^ <name of coding system (IS)> ^
 * <alternate identifier (ST)> ^ <alternate text (ST)> ^ <name of alternate
 * coding system (IS)>
 *
 * Length: 250
 *
 * This data type transmits codes and the text associated with the code.
 *
 * @author Sebastian Fahrenholz
 *
 */
public class CE extends Datatype {
	public CE(HL7Repetition datatype) {
		super(datatype);
	}

	/**
	 * Sequence of characters (the code) that uniquely identifies the item being
	 * referenced by the <text>. Different coding schemes will have different
	 * elements here
	 * 
	 * @return
	 */
	public String getIdentifier() {
		return repetitionValue.getHL7ComponentValue(0);
	}

	/**
	 * Name or description of the item in question. E.g., myocardial infarction or
	 * X-ray impression. Its data type is string (ST).
	 * 
	 * @return
	 */
	public String getText() {
		return repetitionValue.getHL7ComponentValue(1);
	}

	/**
	 * Each coding system is assigned a unique identifier. This component will serve
	 * to identify the coding scheme being used in the identifier component. The
	 * combination of the identifier and name of coding system components will be a
	 * unique code for a data item. Each system has a unique identifier.
	 * 
	 * @return
	 */
	public String getCodingSystem() {
		return repetitionValue.getHL7ComponentValue(2);
	}

	public String getAlternateIdentifier() {
		return repetitionValue.getHL7ComponentValue(3);
	}

	public String getAlternateText() {
		return repetitionValue.getHL7ComponentValue(4);
	}

	public String getAlternativeCodingSystem() {
		return repetitionValue.getHL7ComponentValue(5);
	}
}
