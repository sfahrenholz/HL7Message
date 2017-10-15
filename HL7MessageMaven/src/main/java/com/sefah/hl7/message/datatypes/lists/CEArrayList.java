package com.sefah.hl7.message.datatypes.lists;

import java.util.ArrayList;

import com.sefah.hl7.message.components.HL7Field;
import com.sefah.hl7.message.components.HL7Repetition;
import com.sefah.hl7.message.datatypes.CE;
import com.sefah.hl7.message.lists.HL7RepetitionList;

/**
 * Class for an ArrayList for the datatype CE.
 * 
 * @author Sebastian Fahrenholz
 *
 */
public class CEArrayList extends ArrayList<CE> {

	private static final long serialVersionUID = -7964524536334705234L;

	public CEArrayList(final HL7Field hl7Field) {
		final HL7RepetitionList allHL7Repetitions = hl7Field.getAllHL7Repetitions();
		for (final HL7Repetition hl7Repetition : allHL7Repetitions) {
			this.add(new CE(hl7Repetition));
		}
	}
}
