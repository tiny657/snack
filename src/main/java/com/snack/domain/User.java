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

	private Integer documentCount;

	@OneToMany(mappedBy = "writer", cascade = CascadeType.ALL)
	private List<Comment> comments = Lists.newArrayList();

	private Integer commentCount;

	@OneToMany(mappedBy = "keeper", cascade = CascadeType.ALL)
	private List<DocumentKeeper> documentKeepers = Lists.newArrayList();

	private Integer keepCount;

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private List<SkillOwner> skillOwners = Lists.newArrayList();

	private Integer skillOwnerCount;

	@OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
	private List<Notification> notifications = Lists.newArrayList();

	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;

	private Boolean admin;
}
