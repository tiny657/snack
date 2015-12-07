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
	@Column(name = "notification_id")
	private String id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User receiver;

	private String message;

	private Boolean read;

	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;
}
