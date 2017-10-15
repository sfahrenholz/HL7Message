package com.sefah.hl7.message.components;

import com.sefah.hl7.message.lists.HL7ComponentList;

public class HL7Repetition {

	private final HL7ComponentList hl7Components;
	private final String repetitionValue;

	public HL7Repetition(final String hl7Component, final HL7Encoding encoding) {
		hl7Components = new HL7ComponentList();
		repetitionValue = hl7Component;
		parseHL7Component(hl7Component, encoding);
	}

	private void parseHL7Component(final String hl7Field, final HL7Encoding encoding) {
		final String componentSeperator = encoding.getComponentSeperator();
		if (hl7Field.contains(componentSeperator)) {
			final String[] split = hl7Field.split(encoding.getEscapeCharacter() + componentSeperator, 0);

			for (final String string : split) {
				hl7Components.add(new HL7Component(string, encoding));
			}
		} else {
			hl7Components.add(new HL7Component(hl7Field, encoding));
		}

	}

	public HL7Component getHL7Component(final int componentIndex) {
		if (hasValidHL7Component(componentIndex)) {
			return hl7Components.get(componentIndex);
		}

		return null;
	}

	public boolean hasValidHL7Component(final int componentIndex) {
		return componentIndex >= 0 && componentIndex < getHL7ComponentCount();
	}

	public String getHL7ComponentValue(final int componentIndex) {
		final HL7Component hl7Component = getHL7Component(componentIndex);
		if (hl7Component != null) {
			return hl7Component.getComponentValue();
		}

		return "";
	}

	public int getHL7ComponentCount() {
		return hl7Components.size();
	}

	public String getHL7RepetitionValue() {
		return repetitionValue;
	}
}
