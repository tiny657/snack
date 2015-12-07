package com.snack.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class DocumentSkill {
	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "document_id")
	private Document document;

	@ManyToOne
	@JoinColumn(name = "skill_id")
	private Skill skill;

	private Boolean self;
}
