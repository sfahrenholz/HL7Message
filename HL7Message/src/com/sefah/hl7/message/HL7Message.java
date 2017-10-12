package com.sefah.hl7.message;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.sefah.hl7.exception.HL7EncodingException;
import com.sefah.hl7.exception.HL7MessageErrorCode;
import com.sefah.hl7.exception.HL7MessageException;
import com.sefah.hl7.exception.HL7ParseException;
import com.sefah.hl7.message.components.HL7Encoding;
import com.sefah.hl7.message.components.HL7Segment;
import com.sefah.hl7.message.lists.HL7SegmentList;
import com.sefah.hl7.message.segment.SegmentName;

/**
 * HL7Message Object. Converts the String-Value to an HL7 Message Object.
 * 
 * @author Sebastian Fahrenholz
 *
 */
public class HL7Message {
	private static final String CR = "\r";
	private static final String LF = "\n";
	private static final String CR_LF = CR + LF;

	private final String originalMessageText;
	private final HL7Encoding seperators;
	private final HL7SegmentList hl7Segments;

	public HL7Message(final String messageText) throws HL7MessageException {
		hl7Segments = new HL7SegmentList();
		seperators = detectingHL7Seperators(messageText);
		originalMessageText = messageText;
		parseHL7Message(messageText);
	}

	private void parseHL7Message(final String messageText) throws HL7MessageException {
		checkMessageIsMacEncoding(messageText);
		final String[] split = messageText.split(CR);

		for (final String segmentValue : split) {
			hl7Segments.add(getHL7Segment(segmentValue));
		}
	}

	private void checkMessageIsMacEncoding(String messageText) throws HL7MessageException {
		if (messageText.contains(LF) || messageText.contains(CR_LF)) {
			throw new HL7MessageException(HL7MessageErrorCode.HL7_MESSAGE_ENCODING);
		}
	}

	private HL7Segment getHL7Segment(final String segmentText) throws HL7ParseException {
		final String segmentType = getSegmentType(segmentText);
		try {
			final Class<? extends HL7Segment> segmentClass = SegmentName.getSegmentClass(segmentType);
			final Constructor<? extends HL7Segment> constructor = segmentClass.getConstructor(String.class,
					HL7Encoding.class);

			if (constructor == null) {
				throw new HL7ParseException(HL7MessageErrorCode.HL7_MESSAGE_ERROR_FIND_SEGMENT, segmentType);
			}

			return constructor.newInstance(segmentText, seperators);
		} catch (NoSuchMethodException | InstantiationException | IllegalAccessException
				| InvocationTargetException e) {
			throw new HL7ParseException(HL7MessageErrorCode.HL7_MESSAGE_ERROR_FIND_SEGMENT, e.getMessage());
		}
	}

	private String getSegmentType(final String segmentText) {
		return segmentText.substring(0, 3);
	}

	private HL7Encoding detectingHL7Seperators(final String messageText) throws HL7EncodingException {
		if (Boolean.getBoolean("readEncodingFromMessage") && messageText.startsWith(SegmentName.MSH)) {
			return new HL7Encoding(messageText.substring(3, 8));
		}

		return new HL7Encoding();
	}

	/**
	 * Returns the count value of hl7 segments.
	 */
	public int getSegmentCount() {
		return hl7Segments.size();
	}

	/**
	 * returns the HL7Segment of the SegmentType-String. It can be
	 * <code>null</code>.
	 */
	public HL7Segment getSegment(final String string) {
		return hl7Segments.getSegmentByType(string);
	}

	/**
	 * returns the HL7Segment of the SegmentType-String. It can be
	 * <code>null</code>.
	 */
	public HL7Segment getSegment(final String string, final int segIndex) {
		return hl7Segments.getSegmentByType(string, segIndex);
	}

	/**
	 * returns the original hl7 message string.
	 */
	public String getOriginalMessageText() {
		return originalMessageText;
	}
}
