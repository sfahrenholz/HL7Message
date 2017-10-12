package com.sefah.utils.string;

public class StringUtils {

	private StringUtils() {
		// NOSONAR
	}

	/**
	 * Returns true, when the string is not null and the length greater then 0
	 * examples: content = null > false content = "" > false content = "A" >
	 * true
	 * 
	 * @param characterRegex
	 * @return boolean
	 */
	public static boolean isDefined(String characterRegex) {
		return characterRegex != null && characterRegex.trim().length() > 0;
	}
}
