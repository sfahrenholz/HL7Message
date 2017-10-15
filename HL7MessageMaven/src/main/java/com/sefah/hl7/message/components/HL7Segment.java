package com.sefah.hl7.message.components;

import com.sefah.hl7.exception.HL7ParseException;
import com.sefah.hl7.message.HL7DateTime;
import com.sefah.hl7.message.lists.HL7FieldList;
import com.sefah.hl7.message.segment.SegmentName;
import com.sefah.utils.string.StringUtils;

public class HL7Segment {

	private final String hl7SegmentValue;
	private final HL7Encoding encoding;
	private final HL7FieldList hl7Fields;
	private String segmentType;

	public HL7Segment(final String segment, final HL7Encoding encoding) {
		hl7Fields = new HL7FieldList();
		hl7SegmentValue = segment;
		this.encoding = encoding;
		parseHL7Field(segment, encoding);
	}

	private void parseHL7Field(final String segment, final HL7Encoding encoding) {
		final String fieldSeperator = encoding.getFieldSeperator();
		final String[] split = segment.split(encoding.getEscapeCharacter() + fieldSeperator);

		if (SegmentName.MSH.equals(split[0])) {
			restoreEncodingValue(split, encoding);
		}

		segmentType = split[0];

		for (final String string : split) {
			hl7Fields.add(new HL7Field(string, encoding));
		}
	}

	private void restoreEncodingValue(final String[] split, final HL7Encoding seperators) {
		if (split.length > 2) {
			split[1] = seperators.getMSH2Field();
		}
	}

	public String getSegmentType() {
		return segmentType;
	}

	public int getHL7FieldCount() {
		return hl7Fields.size();
	}

	public String getHL7FieldAsString(final int fieldIndex) {
		return getHL7Field(fieldIndex).getValue();
	}
	
	public HL7Field getHL7Field(final int fieldIndex) {
		if (hasValidHL7Field(fieldIndex)) {
			return hl7Fields.get(fieldIndex);
		}

		return new HL7Field("");
	}

	public HL7DateTime getHL7FieldAsHL7Date(final int fieldIndex) throws HL7ParseException {
		if (hasValidHL7Field(fieldIndex)) {
			String dateValue = getHL7Value(fieldIndex);
			if (StringUtils.isDefined(dateValue)) {
				return new HL7DateTime(dateValue);
			}
		}
		return null;
	}

	public Integer getHL7FieldAsInteger(final int fieldIndex) {
		if (hasValidHL7Field(fieldIndex)) {
			final String hl7Value = getHL7Value(fieldIndex);
			if (StringUtils.isDefined(hl7Value)) {
				return Integer.parseInt(hl7Value);
			}
		}
		return null;
	}

	public String getHL7Value(final int fieldIndex) {
		return getHL7Value(fieldIndex, -1);
	}

	public String getHL7Value(final int fieldIndex, final int repetitionIndex) {
		return getHL7Value(fieldIndex, repetitionIndex, -1);
	}

	public String getHL7Value(final int fieldIndex, final int repetitionIndex, final int componentIndex) {
		return getHL7Value(fieldIndex, repetitionIndex, componentIndex, -1);
	}

	public String getHL7Value(final int fieldIndex, final int repetitionIndex, final int componentIndex,
			final int subComponentIndex) {

		if (hasValidHL7Field(fieldIndex)) {
			return handleHL7Values(fieldIndex, repetitionIndex, componentIndex, subComponentIndex);
		}

		return getHl7SegmentValue();
	}

	public boolean hasValidHL7Field(final int fieldIndex) {
		return fieldIndex >= 0 && fieldIndex < getHL7FieldCount();
	}

	private String handleHL7Values(final int fieldIndex, final int repetitionIndex, final int componentIndex,
			final int subComponentIndex) {
		final HL7Field hl7Field = hl7Fields.get(fieldIndex);
		if (hl7Field != null) {

			final HL7Repetition hl7Repetition = hl7Field.getHL7Repetition(repetitionIndex);
			if (hl7Repetition != null) {

				final HL7Component hl7Component = hl7Repetition.getHL7Component(componentIndex);
				if (hl7Component != null) {

					final HL7SubComponent hl7SubComponent = hl7Component.getHL7SubComponent(subComponentIndex);
					if (hl7SubComponent != null) {
						return hl7SubComponent.getSubComponentValue();
					}

					return hl7Component.getComponentValue();
				}

				return hl7Repetition.getHL7RepetitionValue();
			}

			return hl7Field.getValue();
		}

		return "";
	}

	public String getHl7SegmentValue() {
		return hl7SegmentValue;
	}

	public HL7Encoding getEncoding() {
		return encoding;
	}

}
