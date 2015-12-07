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

	private String name;

	private Integer point;

	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	private List<Document> myDocuments = Lists.newArrayList();

	private Integer myDocumentCount;

	@OneToMany(mappedBy = "writer", cascade = CascadeType.ALL)
	private List<Comment> myComments = Lists.newArrayList();

	private Integer myCommentCount;

	@OneToMany(mappedBy = "keeper", cascade = CascadeType.ALL)
	private List<DocumentKeeper> myKeptDocuments = Lists.newArrayList();

	private Integer myKeepCount;

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private List<SkillOwner> mySkills = Lists.newArrayList();

	private Integer mySkillCount;

	@OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
	private List<Notification> notifications = Lists.newArrayList();

	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;

	private Boolean admin;
}
