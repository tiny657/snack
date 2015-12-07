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

	private String title;
	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	private Date postDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User author;

	@OneToMany(mappedBy = "document", cascade = CascadeType.ALL)
	private List<Comment> comments = Lists.newArrayList();

	private Integer commentCount;

	@OneToMany(mappedBy = "document", cascade = CascadeType.ALL)
	private List<DocumentKeeper> keeper = Lists.newArrayList();

	private Integer keeperCount;

	@OneToMany(mappedBy = "document", cascade = CascadeType.ALL)
	private List<DocumentTag> documentTags = Lists.newArrayList();

	private Integer tagCount;
}
