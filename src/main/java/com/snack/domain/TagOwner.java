package com.snack.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class TagOwner {
	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "tag_id")
	private Tag tag;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User owner;

	private Integer preRank;
	private Integer rank;

	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;
}
