package com.sefah.hl7.message.components;

import com.sefah.hl7.message.lists.HL7SubComponentList;

public class HL7Component {

	private final String componentValue;
	private final HL7SubComponentList hl7SubComponents;

	public HL7Component(final String segment, final HL7Encoding encoding) {
		hl7SubComponents = new HL7SubComponentList();
		componentValue = segment;
		parseHL7SubComponent(segment, encoding);
	}

	private void parseHL7SubComponent(final String hl7Field, final HL7Encoding encoding) {
		final String subcomponentSeperator = encoding.getSubcomponentSeperator();
		if (hl7Field.contains(subcomponentSeperator)) {
			final String[] split = hl7Field.split(encoding.getEscapeCharacter() + subcomponentSeperator);

			for (final String string : split) {
				hl7SubComponents.add(new HL7SubComponent(string));
			}
		} else {
			hl7SubComponents.add(new HL7SubComponent(hl7Field));
		}
	}

	public String getComponentValue() {
		return componentValue;
	}

	public HL7SubComponent getHL7SubComponent(final int subComponentIndex) {
		if (hasValidHL7SubComponent(subComponentIndex)) {
			return hl7SubComponents.get(subComponentIndex);
		}

		return null;
	}

	private boolean hasValidHL7SubComponent(final int subComponentIndex) {
		return subComponentIndex >= 0 && subComponentIndex < getHL7SubComponentCount();
	}

	public String getHL7SubComponentValue(final int subComponentIndex) {
		final HL7SubComponent hl7SubComponent = getHL7SubComponent(subComponentIndex);
		if (hl7SubComponent != null) {
			return hl7SubComponent.getSubComponentValue();
		}

		return "";
	}

	public int getHL7SubComponentCount() {
		return hl7SubComponents.size();
	}
}
