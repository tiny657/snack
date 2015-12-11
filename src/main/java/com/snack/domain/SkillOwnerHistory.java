package com.snack.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class SkillOwnerHistory {
	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "skill_id")
	private Skill skill;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id")
	private User owner;

	@Column(nullable = false, columnDefinition = "INT DEFAULT 0")
	private Integer rank;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;
}
