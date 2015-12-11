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

	@OneToMany(mappedBy = "keeper", cascade = CascadeType.ALL)
	private List<DocumentKeeper> myKeptDocuments = Lists.newArrayList();

	@Column(nullable = false, columnDefinition = "INT DEFAULT 0")
	private Integer myKeepCount = 0;

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private List<SkillOwner> mySkills = Lists.newArrayList();

	@Column(nullable = false, columnDefinition = "INT DEFAULT 0")
	private Integer mySkillCount = 0;

	@OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
	private List<Notification> notifications = Lists.newArrayList();

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;

	@Column(nullable = false, columnDefinition = "BIT DEFAULT 0")
	private Boolean admin = false;
}
