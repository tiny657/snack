package com.snack.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Comment {
	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@Column(nullable = false)
	@JoinColumn(name = "user_id")
	private User writer;

	@ManyToOne(fetch = FetchType.LAZY)
	@Column(nullable = false)
	@JoinColumn(name = "document_id")
	private Document document;

	@Column(nullable = false)
	private String content;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;
}
