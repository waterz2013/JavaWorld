package com.zjhcsoft.util;

public class StringUtil {
	/**
	 * Checks if a string is empty (ie is null or empty).
	 */
	public static boolean isEmpty(String str) {
		return (str == null) || (str.equals(""));
	}
}
