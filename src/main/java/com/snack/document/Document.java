package com.snack.document;

import com.github.rjeschke.txtmark.Processor;
import com.google.common.collect.Lists;
import com.snack.comment.Comment;
import com.snack.document.meta.DocumentKeeper;
import com.snack.document.meta.DocumentSharer;
import com.snack.document.meta.DocumentSkill;
import com.snack.document.meta.DocumentViewer;
import com.snack.user.User;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringEscapeUtils;

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

	@Transient
	private String htmlContent;

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
	private List<DocumentViewer> viewers = Lists.newArrayList();

	@Column(nullable = false, columnDefinition = "INT DEFAULT 0")
	private Integer viewerCount = 0;

	@OneToMany(mappedBy = "document", cascade = CascadeType.ALL)
	private List<DocumentSkill> skills = Lists.newArrayList();

	@Column(nullable = false, columnDefinition = "INT DEFAULT 0")
	private Integer skillCount = 0;

	@OneToMany(mappedBy = "document", cascade = CascadeType.ALL)
	private List<DocumentSharer> sharers = Lists.newArrayList();

	@Column(nullable = false, columnDefinition = "INT DEFAULT 0")
	private Integer sharerCount = 0;

	public void increaseCommentCount() {
		commentCount++;
	}

	public void increaseKeeperCount() {
		keeperCount++;
	}

	public void increaseViewerCount() {
		viewerCount++;
	}
	public void increaseSkillCount() {
		skillCount++;
	}

	public void increaseShareCount() {
		sharerCount++;
	}

	public void convertToDisplay() {
		htmlContent();
		displayRegDate();
		comments.forEach(Comment::convertToDisplay);
	}

	private void htmlContent() {
		htmlContent = Processor.process(StringEscapeUtils.escapeHtml4(content));
	}

	private void displayRegDate() {
		final String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(editDate);
		month = months[calendar.get(Calendar.MONTH)];
		day = calendar.get(Calendar.DAY_OF_MONTH);
	}
}
