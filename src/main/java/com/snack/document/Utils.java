package com.snack.document;

import org.springframework.util.StringUtils;

public class Utils {
	public static String escape(String content) {
		return StringUtils.replace(content, "<", "&lt;");
	}
}
