package com.snack.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class DocumentSkillHistory {
	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "document_id")
	private Document document;

	@ManyToOne
	@JoinColumn(name = "skill_id")
	private Skill skill;

	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;

	private Boolean self;
}
