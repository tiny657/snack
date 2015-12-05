package com.snack.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Tag {
	@Id
	@GeneratedValue
	@Column(name = "tag_id")
	private Integer id;

	private String name;

	@OneToMany(mappedBy = "tag", cascade = CascadeType.ALL)
	private List<DocumentTag> documentTags;

	private Integer documentCount;
}
