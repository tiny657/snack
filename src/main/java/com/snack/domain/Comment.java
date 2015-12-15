package com.snack.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
@Entity
public class Comment {
	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id")
	private User writer;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "document_id")
	private Document document;

	@Column(nullable = false)
	private String content;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate = new Date();

	@Transient
	private String displayRegDate;

	public void displayRegDate() {
		final String[] MONTHS = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November",
			"December" };
		final String[] AM_PM = { "am", "pm" };
		
		Calendar calendar = Calendar.getInstance();
		displayRegDate = new StringBuilder()
			.append(MONTHS[calendar.get(Calendar.MONTH)]).append(" ")
			.append(calendar.get(Calendar.DAY_OF_MONTH)).append(", ")
			.append(calendar.get(Calendar.YEAR)).append(" at ")
			.append(calendar.get(Calendar.HOUR)).append(":")
			.append(calendar.get(Calendar.MINUTE)).append(" ")
			.append(AM_PM[calendar.get(Calendar.AM_PM)]).toString();
	}
}
