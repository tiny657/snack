package com.snack.document.meta;

import com.snack.document.Document;
import com.snack.skill.Skill;
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

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "document_id")
	private Document document;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "skill_id")
	private Skill skill;

	@Column(nullable = false, columnDefinition = "BIT DEFAULT 1")
	private Boolean self = true;
}
