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
public class Document {
	@Id
	@GeneratedValue
	@Column(name = "document_id")
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "document", cascade = CascadeType.ALL)
	private List<Comment> comments = Lists.newArrayList();

	private String title;
	private String content;
	private Integer savedCount;
	private Integer likeCount;
	private Integer commentCount;
	private Date postDate;
	private Date modifiedDate;
}
