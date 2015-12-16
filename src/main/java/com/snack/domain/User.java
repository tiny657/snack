package com.snack.domain;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class User {
	@Id
	@Column(name = "user_id")
	private String userId;

	@Column(nullable = false)
	private String name;

	@Column
	private String description;

	@Column(nullable = false, columnDefinition = "INT DEFAULT 0")
	private Integer point = 0;

	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	private List<Document> myDocuments = Lists.newArrayList();

	@Column(nullable = false, columnDefinition = "INT DEFAULT 0")
	private Integer myDocumentCount = 0;

	@OneToMany(mappedBy = "writer", cascade = CascadeType.ALL)
	private List<Comment> myComments = Lists.newArrayList();

	@Column(nullable = false, columnDefinition = "INT DEFAULT 0")
	private Integer myCommentCount = 0;

	@OneToMany(mappedBy = "viewer", cascade = CascadeType.ALL)
	private List<DocumentViewer> myViewDocuments = Lists.newArrayList();

	@Column(nullable = false, columnDefinition = "INT DEFAULT 0")
	private Integer myViewDocumentCount = 0;

	@OneToMany(mappedBy = "keeper", cascade = CascadeType.ALL)
	private List<DocumentKeeper> myKeepDocuments = Lists.newArrayList();

	@Column(nullable = false, columnDefinition = "INT DEFAULT 0")
	private Integer myKeepCount = 0;

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private List<SkillOwner> mySkills = Lists.newArrayList();

	@OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
	private List<Notification> notifications = Lists.newArrayList();

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate = new Date();

	@Column(nullable = false, columnDefinition = "BIT DEFAULT 0")
	private Boolean admin = false;

	public void increaseMyDocumentCount() {
		myDocumentCount++;
	}

	public void increaseMyViewDocumentCount() {
		myViewDocumentCount++;
	}

	public void increaseMyCommentCount() {
		myCommentCount++;
	}

	public void increaseMyKeepCount() {
		myKeepCount++;
	}
}
