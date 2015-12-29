package com.snack.document;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class DocumentForm {
	@NotNull
	@Size(min = 1, max = 255)
	private String title;

	@NotNull
	private String content;

	@NotNull
	private String skill;

	private String userId;
}
