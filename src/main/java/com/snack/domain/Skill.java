package com.snack.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Skill {
	@Id
	@GeneratedValue
	@Column(name = "skill_id")
	private Integer id;

	@Column(nullable = false)
	private String name;

	@OneToMany(mappedBy = "skill", cascade = CascadeType.ALL)
	private List<DocumentSkill> documents;

	@Column(nullable = false, columnDefinition = "INT DEFAULT 0")
	private Integer documentCount;

	@Column(nullable = false, columnDefinition = "INT DEFAULT 0")
	private Integer point;
}
