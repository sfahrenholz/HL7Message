package com.sefah.utils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import com.sefah.utils.string.StringUtils;

/**
 * @author Basti
 * @created 29.05.2016 21:03:21
 */
public class StringUtilsTest {

	@Test
	public void testIsDefinedString() {
		assertFalse(StringUtils.isDefined(""));
		assertFalse(StringUtils.isDefined((String) null));
		assertTrue(StringUtils.isDefined("Hey Ho"));
		assertTrue(StringUtils.isDefined("12"));
	}
}