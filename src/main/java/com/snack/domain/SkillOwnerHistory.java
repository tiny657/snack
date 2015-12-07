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

	@ManyToOne
	@JoinColumn(name = "skill_id")
	private Skill skill;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User owner;

	private Integer rank;

	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;
}
