package com.snack.comment;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CommentForm {
	@NotNull
	private String userId;

	@NotNull
	@Size(min = 1)
	private String content;
}
