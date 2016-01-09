package com.snack.document;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class UtilsTest {
	@Test
	public void escape() {
		// Given
		String s1 = "[enter](http://aa)";
		String s2 = "![enter](http://aa \"enter image title here\")";
		String s3 = "> 1234";
		String s4 = "<script>";

		// When
		String es1 = Utils.escape(s1);
		String es2 = Utils.escape(s2);
		String es3 = Utils.escape(s3);
		String es4 = Utils.escape(s4);

//		 Then
		assertThat(es1).isEqualTo("[enter](http://aa)");
		assertThat(es2).isEqualTo("![enter](http://aa \"enter image title here\")");
		assertThat(es3).isEqualTo("> 1234");
		assertThat(es4).isEqualTo("&lt;script>");
	}
}
