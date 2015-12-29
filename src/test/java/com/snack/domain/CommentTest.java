package com.snack.domain;

import com.snack.comment.Comment;
import org.junit.Test;

import java.util.Date;

public class CommentTest {

	@Test
	public void convertDate() throws Exception {
		// Given
		Comment comment = new Comment();
		comment.setRegDate(new Date());

		// When
		comment.displayRegDate();

		// Then
		System.out.println(comment.getDisplayRegDate());
	}
}
