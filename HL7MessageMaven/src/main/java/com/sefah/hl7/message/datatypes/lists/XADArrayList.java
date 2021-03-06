package com.sefah.hl7.message.datatypes.lists;

import java.util.ArrayList;

import com.sefah.hl7.message.components.HL7Field;
import com.sefah.hl7.message.components.HL7Repetition;
import com.sefah.hl7.message.datatypes.XAD;
import com.sefah.hl7.message.lists.HL7RepetitionList;

/**
 * Class for an ArrayList for the datatype XAD.
 * 
 * @author Sebastian Fahrenholz
 *
 */
public class XADArrayList extends ArrayList<XAD> {

	private static final long serialVersionUID = -7964524536334705234L;

	public XADArrayList(final HL7Field hl7Field) {
		final HL7RepetitionList allHL7Repetitions = hl7Field.getAllHL7Repetitions();
		for (final HL7Repetition hl7Repetition : allHL7Repetitions) {
			this.add(new XAD(hl7Repetition));
		}
	}
}
