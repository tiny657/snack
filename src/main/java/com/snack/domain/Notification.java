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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User receiver;

	private String message;

	private Boolean see;

	private Boolean deleted;

	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;
}
