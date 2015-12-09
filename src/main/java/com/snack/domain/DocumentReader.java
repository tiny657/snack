package com.snack.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class DocumentReader {
	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "document_id")
	private Document document;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User reader;

	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;
}
