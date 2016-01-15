package com.snack.document;

import org.springframework.util.StringUtils;

import java.net.MalformedURLException;
import java.net.URL;

public class Utils {
	public static String escape(String content) {
		return StringUtils.replace(content, "<", "&lt;");
	}

	public static String getPath(String referer) {
		String path = "/";
		try {
			path = new URL(referer).getPath();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return path;
	}
}
