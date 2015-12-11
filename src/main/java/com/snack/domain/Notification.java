package com.snack.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Notification {
	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id")
	private User receiver;

	@Column(nullable = false)
	private String message;

	@Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
	private Boolean see;

	@Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
	private Boolean deleted;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;
}
