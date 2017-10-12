package com.sefah.hl7.message.segment;

import com.sefah.hl7.message.components.HL7Segment;

/**
 * Class to get the SegmentClass for the specify HL7 Segments. If the Type (for
 * example MSH, MRG) not know, it use the HL7Segment-ClassA
 * 
 * @author Sebastian Fahrenholz
 *
 */
public abstract class SegmentName {
	public static final String MSH = "MSH";
	public static final String PID = "PID";

	private SegmentName() {
		// SQ
	}

	public static Class<? extends HL7Segment> getSegmentClass(final String segmentName) {
		if (segmentName == null) {
			return null;
		}

		switch (segmentName) {
		case MSH:
			return MSHSegment.class;
		case PID:
			return PIDSegment.class;
		default:
			return HL7Segment.class;
		}
	}
}
