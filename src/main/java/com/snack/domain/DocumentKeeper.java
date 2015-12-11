package com.snack.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class DocumentKeeper {
	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@Column(nullable = false)
	@JoinColumn(name = "document_id")
	private Document document;

	@ManyToOne
	@Column(nullable = false)
	@JoinColumn(name = "user_id")
	private User keeper;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;
}
