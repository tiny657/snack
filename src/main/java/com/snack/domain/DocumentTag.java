package com.snack.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class DocumentTag {
	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "document_id")
	private Document document;

	@ManyToOne
	@JoinColumn(name = "tag_id")
	private Tag tag;

	private Boolean self;
}
