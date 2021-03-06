package com.snack.attachment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Attachment {
	@Id
	@GeneratedValue
	private Integer id;

	@Column(nullable = false)
	private String filename;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate = new Date();

	@Column(nullable = false)
	private String mimeType;
}
