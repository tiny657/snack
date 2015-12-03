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
	private Integer level;
	private Integer point;
	private Integer documentCount;
	private Integer commentCount;
	private Integer likeCount;
	private Date regDate;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Document> documents = Lists.newArrayList();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Comment> comments = Lists.newArrayList();
}
