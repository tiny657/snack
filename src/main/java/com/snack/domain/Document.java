package com.snack.domain;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Document {
	@Id
	@GeneratedValue
	@Column(name = "document_id")
	private Integer id;

	@Column(nullable = false, columnDefinition = "INT DEFAULT 0")
	private Integer point = 0;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String content;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate = new Date();

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date editDate = new Date();

	@Transient
	private String month;

	@Transient
	private int day;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id")
	private User author;

	@OneToMany(mappedBy = "document", cascade = CascadeType.ALL)
	private List<Comment> comments = Lists.newArrayList();

	@Column(nullable = false, columnDefinition = "INT DEFAULT 0")
	private Integer commentCount = 0;

	@OneToMany(mappedBy = "document", cascade = CascadeType.ALL)
	private List<DocumentKeeper> keepers = Lists.newArrayList();

	@Column(nullable = false, columnDefinition = "INT DEFAULT 0")
	private Integer keeperCount = 0;

	@OneToMany(mappedBy = "document", cascade = CascadeType.ALL)
	private List<DocumentReader> readers = Lists.newArrayList();

	@Column(nullable = false, columnDefinition = "INT DEFAULT 0")
	private Integer readerCount = 0;

	@OneToMany(mappedBy = "document", cascade = CascadeType.ALL)
	private List<DocumentSkill> skills = Lists.newArrayList();

	@Column(nullable = false, columnDefinition = "INT DEFAULT 0")
	private Integer skillCount = 0;

	public void increaseCommentCount() {
		commentCount++;
	}

	public void increaseKeeperCount() {
		keeperCount++;
	}

	public void increaseReaderCount() {
		readerCount++;
	}

	public void increaseSkillCount() {
		skillCount++;
	}

	public void convertDate() {
		final String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		Calendar instance = Calendar.getInstance();
		instance.setTime(editDate);
		month = months[instance.get(Calendar.MONTH)];
		day = instance.get(Calendar.DAY_OF_MONTH);
	}
}
