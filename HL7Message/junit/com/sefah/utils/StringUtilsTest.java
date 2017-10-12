package com.sefah.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

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