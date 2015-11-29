package com.snack.domain;

import com.google.common.collect.Lists;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class User {
	@Id
	@Column(name = "USER_ID")
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
